package pl.crazymc.core.objects;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import pl.crazymc.core.builders.ItemBuilder;
import pl.crazymc.core.utils.Util;

import java.util.HashMap;

public class Block {
    private static final HashMap<Integer, Block> blocks = new HashMap<>();

    static {
        blocks.put(10, new Block(new ItemBuilder(Material.DIAMOND_BLOCK).setTitle("&7Zamien na: &bBloki diamentu").build(), new ItemStack(Material.DIAMOND, 9), new ItemStack(Material.DIAMOND_BLOCK)));
        blocks.put(11, new Block(new ItemBuilder(Material.GOLD_BLOCK).setTitle("&7Zamien na: &6Bloki zlota").build(), new ItemStack(Material.GOLD_INGOT, 9), new ItemStack(Material.GOLD_BLOCK)));
        blocks.put(12, new Block(new ItemBuilder(Material.IRON_BLOCK).setTitle("&7Zamien na: &fBloki zelaza").build(), new ItemStack(Material.IRON_INGOT, 9), new ItemStack(Material.IRON_BLOCK)));
        blocks.put(14, new Block(new ItemBuilder(Material.EMERALD_BLOCK).setTitle("&7Zamien na: &aBloki szmaragdu").build(), new ItemStack(Material.EMERALD, 9), new ItemStack(Material.EMERALD_BLOCK)));
        blocks.put(15, new Block(new ItemBuilder(Material.REDSTONE_BLOCK).setTitle("&7Zamien na: &cBloki redstone").build(), new ItemStack(Material.REDSTONE, 9), new ItemStack(Material.REDSTONE_BLOCK)));
        blocks.put(16, new Block(new ItemBuilder(Material.COAL_BLOCK).setTitle("&7Zamien na: &8Bloki wegla").build(), new ItemStack(Material.COAL, 9), new ItemStack(Material.COAL_BLOCK)));
    }

    private final ItemStack itemStack;
    private final ItemStack fromItemStack;
    private final ItemStack toItemStack;

    public Block(ItemStack itemStack, ItemStack fromItemStack, ItemStack toItemStack) {
        this.itemStack = itemStack;
        this.fromItemStack = fromItemStack;
        this.toItemStack = toItemStack;
    }

    public static HashMap<Integer, Block> getBlocks() {
        return blocks;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public void replaceItems(final Player player) {
        final PlayerInventory inv = player.getInventory();
        final ItemStack fromItemStack = this.fromItemStack.clone();
        final ItemStack toItemStack = this.toItemStack.clone();
        for (int i = 0; i < 256; i++) {
            if (inv.containsAtLeast(fromItemStack, fromItemStack.getAmount())) {
                inv.removeItem(fromItemStack);
                Util.giveItems(player,toItemStack);
            }
        }
    }
}
