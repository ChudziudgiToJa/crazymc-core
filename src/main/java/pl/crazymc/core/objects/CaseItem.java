package pl.crazymc.core.objects;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import pl.crazymc.core.builders.ItemBuilder;
import pl.crazymc.core.configuration.CraftingsConfig;

import java.util.HashMap;

public class CaseItem {
    private static final HashMap<Integer, CaseItem> caseItems = new HashMap<>();

    static {
        caseItems.put(10, new CaseItem(new ItemBuilder(Material.DIAMOND_SWORD).addEnchant(Enchantment.DAMAGE_ALL, 5).addEnchant(Enchantment.FIRE_ASPECT, 2).build(), 30, " &8&l⋇ &aMiecz 5/2 &8(&730%&8)"));
        caseItems.put(11, new CaseItem(new ItemBuilder(Material.DIAMOND_SWORD).addEnchant(Enchantment.KNOCKBACK, 2).build(), 20, " &8&l⋇ &aKnock 2 &8(&720%&8)"));
        caseItems.put(15, new CaseItem(new ItemBuilder(Material.DIAMOND_SWORD).addEnchant(Enchantment.DAMAGE_ALL, 6).addEnchant(Enchantment.FIRE_ASPECT, 2).build(), 3, " &8&l⋇ &aMiecz 6/2 &8(&73%&8)"));
        caseItems.put(16, new CaseItem(new ItemBuilder(Material.DIAMOND_SWORD).addEnchant(Enchantment.KNOCKBACK, 3).build(), 3, " &8&l⋇ &aKnock 3 &8(&73%&8)"));
        caseItems.put(19, new CaseItem(new ItemBuilder(Material.DIAMOND_HELMET).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).addEnchant(Enchantment.DURABILITY, 3).build(), 30, " &8&l⋇ &aHelm 4/3 &8(&730%&8)"));
        caseItems.put(20, new CaseItem(new ItemBuilder(Material.DIAMOND_CHESTPLATE).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).addEnchant(Enchantment.DURABILITY, 3).build(), 30, " &8&l⋇ &aKlata 4/3 &8(&730%&8)"));
        caseItems.put(21, new CaseItem(new ItemBuilder(Material.DIAMOND_LEGGINGS).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).addEnchant(Enchantment.DURABILITY, 3).build(), 30, " &8&l⋇ &aSpodnie 4/3 &8(&730%&8)"));
        caseItems.put(22, new CaseItem(new ItemBuilder(Material.DIAMOND_BOOTS).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).addEnchant(Enchantment.DURABILITY, 3).build(), 30, " &8&l⋇ &aButy 4/3 &8(&730%&8)"));
        caseItems.put(23, new CaseItem(new ItemBuilder(Material.BEACON).build(), 2, " &8- &c&l&nBEACON &8(&71%&8)"));
        caseItems.put(24, new CaseItem(CraftingsConfig.getBoyFarmer(24), 15, " &8&l⋇ &a5x ObsydianFarmer &8(&715%&8)"));
        caseItems.put(25, new CaseItem(CraftingsConfig.getSandFarmer(24), 15, " &8&l⋇ &a5x PiasekFarmer &8(&715%&8)"));
        caseItems.put(28, new CaseItem(new ItemBuilder(Material.GOLDEN_APPLE, 3, (short) 1).build(), 25, " &8&l⋇ &a3x Zlote Jablko &8(&725%&8)"));
        caseItems.put(29, new CaseItem(new ItemBuilder(Material.GOLDEN_APPLE, 16).build(), 30, " &8&l⋇ &a16x Refil &8(&730%&8)"));
        caseItems.put(30, new CaseItem(new ItemBuilder(Material.ENDER_PEARL, 3).build(), 30, " &8&l⋇ &a3x Perla kresu &8(&715%&8)"));
        caseItems.put(31, new CaseItem(new ItemBuilder(Material.TNT, 32).build(), 10, " &8&l⋇ &a32x TNT &8(&710%&8)"));
        caseItems.put(32, new CaseItem(new ItemBuilder(Material.POTION, 1, (short) 16425).build(), 5, " &8- &cMikstura sily II &8(&75%&8)"));
        caseItems.put(33, new CaseItem(CraftingsConfig.atomicTnT, 3, " &8- &4A&8T&4O&8M&4O&8W&4K&8A &8(&73%&8)"));
        caseItems.put(34, new CaseItem(CraftingsConfig.getKopaczFosy(24), 15, " &8&l⋇ &a5x KopaczFosy &8(&715%&8)"));
        caseItems.put(37, new CaseItem(new ItemBuilder(Material.DIAMOND_PICKAXE).addEnchant(Enchantment.DIG_SPEED, 5).addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3).addEnchant(Enchantment.DURABILITY, 3).build(), 25, " &8&l⋇ &aKilof 5/3/3 &8(&725%&8)"));
        caseItems.put(38, new CaseItem(new ItemBuilder(Material.DIAMOND_PICKAXE).addEnchant(Enchantment.DIG_SPEED, 10).addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3).addEnchant(Enchantment.DURABILITY, 3).build(), 3, " &8&l⋇ &aKilof 10/3/3 &8(&73%&8)"));
        caseItems.put(39, new CaseItem(new ItemBuilder(Material.GOLD_BLOCK, 32).build(), 10, " &8&l⋇ &a32x Bloki Zlota &8(&710%&8)"));
        caseItems.put(40, new CaseItem(new ItemBuilder(Material.GOLD_BLOCK, 64).build(), 10, " &8&l⋇ &a64x Bloki Zlota &8(&710%&8)"));
        caseItems.put(41, new CaseItem(new ItemBuilder(Material.DIAMOND_BLOCK, 32).build(), 10, " &8&l⋇ &a32x Diamenty &8(&710%&8)"));
        caseItems.put(42, new CaseItem(new ItemBuilder(Material.BOW).addEnchant(Enchantment.ARROW_KNOCKBACK, 2).addEnchant(Enchantment.ARROW_INFINITE, 1).build(), 15, " &8&l⋇ &aLuk 2/1 &8(&715%&8)"));
        caseItems.put(43, new CaseItem(new ItemBuilder(Material.BOW).addEnchant(Enchantment.ARROW_KNOCKBACK, 3).addEnchant(Enchantment.ARROW_INFINITE, 1).build(), 3, " &8&l⋇ &aLuk 3/1 &8(&73%&8)"));
    }

    private final ItemStack itemStack;
    private final double chance;
    private final String message;

    public CaseItem(ItemStack itemStack, double chance, String message) {
        this.itemStack = itemStack;
        this.chance = chance;
        this.message = message;
    }

    public static HashMap<Integer, CaseItem> getCaseItems() {
        return caseItems;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public double getChance() {
        return chance;
    }

    public String getMessage() {
        return message;
    }
}
