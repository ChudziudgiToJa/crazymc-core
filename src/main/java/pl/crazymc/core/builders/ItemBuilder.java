package pl.crazymc.core.builders;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import pl.crazymc.core.utils.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemBuilder {
    private final ItemStack itemStack;

    public ItemBuilder(Material m) {
        this(m, 1);
    }

    public ItemBuilder(ItemStack is) {
        this.itemStack = is;
    }

    public ItemBuilder(Material m, int amount) {
        itemStack = new ItemStack(m, amount);
    }

    public ItemBuilder(Material m, int amount, short data) {
        itemStack = new ItemStack(m, amount, data);
    }

    public ItemBuilder(Material m, short data) {
        itemStack = new ItemStack(m, 1,data);
    }

    public ItemBuilder addLore(final String... lores) {
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setLore(Util.fixColor(Arrays.asList(lores)));
        itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemBuilder addEnchant(final Enchantment enchant, final int level) {
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.addEnchant(enchant, level, true);
        itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemStack build() {
        return itemStack;
    }

    public ItemBuilder noName() {
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(Util.fixColor("&f--=*=--"));
        itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemBuilder setTitle(final String title) {
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(Util.fixColor(title));
        itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemBuilder setGlow(final boolean b) {
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (b) {
            itemMeta.addEnchant(Enchantment.DURABILITY, 1, true);
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemBuilder addLore(final ArrayList<String> list) {
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setLore(Util.fixColor(list));
        itemStack.setItemMeta(itemMeta);
        return this;
    }
    public final ItemBuilder setOwner(final String newowner) {
        final ItemMeta itemMeta = itemStack.getItemMeta();
        ((SkullMeta) itemMeta).setOwner(newowner);
        itemStack.setItemMeta(itemMeta);
        return this;
    }

}