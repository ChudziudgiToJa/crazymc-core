package pl.crazymc.core.inventories;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.crazymc.core.objects.Kit;
import pl.crazymc.core.utils.GlassPane;
import pl.crazymc.core.builders.InventoryBuilder;
import pl.crazymc.core.utils.Util;


import java.util.Arrays;
import java.util.Map;

public class KitsGui {
    public static void open(final Player player) {
        final InventoryBuilder inv = new InventoryBuilder("&8» &aZestawy&6:",27);
        for (Map.Entry<Integer, Kit> kits : Kit.getKits().entrySet()) {
            final Kit kit = kits.getValue();
            final ItemStack itemStack = kit.getItemStack().clone();
            final ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setLore(Util.fixColor(Arrays.asList("&7» Dostep do zestawu: &" + (player.hasPermission(kit.getPermission()) ? "a✔" : "c✘"), "&7» Nacisnij &3PPM &7aby odebrac!")));
            itemStack.setItemMeta(itemMeta);
            inv.setItem(kits.getKey(),itemStack,event -> {
                player.closeInventory();
                kit.give(player);
            });
        }
        inv.open(player, GlassPane.LIGHT_BLUE);
    }
}
