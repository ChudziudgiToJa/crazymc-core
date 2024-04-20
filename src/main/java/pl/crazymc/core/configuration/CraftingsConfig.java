package pl.crazymc.core.configuration;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import pl.crazymc.core.builders.ItemBuilder;

import java.util.Arrays;
import java.util.List;

public class CraftingsConfig {
    public static final ItemStack generator = new ItemBuilder(Material.EMERALD_ORE).setTitle("&6&l* &7&lSTONIARKA &6&l*").addLore("&7Czas odnowienia: &f1 sekunda&7.").addEnchant(Enchantment.DURABILITY,10).build();
    public static final ItemStack boyFarmer = new ItemBuilder(Material.OBSIDIAN).setTitle("&6&l* &9&lBOYFARMER &6&l*").addEnchant(Enchantment.DURABILITY,10).build();
    public static final ItemStack sandFarmer = new ItemBuilder(Material.SANDSTONE).setTitle("&6&l* &e&lSANDFARMER &6&l*").addEnchant(Enchantment.DURABILITY,10).build();
    public static final ItemStack kopaczFosy = new ItemBuilder(Material.STONE).setTitle("&6&l* KOPACZFOSY &6&l*").addEnchant(Enchantment.DURABILITY,10).build();
    public static final ItemStack antiLegs = new ItemBuilder(Material.POTION, 1, (short) 8203).setTitle("&6&ki&f&l&ki&6&ki&3 Anty - Nogi &6&ki&f&l&ki&6&ki").addLore("&fJestes w nogach? Wypij ta potke!", "&fPotka Cie przeteleportuje do twojego przeciwnika ", "&fi bedziesz mial szanse go &cZABIC&f!").build();
    public static final ItemStack atomicTnT = new ItemBuilder(Material.TNT).setTitle("&f&ki&a&l&ki&f&ki&4 A&8T&4O&8M&4O&8W&4K&8A &f&ki&a&l&ki&f&ki&5").addEnchant(Enchantment.DURABILITY, 10).build();
    public static final ItemStack cobbleX = new ItemBuilder(Material.MOSSY_COBBLESTONE).setTitle("&eCobble&2&lX").addEnchant(Enchantment.DURABILITY,10).build();
    public static final ItemStack premiumCase = new ItemBuilder(Material.CHEST).setTitle("&8&l* &9PremiumCase &8&l*").addLore("&8* &7Wiadomosci z &9PremiumCase &7mozna wylaczyc pod komenda &a/case").build();

    public static final List<ItemStack> cobbleXItems = Arrays.asList(
            new ItemStack(Material.GOLDEN_APPLE,(short)1),
            new ItemStack(Material.GOLD_BLOCK),
            new ItemStack(Material.DIAMOND_BLOCK),
            new ItemStack(Material.IRON_BLOCK),
            new ItemStack(Material.SNOWBALL),
            new ItemStack(Material.APPLE),
            new ItemStack(Material.OBSIDIAN),
            new ItemStack(Material.BOOKSHELF),
            new ItemStack(Material.OAK_LOG),
            new ItemStack(Material.STRING),
            new ItemStack(Material.EMERALD_BLOCK),
            new ItemStack(Material.GOLDEN_APPLE,2));

    public static ItemStack getGenerator(int i) {
        final ItemStack itemStack = generator.clone();
        itemStack.setAmount(i);
        return itemStack;
    }

    public static ItemStack getBoyFarmer(int i) {
        final ItemStack itemStack = boyFarmer.clone();
        itemStack.setAmount(i);
        return itemStack;
    }

    public static ItemStack getSandFarmer(int i) {
        final ItemStack itemStack = sandFarmer.clone();
        itemStack.setAmount(i);
        return itemStack;
    }

    public static ItemStack getKopaczFosy(int i) {
        final ItemStack itemStack = kopaczFosy.clone();
        itemStack.setAmount(i);
        return itemStack;
    }

    public static ItemStack getCase(int i) {
        final ItemStack itemStack = premiumCase.clone();
        itemStack.setAmount(i);
        return itemStack;
    }
}