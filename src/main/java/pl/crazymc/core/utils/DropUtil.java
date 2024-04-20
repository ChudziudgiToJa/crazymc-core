package pl.crazymc.core.utils;

import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DropUtil {

    public static int addFortuneEnchant(final int amount, final ItemStack tool) {
        int a = amount;
        if (RandomUtil.getChance(30.0) && tool.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) >= 1) {
            ++a;
        } else if (RandomUtil.getChance(20.0) && tool.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) >= 2) {
            a += 2;
        } else if (RandomUtil.getChance(10.0) && tool.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) >= 3) {
            a += 3;
        }
        return a;
    }

    public static void addItemsToPlayer(final Player player, final List<ItemStack> items, final Block b) {
        final HashMap<Integer, ItemStack> notStored = player.getInventory().addItem(items.toArray(new ItemStack[0]));
        for (final Map.Entry<Integer, ItemStack> en : notStored.entrySet()) {
            b.getWorld().dropItemNaturally(b.getLocation(), en.getValue());
        }
    }
}
