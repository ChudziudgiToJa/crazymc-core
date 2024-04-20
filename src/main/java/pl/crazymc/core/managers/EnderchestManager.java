package pl.crazymc.core.managers;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pl.crazymc.core.objects.User;

public class EnderchestManager {

    public static int getEnderChestSize(final Player player) {
        int size = 27;
        if (player.hasPermission("core.enderchest.row6")) {
            size = 54;
        } else if (player.hasPermission("core.enderchest.row5")) {
            size = 45;
        } else if (player.hasPermission("core.enderchest.row4")) {
            size = 36;
        }
        return size;
    }

    public static void openEnderChest(final Player player) {
        final Inventory inv = Bukkit.createInventory(null, getEnderChestSize(player), "Ender Chest");
        final User user = UserManager.getUser(player);
        int i = 0;
        for (ItemStack itemStack : user.getEnderChest()) {
            if (i < inv.getSize()) inv.setItem(i++, itemStack);
        }
        player.openInventory(inv);
    }

    public static void save() {
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (onlinePlayer.getOpenInventory().getTopInventory().getType().name().equals("Ender Chest")) {
                final User user = UserManager.getUser(onlinePlayer);
                user.setEnderChest(onlinePlayer.getOpenInventory().getTopInventory().getContents());
            }
        }
    }
}
