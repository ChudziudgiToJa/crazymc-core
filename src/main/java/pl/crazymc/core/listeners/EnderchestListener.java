package pl.crazymc.core.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pl.crazymc.core.managers.EnderchestManager;
import pl.crazymc.core.managers.UserManager;
import pl.crazymc.core.objects.User;
import pl.crazymc.core.utils.Util;
import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

public class EnderchestListener implements Listener {
    public static final HashMap<UUID, Long> cooldownPlayers = new HashMap<>();

    @EventHandler
    public void onInventoryClose(final InventoryCloseEvent event) {
        final Player player = (Player) event.getPlayer();
        final Inventory inv = event.getInventory();
        if (inv.getType() == InventoryType.ENDER_CHEST && inv.getType().name().contains("Ender Chest: ")) {
            final String[] split = inv.getType().name().split(": ");
            final User user = UserManager.getUserOrNull(split[1]);
            if (user != null) {
                user.setEnderChest(inv.getContents());
            }
        } else if (inv.getType() == InventoryType.ENDER_CHEST && inv.getType().name().contains("Ender Chest: ")) {
            final User user = UserManager.getUser(player);
            final ItemStack[] current = event.getInventory().getContents();
            final ItemStack[] last = user.getEnderChest();
            if (!Arrays.equals(current, last)) {
                user.setEnderChest(current);
            }
        }
    }

    @EventHandler
    public void onInteract(final InventoryOpenEvent event) {
        final Player player = (Player) event.getPlayer();
        if (event.getInventory().getType().equals(InventoryType.ENDER_CHEST)) {
            event.setCancelled(true);
            if (cooldownPlayers.getOrDefault(player.getUniqueId(), 0L) <= System.currentTimeMillis()) {
                cooldownPlayers.put(player.getUniqueId(), System.currentTimeMillis() + 1000L);
                EnderchestManager.openEnderChest(player);
            } else Util.warning(player, "Blad, nie mozesz tak czesto tego robic!");
        }
    }
}
