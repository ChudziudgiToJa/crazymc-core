package pl.crazymc.core.objects;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pl.crazymc.core.configuration.CraftingsConfig;
import pl.crazymc.core.managers.UserManager;
import pl.crazymc.core.builders.ItemBuilder;
import pl.crazymc.core.utils.Util;

import java.util.Arrays;
import java.util.List;

public class Shop {
    public static final List<Shop> buyItems = Arrays.asList(
            new Shop(null, new ItemBuilder(Material.DIAMOND_HELMET).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).addEnchant(Enchantment.DURABILITY, 3).build(), 59, null),
            new Shop(null, new ItemBuilder(Material.DIAMOND_CHESTPLATE).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).addEnchant(Enchantment.DURABILITY, 3).build(), 59, null),
            new Shop(null, new ItemBuilder(Material.DIAMOND_LEGGINGS).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).addEnchant(Enchantment.DURABILITY, 3).build(), 59, null),
            new Shop(null, new ItemBuilder(Material.DIAMOND_BOOTS).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).addEnchant(Enchantment.DURABILITY, 3).build(), 59, null),
            new Shop(null, new ItemBuilder(Material.DIAMOND_SWORD).addEnchant(Enchantment.DAMAGE_ALL, 5).addEnchant(Enchantment.FIRE_ASPECT, 2).build(), 99, null),
            new Shop(null, new ItemBuilder(Material.DIAMOND_SWORD).addEnchant(Enchantment.DAMAGE_ALL, 5).addEnchant(Enchantment.KNOCKBACK, 2).build(), 119, null),
            new Shop(null, new ItemBuilder(Material.BOW).addEnchant(Enchantment.ARROW_FIRE, 1).addEnchant(Enchantment.ARROW_INFINITE, 1).build(), 99, null),
            new Shop(null, new ItemBuilder(Material.BOW).addEnchant(Enchantment.ARROW_KNOCKBACK, 2).addEnchant(Enchantment.ARROW_INFINITE, 1).build(), 119, null),
            new Shop(null, new ItemBuilder(Material.ARROW, 64).build(), 49, null),
            new Shop(null, new ItemBuilder(Material.DIAMOND_PICKAXE).addEnchant(Enchantment.DIG_SPEED, 5).addEnchant(Enchantment.DURABILITY, 3).addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3).build(), 99, null),
            new Shop(null, new ItemBuilder(Material.DIAMOND_AXE).addEnchant(Enchantment.DIG_SPEED, 5).addEnchant(Enchantment.DURABILITY, 3).addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3).build(), 49, null),
            new Shop(null, new ItemBuilder(Material.DIAMOND_SHOVEL).addEnchant(Enchantment.DIG_SPEED, 5).addEnchant(Enchantment.DURABILITY, 3).addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3).build(), 49, null),
            new Shop(null, new ItemBuilder(Material.TNT, 64).build(), 249, null),
            new Shop(null, CraftingsConfig.getCase(5), 499, null),
            new Shop(null, CraftingsConfig.atomicTnT, 799, null),
            new Shop(null, new ItemBuilder(Material.BEACON).build(), 2199, null),
            new Shop(null, new ItemBuilder(Material.DIAMOND_PICKAXE).addEnchant(Enchantment.DIG_SPEED, 10).addEnchant(Enchantment.DURABILITY, 3).addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3).build(), 999, null),
            new Shop(null, new ItemBuilder(Material.BOW).addEnchant(Enchantment.ARROW_KNOCKBACK, 3).addEnchant(Enchantment.ARROW_INFINITE, 1).build(), 999, null),
            new Shop(null, new ItemBuilder(Material.GOLD_BLOCK, 64).build(), 149, null),
            new Shop(null, CraftingsConfig.getSandFarmer(24), 119, null),
            new Shop(null, CraftingsConfig.getBoyFarmer(24), 119, null),
            new Shop(null, CraftingsConfig.getKopaczFosy(24), 119, null),
            new Shop(null, CraftingsConfig.getGenerator(5), 79, null),
            new Shop(null, new ItemBuilder(Material.GOLDEN_APPLE, 2, (short) 1).build(), 119, null),
            new Shop(null, new ItemBuilder(Material.GOLDEN_APPLE, 10, (short) 0).build(), 119, null),
            new Shop(null, new ItemBuilder(Material.ENDER_PEARL, 4).build(), 119, null),
            new Shop(null, new ItemBuilder(Material.POTION, (short) 16425).build(), 729, null),
            new Shop(null, new ItemBuilder(Material.IRON_BLOCK, 64).build(), 129, null),
            new Shop(null, new ItemBuilder(Material.REDSTONE_BLOCK, 64).build(), 129, null),
            new Shop("&5&lVIP NA EDYCJE", new ItemBuilder(Material.IRON_HELMET).setGlow(true).build(), 5999, "pex user {NICK} group set vip")
    );
    public static final List<Shop> sellItems = Arrays.asList(
            new Shop(null, new ItemBuilder(Material.DIAMOND, 64).build(), 4, null),
            new Shop(null, new ItemBuilder(Material.IRON_INGOT, 64).build(), 3, null),
            new Shop(null, new ItemBuilder(Material.EMERALD, 64).build(), 5, null),
            new Shop(null, new ItemBuilder(Material.GOLD_INGOT, 64).build(), 5, null),
            new Shop(null, new ItemBuilder(Material.OBSIDIAN, 64).build(), 4, null),
            new Shop(null, new ItemBuilder(Material.COAL, 64).build(), 3, null),
            new Shop(null, new ItemBuilder(Material.REDSTONE, 64).build(), 3, null),
            new Shop(null, new ItemBuilder(Material.TNT, 64).build(), 15, null),
            new Shop(null, new ItemBuilder(Material.BOOKSHELF, 64).build(), 6, null),
            new Shop(null, new ItemBuilder(Material.APPLE, 64).build(), 12, null),
            new Shop(null, new ItemBuilder(Material.SLIME_BALL, 64).build(), 30, null),
            new Shop(null, new ItemBuilder(Material.CLAY_BALL, 64).build(), 70, null),
            new Shop(null, new ItemBuilder(Material.GOLDEN_APPLE, 2, (short) 1).build(), 4, null),
            new Shop(null, new ItemBuilder(Material.GOLDEN_APPLE, 10, (short) 0).build(), 4, null),
            new Shop(null, new ItemBuilder(Material.ENDER_PEARL, 4).build(), 4, null),
            new Shop(null, new ItemBuilder(Material.BEACON).build(), 1199, null)
    );

    private final String name;
    private final ItemStack itemStack;
    private final int cost;
    private final String command;

    public Shop(final String name, final ItemStack itemStack, final int cost, final String command) {
        this.name = name;
        this.itemStack = itemStack;
        this.cost = cost;
        this.command = command;
    }

    public static void sellAll(final Player player) {
        final User user = UserManager.getUser(player);
        final Inventory inv = player.getInventory();
        for (int i = 0; i < 72; i++) {
            for (Shop sellItem : sellItems) {
                if (inv.containsAtLeast(sellItem.itemStack, sellItem.itemStack.getAmount())) {
                    inv.removeItem(sellItem.itemStack);
                    user.coins += sellItem.cost;
                }
            }
        }
    }

    public String getName() {
        return name;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public double getCost() {
        return cost / 100.0;
    }

    public void shopItem(final Player player, final Type type) {
        final Inventory inv = player.getInventory();
        final User user = UserManager.getUser(player);
        final ItemStack itemStack = getItemStack().clone();
        if (type.equals(Type.BUY)) {
            if (user.coins >= this.cost) {
                user.coins -= this.cost;
                Util.succes(player, "&aPomyslnie zakupiles ten przedmiot.");
                if (this.command == null) {
                    Util.giveItems(player, itemStack);
                } else
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), this.command.replace("{NICK}", player.getName()));
            } else Util.error(player, "Nie posiadasz tylu pieniedzy.");
        } else if (type.equals(Type.SELL)) {
            if (inv.containsAtLeast(itemStack, itemStack.getAmount())) {
                inv.removeItem(itemStack);
                user.coins += this.cost;
                Util.succes(player, "&aPomyslnie sprzedales ten przedmiot.");
            } else Util.error(player, "Nie posiadasz tego przedmiotu.");
        }
    }

    public enum Type {
        BUY, SELL
    }
}
