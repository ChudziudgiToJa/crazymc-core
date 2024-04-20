package pl.crazymc.core.inventories;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import pl.crazymc.core.objects.Block;
import pl.crazymc.core.utils.GlassPane;
import pl.crazymc.core.builders.InventoryBuilder;
import pl.crazymc.core.builders.ItemBuilder;

import java.util.Map;

public class BlocksGui {
    public static void open(final Player player) {
        final InventoryBuilder inv = new InventoryBuilder("&8» &aBloki&6:", 45);
        for (Map.Entry<Integer, Block> entry : Block.getBlocks().entrySet()) {
            inv.setItem(entry.getKey(), entry.getValue().getItemStack(), event -> entry.getValue().replaceItems(player));
        }
        inv.setItem(31, new ItemBuilder(Material.HOPPER).setTitle("&fZamien wszystkie sztabki na bloki.").build(), event -> {
            for (Map.Entry<Integer, Block> entry : Block.getBlocks().entrySet()) entry.getValue().replaceItems(player);
        });
        inv.open(player, GlassPane.LIGHT_BLUE);
    }
}
