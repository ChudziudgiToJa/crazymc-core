package pl.crazymc.core.inventories;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import pl.crazymc.core.configuration.CraftingsConfig;
import pl.crazymc.core.utils.GlassPane;
import pl.crazymc.core.builders.InventoryBuilder;

import java.util.Arrays;
import java.util.List;

public class CraftingsGui {
    private static final Integer[] recipeSlots = {20, 21, 22, 29, 30, 31, 38, 39, 40};
    private static final List<ItemStack> generatorRecipe = Arrays.asList(new ItemStack(Material.STONE), new ItemStack(Material.STONE), new ItemStack(Material.STONE), new ItemStack(Material.STONE), new ItemStack(Material.PISTON), new ItemStack(Material.STONE), new ItemStack(Material.STONE), new ItemStack(Material.STONE), new ItemStack(Material.STONE));
    private static final List<ItemStack> boyFarmerRecipe = Arrays.asList(new ItemStack(Material.OBSIDIAN), new ItemStack(Material.OBSIDIAN), new ItemStack(Material.OBSIDIAN), new ItemStack(Material.OBSIDIAN), new ItemStack(Material.GOLDEN_APPLE), new ItemStack(Material.OBSIDIAN), new ItemStack(Material.OBSIDIAN), new ItemStack(Material.OBSIDIAN), new ItemStack(Material.OBSIDIAN));
    private static final List<ItemStack> sandFarmerRecipe = Arrays.asList(new ItemStack(Material.SAND), new ItemStack(Material.SAND), new ItemStack(Material.SAND), new ItemStack(Material.SAND), new ItemStack(Material.GOLDEN_APPLE), new ItemStack(Material.SAND), new ItemStack(Material.SAND), new ItemStack(Material.SAND), new ItemStack(Material.SAND));
    private static final List<ItemStack> kopaczFosyRecipe = Arrays.asList(new ItemStack(Material.COBBLESTONE), new ItemStack(Material.COBBLESTONE), new ItemStack(Material.COBBLESTONE), new ItemStack(Material.COBBLESTONE), new ItemStack(Material.GOLDEN_APPLE), new ItemStack(Material.COBBLESTONE), new ItemStack(Material.COBBLESTONE), new ItemStack(Material.COBBLESTONE), new ItemStack(Material.COBBLESTONE));
    private static final List<ItemStack> antiLegsRecipe = Arrays.asList(new ItemStack(Material.EMERALD_BLOCK), new ItemStack(Material.EMERALD_BLOCK), new ItemStack(Material.EMERALD_BLOCK), new ItemStack(Material.EMERALD_BLOCK), new ItemStack(Material.GOLD_BLOCK), new ItemStack(Material.EMERALD_BLOCK), new ItemStack(Material.EMERALD_BLOCK), new ItemStack(Material.EMERALD_BLOCK), new ItemStack(Material.EMERALD_BLOCK));
    private static final List<ItemStack> atomicTnTRecipe = Arrays.asList(new ItemStack(Material.TNT, 64), new ItemStack(Material.TNT, 64), new ItemStack(Material.TNT, 64), new ItemStack(Material.TNT, 64), new ItemStack(Material.TNT, 64), new ItemStack(Material.TNT, 64), new ItemStack(Material.TNT, 64), new ItemStack(Material.TNT, 64), new ItemStack(Material.TNT, 64));
    private static final List<ItemStack> cobbleXRecipe = Arrays.asList(new ItemStack(Material.COBBLESTONE, 64), new ItemStack(Material.COBBLESTONE, 64), new ItemStack(Material.COBBLESTONE, 64), new ItemStack(Material.COBBLESTONE, 64), new ItemStack(Material.COBBLESTONE, 64), new ItemStack(Material.COBBLESTONE, 64), new ItemStack(Material.COBBLESTONE, 64), new ItemStack(Material.COBBLESTONE, 64), new ItemStack(Material.COBBLESTONE, 64));

    public static void open(final Player player) {
        open(player, CraftingsConfig.generator, generatorRecipe);
    }

    private static void open(final Player player, final ItemStack result, final List<ItemStack> recipe) {
        final InventoryBuilder inv = new InventoryBuilder("&8» &aCraftingi&6:", 54);
        inv.setItem(1, CraftingsConfig.generator, event -> open(player, CraftingsConfig.generator, generatorRecipe));
        inv.setItem(2, CraftingsConfig.boyFarmer, event -> open(player, CraftingsConfig.boyFarmer, boyFarmerRecipe));
        inv.setItem(3, CraftingsConfig.sandFarmer, event -> open(player, CraftingsConfig.sandFarmer, sandFarmerRecipe));
        inv.setItem(4, CraftingsConfig.kopaczFosy, event -> open(player, CraftingsConfig.kopaczFosy, kopaczFosyRecipe));
        inv.setItem(5, CraftingsConfig.atomicTnT, event -> open(player, CraftingsConfig.atomicTnT, atomicTnTRecipe));
        inv.setItem(6, CraftingsConfig.antiLegs, event -> open(player, CraftingsConfig.antiLegs, antiLegsRecipe));
        inv.setItem(7, CraftingsConfig.cobbleX, event -> open(player, CraftingsConfig.cobbleX, cobbleXRecipe));
        for (int i = 0; i < recipe.size(); i++) {
            inv.setItem(recipeSlots[i], recipe.get(i));
        }
        inv.setItem(33, result);
        inv.open(player, GlassPane.LIGHT_BLUE);
    }
}