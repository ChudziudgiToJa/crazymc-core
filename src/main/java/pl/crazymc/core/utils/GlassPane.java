package pl.crazymc.core.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import pl.crazymc.core.builders.ItemBuilder;

public enum GlassPane {
    WHITE, ORANGE, MAGENTA, LIGHT_BLUE, YELLOW, LIME, PINK, GRAY, LIGHT_GRAY, CYAN, PURPLE, BLUE, BROWN, GREEN, RED, BLACK;

    private final ItemBuilder item;

    GlassPane() {
        item = new ItemBuilder(Material.LIME_STAINED_GLASS_PANE, (short) ordinal()).noName();
    }

    public final ItemStack getItem() {
        return item.build();
    }
}
