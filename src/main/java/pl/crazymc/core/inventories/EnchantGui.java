package pl.crazymc.core.inventories;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import pl.crazymc.core.objects.Enchant;
import pl.crazymc.core.utils.GlassPane;
import pl.crazymc.core.builders.InventoryBuilder;
import pl.crazymc.core.builders.ItemBuilder;
import pl.crazymc.core.utils.Util;

public class EnchantGui {
    private static final ItemStack prot4 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nOchrona IV").addLore("&8» &7Koszt&8: &b50 LvL", "&8» &7Potrzebne biblioteczki&8: &b25").build();
    private static final ItemStack prot3 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nOchrona III").addLore("&8» &7Koszt&8: &b30 LvL", "&8» &7Potrzebne biblioteczki&8: &b15").build();
    private static final ItemStack prot2 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nOchrona II").addLore("&8» &7Koszt&8: &b20 LvL", "&8» &7Potrzebne biblioteczki&8: &b10").build();
    private static final ItemStack prot1 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nOchrona I").addLore("&8» &7Koszt&8: &b15 LvL", "&8» &7Potrzebne biblioteczki&8: &b7").build();
    private static final ItemStack featherfall4 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nPowolne opadanie IV").addLore("&8» &7Koszt&8: &b35 LvL", "&8» &7Potrzebne biblioteczki&8: &b17").build();
    private static final ItemStack featherfall3 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nPowolne opadanie III").addLore("&8» &7Koszt&8: &b30 LvL", "&8» &7Potrzebne biblioteczki&8: &b15").build();
    private static final ItemStack featherfall2 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nPowolne opadanie II").addLore("&8» &7Koszt&8: &b20 LvL", "&8» &7Potrzebne biblioteczki&8: &b10").build();
    private static final ItemStack featherfall1 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nPowolne opadanie I").addLore("&8» &7Koszt&8: &b15 LvL", "&8» &7Potrzebne biblioteczki&8: &b7").build();
    private static final ItemStack unb3 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nNiezniszczalnosc III").addLore("&8» &7Koszt&8: &b40 LvL", "&8» &7Potrzebne biblioteczki&8: &b20").build();
    private static final ItemStack unb2 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nNiezniszczalnosc II").addLore("&8» &7Koszt&8: &b30 LvL", "&8» &7Potrzebne biblioteczki&8: &b15").build();
    private static final ItemStack unb1 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nNiezniszczalnosc I").addLore("&8» &7Koszt&8: &b20 LvL", "&8» &7Potrzebne biblioteczki&8: &b10").build();
    private static final ItemStack respiration3 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nOddychanie III").addLore("&8» &7Koszt&8: &b15 LvL", "&8» &7Potrzebne biblioteczki&8: &b7").build();
    private static final ItemStack respiration2 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nOddychanie II").addLore("&8» &7Koszt&8: &b10 LvL", "&8» &7Potrzebne biblioteczki&8: &b5").build();
    private static final ItemStack respiration1 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nOddychanie I").addLore("&8» &7Koszt&8: &b5 LvL", "&8» &7Potrzebne biblioteczki&8: &b2").build();
    private static final ItemStack thorns3 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nCiernie III").addLore("&8» &7Koszt&8: &b25 LvL", "&8» &7Potrzebne biblioteczki&8: &b12").build();
    private static final ItemStack thorns2 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nCiernie II").addLore("&8» &7Koszt&8: &b15 LvL", "&8» &7Potrzebne biblioteczki&8: &b7").build();
    private static final ItemStack thorns1 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nCiernie I").addLore("&8» &7Koszt&8: &b10 LvL", "&8» &7Potrzebne biblioteczki&8: &b5").build();
    private static final ItemStack eff5 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nWydajnosc V").addLore("&8» &7Koszt&8: &b40 LvL", "&8» &7Potrzebne biblioteczki&8: &b20").build();
    private static final ItemStack eff4 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nWydajnosc IV").addLore("&8» &7Koszt&8: &b30 LvL", "&8» &7Potrzebne biblioteczki&8: &b15").build();
    private static final ItemStack eff3 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nWydajnosc III").addLore("&8» &7Koszt&8: &b20 LvL", "&8» &7Potrzebne biblioteczki&8: &b10").build();
    private static final ItemStack eff2 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nWydajnosc II").addLore("&8» &7Koszt&8: &b10 LvL", "&8» &7Potrzebne biblioteczki&8: &b5").build();
    private static final ItemStack eff1 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nWydajnosc I").addLore("&8» &7Koszt&8: &b5 LvL", "&8» &7Potrzebne biblioteczki&8: &b2").build();
    private static final ItemStack fortune3 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nSzczescie III").addLore("&8» &7Koszt&8: &b35 LvL", "&8» &7Potrzebne biblioteczki&8: &b17").build();
    private static final ItemStack fortune2 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nSzczescie II").addLore("&8» &7Koszt&8: &b25 LvL", "&8» &7Potrzebne biblioteczki&8: &b12").build();
    private static final ItemStack fortune1 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nSzczescie I").addLore("&8» &7Koszt&8: &b15 LvL", "&8» &7Potrzebne biblioteczki&8: &b7").build();
    private static final ItemStack silk1 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nJedwabny dotyk I").addLore("&8» &7Koszt&8: &b20 LvL", "&8» &7Potrzebne biblioteczki&8: &b10").build();
    private static final ItemStack sharp5 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nOstrosc V").addLore("&8» &7Koszt&8: &b50 LvL", "&8» &7Potrzebne biblioteczki&8: &b25").build();
    private static final ItemStack sharp4 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nOstrosc IV").addLore("&8» &7Koszt&8: &b40 LvL", "&8» &7Potrzebne biblioteczki&8: &b20").build();
    private static final ItemStack sharp3 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nOstrosc III").addLore("&8» &7Koszt&8: &b30 LvL", "&8» &7Potrzebne biblioteczki&8: &b15").build();
    private static final ItemStack sharp2 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nOstrosc II").addLore("&8» &7Koszt&8: &b20 LvL", "&8» &7Potrzebne biblioteczki&8: &b10").build();
    private static final ItemStack sharp1 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nOstrosc I").addLore("&8» &7Koszt&8: &b10 LvL", "&8» &7Potrzebne biblioteczki&8: &b5").build();
    private static final ItemStack fireasp2 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nZaklety ogien II").addLore("&8» &7Koszt&8: &b40 LvL", "&8» &7Potrzebne biblioteczki&8: &b20").build();
    private static final ItemStack fireasp1 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nZaklety ogien I").addLore("&8» &7Koszt&8: &b20 LvL", "&8» &7Potrzebne biblioteczki&8: &b10").build();
    private static final ItemStack knock2 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nOdrzut II").addLore("&8» &7Koszt&8: &b30 LvL", "&8» &7Potrzebne biblioteczki&8: &b15").build();
    private static final ItemStack knock1 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nOdrzut I").addLore("&8» &7Koszt&8: &b15 LvL", "&8» &7Potrzebne biblioteczki&8: &b7").build();
    private static final ItemStack power5 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nMoc V").addLore("&8» &7Koszt&8: &b50 LvL", "&8» &7Potrzebne biblioteczki&8: &b25").build();
    private static final ItemStack power4 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nMoc IV").addLore("&8» &7Koszt&8: &b40 LvL", "&8» &7Potrzebne biblioteczki&8: &b20").build();
    private static final ItemStack power3 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nMoc III").addLore("&8» &7Koszt&8: &b30 LvL", "&8» &7Potrzebne biblioteczki&8: &b15").build();
    private static final ItemStack power2 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nMoc II").addLore("&8» &7Koszt&8: &b20 LvL", "&8» &7Potrzebne biblioteczki&8: &b10").build();
    private static final ItemStack power1 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nMoc I").addLore("&8» &7Koszt&8: &b10 LvL", "&8» &7Potrzebne biblioteczki&8: &b5").build();
    private static final ItemStack infinity1 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nNieskonczonosc I").addLore("&8» &7Koszt&8: &b20 LvL", "&8» &7Potrzebne biblioteczki&8: &b15").build();
    private static final ItemStack plomien1 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nPlomien I").addLore("&8» &7Koszt&8: &b10 LvL", "&8» &7Potrzebne biblioteczki&8: &b15").build();
    private static final ItemStack punch2 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nOdrzut II").addLore("&8» &7Koszt&8: &b20 LvL", "&8» &7Potrzebne biblioteczki&8: &b20").build();
    private static final ItemStack punch1 = new ItemBuilder(Material.ENCHANTED_BOOK).setTitle("&b&nOdrzut I").addLore("&8» &7Koszt&8: &b10 LvL", "&8» &7Potrzebne biblioteczki&8: &b15").build();

    public static void open(final Player player, final ItemStack itemStack) {
        final InventoryBuilder inv = new InventoryBuilder("&8» &aEnchant&6:", 54);
        for (int i = 0; i < 54; ++i) {
            inv.setItem((i % 9 == 0) ? i : 0, GlassPane.LIGHT_BLUE.getItem());
            inv.setItem((i % 9 == 0) ? i + 8: 8, GlassPane.LIGHT_BLUE.getItem());
        }
        if (getEnchantmentPartTypeForItemStack(itemStack) == EnchantType.ARMOR) {
            inv.setItem(19, prot4, event -> new Enchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, 50).execute(player));
            inv.setItem(28, prot3, event -> new Enchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, 30).execute(player));
            inv.setItem(37, prot2, event -> new Enchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, 20).execute(player));
            inv.setItem(46, prot1, event -> new Enchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, 15).execute(player));
            inv.setItem(29, unb3, event -> new Enchant(Enchantment.DURABILITY, 3, 40).execute(player));
            inv.setItem(38, unb2, event -> new Enchant(Enchantment.DURABILITY, 2, 30).execute(player));
            inv.setItem(47, unb1, event -> new Enchant(Enchantment.DURABILITY, 1, 20).execute(player));
            inv.setItem(30, thorns3, event -> new Enchant(Enchantment.THORNS, 3, 25).execute(player));
            inv.setItem(39, thorns2, event -> new Enchant(Enchantment.THORNS, 2, 15).execute(player));
            inv.setItem(48, thorns1, event -> new Enchant(Enchantment.THORNS, 1, 10).execute(player));
            if (getEnchantTypeForItemStack(itemStack) == EnchantType.BOOTS) {
                inv.setItem(22, featherfall4, event -> new Enchant(Enchantment.PROTECTION_FALL, 4, 35).execute(player));
                inv.setItem(31, featherfall3, event -> new Enchant(Enchantment.PROTECTION_FALL, 3, 30).execute(player));
                inv.setItem(40, featherfall2, event -> new Enchant(Enchantment.PROTECTION_FALL, 2, 15).execute(player));
                inv.setItem(49, featherfall1, event -> new Enchant(Enchantment.PROTECTION_FALL, 1, 10).execute(player));
            }
            if (getEnchantTypeForItemStack(itemStack) == EnchantType.HEAD) {
                inv.setItem(31, respiration3, event -> new Enchant(Enchantment.OXYGEN, 3, 15).execute(player));
                inv.setItem(40, respiration2, event -> new Enchant(Enchantment.OXYGEN, 2, 10).execute(player));
                inv.setItem(49, respiration1, event -> new Enchant(Enchantment.OXYGEN, 1, 5).execute(player));
            }
        } else if (getEnchantmentPartTypeForItemStack(itemStack) == EnchantType.TOOL) {
            inv.setItem(10, eff5, event -> new Enchant(Enchantment.DIG_SPEED, 5, 40).execute(player));
            inv.setItem(19, eff4, event -> new Enchant(Enchantment.DIG_SPEED, 4, 30).execute(player));
            inv.setItem(28, eff3, event -> new Enchant(Enchantment.DIG_SPEED, 3, 20).execute(player));
            inv.setItem(37, eff2, event -> new Enchant(Enchantment.DIG_SPEED, 2, 10).execute(player));
            inv.setItem(46, eff1, event -> new Enchant(Enchantment.DIG_SPEED, 1, 5).execute(player));
            inv.setItem(29, unb3, event -> new Enchant(Enchantment.DURABILITY, 3, 40).execute(player));
            inv.setItem(38, unb2, event -> new Enchant(Enchantment.DURABILITY, 2, 30).execute(player));
            inv.setItem(47, unb1, event -> new Enchant(Enchantment.DURABILITY, 1, 20).execute(player));
            inv.setItem(30, fortune3, event -> new Enchant(Enchantment.LOOT_BONUS_BLOCKS, 3, 35).execute(player));
            inv.setItem(39, fortune2, event -> new Enchant(Enchantment.LOOT_BONUS_BLOCKS, 2, 25).execute(player));
            inv.setItem(48, fortune1, event -> new Enchant(Enchantment.LOOT_BONUS_BLOCKS, 1, 15).execute(player));
            inv.setItem(49, silk1, event -> new Enchant(Enchantment.SILK_TOUCH, 1, 20).execute(player));
        } else if (getEnchantTypeForItemStack(itemStack) == EnchantType.SWORD) {
            inv.setItem(10, sharp5, event -> new Enchant(Enchantment.DAMAGE_ALL, 5, 50).execute(player));
            inv.setItem(19, sharp4, event -> new Enchant(Enchantment.DAMAGE_ALL, 4, 40).execute(player));
            inv.setItem(28, sharp3, event -> new Enchant(Enchantment.DAMAGE_ALL, 3, 30).execute(player));
            inv.setItem(37, sharp2, event -> new Enchant(Enchantment.DAMAGE_ALL, 2, 20).execute(player));
            inv.setItem(46, sharp1, event -> new Enchant(Enchantment.DAMAGE_ALL, 1, 10).execute(player));
            inv.setItem(29, unb3, event -> new Enchant(Enchantment.DURABILITY, 3, 40).execute(player));
            inv.setItem(38, unb2, event -> new Enchant(Enchantment.DURABILITY, 2, 30).execute(player));
            inv.setItem(47, unb1, event -> new Enchant(Enchantment.DURABILITY, 1, 20).execute(player));
            inv.setItem(39, fireasp2, event -> new Enchant(Enchantment.FIRE_ASPECT, 2, 40).execute(player));
            inv.setItem(48, fireasp1, event -> new Enchant(Enchantment.FIRE_ASPECT, 1, 20).execute(player));
            inv.setItem(40, knock2, event -> new Enchant(Enchantment.KNOCKBACK, 2, 30).execute(player));
            inv.setItem(49, knock1, event -> new Enchant(Enchantment.KNOCKBACK, 1, 15).execute(player));
        } else if (getEnchantTypeForItemStack(itemStack) == EnchantType.BOW) {
            inv.setItem(10, power5, event -> new Enchant(Enchantment.ARROW_DAMAGE, 5, 50).execute(player));
            inv.setItem(19, power4, event -> new Enchant(Enchantment.ARROW_DAMAGE, 4, 40).execute(player));
            inv.setItem(28, power3, event -> new Enchant(Enchantment.ARROW_DAMAGE, 3, 30).execute(player));
            inv.setItem(37, power2, event -> new Enchant(Enchantment.ARROW_DAMAGE, 2, 20).execute(player));
            inv.setItem(46, power1, event -> new Enchant(Enchantment.ARROW_DAMAGE, 1, 10).execute(player));
            inv.setItem(29, unb3, event -> new Enchant(Enchantment.DURABILITY, 3, 40).execute(player));
            inv.setItem(38, unb2, event -> new Enchant(Enchantment.DURABILITY, 2, 30).execute(player));
            inv.setItem(47, unb1, event -> new Enchant(Enchantment.DURABILITY, 1, 20).execute(player));
            inv.setItem(39, punch2, event -> new Enchant(Enchantment.ARROW_KNOCKBACK, 2, 20).execute(player));
            inv.setItem(48, punch1, event -> new Enchant(Enchantment.ARROW_KNOCKBACK, 1, 10).execute(player));
            inv.setItem(49, plomien1, event -> new Enchant(Enchantment.ARROW_FIRE, 1, 10).execute(player));
            inv.setItem(50, infinity1, event -> new Enchant(Enchantment.ARROW_INFINITE, 1, 20).execute(player));
        } else {
            Util.error(player,"Nie mozesz zaczarowac tego przedmiotu!");
            return;
        }
        inv.open(player);
    }

    public static boolean isAllowedEnchant(final ItemStack item, final Enchantment e) {
        return e.canEnchantItem(item);
    }

    private static EnchantType getEnchantmentPartTypeForItemStack(ItemStack item) {
        switch (item.getType()) {
            case LEATHER_HELMET:
            case IRON_HELMET:
            case GOLDEN_HELMET:
            case DIAMOND_HELMET:
            case LEATHER_CHESTPLATE:
            case IRON_CHESTPLATE:
            case GOLDEN_CHESTPLATE:
            case DIAMOND_CHESTPLATE:
            case LEATHER_LEGGINGS:
            case IRON_LEGGINGS:
            case GOLDEN_LEGGINGS:
            case DIAMOND_LEGGINGS:
            case LEATHER_BOOTS:
            case IRON_BOOTS:
            case GOLDEN_BOOTS:
            case DIAMOND_BOOTS:
                return EnchantType.ARMOR;
            case WOODEN_PICKAXE:
            case STONE_PICKAXE:
            case IRON_PICKAXE:
            case GOLDEN_PICKAXE:
            case DIAMOND_PICKAXE:
            case WOODEN_AXE:
            case STONE_AXE:
            case IRON_AXE:
            case GOLDEN_AXE:
            case DIAMOND_AXE:
            case WOODEN_SHOVEL:
            case STONE_SHOVEL:
            case IRON_SHOVEL:
            case GOLDEN_SHOVEL:
            case DIAMOND_SHOVEL:
                return EnchantType.TOOL;
        }
        return EnchantType.OTHER;
    }

    private static EnchantType getEnchantTypeForItemStack(ItemStack item) {
        switch (item.getType()) {
            case LEATHER_HELMET:
            case IRON_HELMET:
            case GOLDEN_HELMET:
            case DIAMOND_HELMET:
                return EnchantType.HEAD;
            case LEATHER_CHESTPLATE:
            case IRON_CHESTPLATE:
            case GOLDEN_CHESTPLATE:
            case DIAMOND_CHESTPLATE:
                return EnchantType.CHEST;
            case LEATHER_LEGGINGS:
            case IRON_LEGGINGS:
            case GOLDEN_LEGGINGS:
            case DIAMOND_LEGGINGS:
                return EnchantType.LEGS;
            case LEATHER_BOOTS:
            case IRON_BOOTS:
            case GOLDEN_BOOTS:
            case DIAMOND_BOOTS:
                return EnchantType.BOOTS;
            case WOODEN_SWORD:
            case STONE_SWORD:
            case IRON_SWORD:
            case GOLDEN_SWORD:
            case DIAMOND_SWORD:
                return EnchantType.SWORD;
            case WOODEN_PICKAXE:
            case STONE_PICKAXE:
            case IRON_PICKAXE:
            case GOLDEN_PICKAXE:
            case DIAMOND_PICKAXE:
                return EnchantType.PICKAXE;
            case BOW:
                return EnchantType.BOW;
        }
        return EnchantType.OTHER;
    }

    public enum EnchantType {
        HEAD, CHEST, LEGS, BOOTS, SWORD, PICKAXE, BOW, OTHER, ARMOR, TOOL
    }
}
