package pl.crazymc.core.builders;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import java.util.ArrayList;

public class CraftingBuilder {
    private static final ArrayList<CraftingBuilder> recipes = new ArrayList<>();

    private final ItemStack result;
    private final ItemStack[] ingredients;

    public CraftingBuilder(ItemStack itemStack, ItemStack... arritemStack) {
        this.result = itemStack;
        this.ingredients = arritemStack;
        ShapedRecipe recipe = new ShapedRecipe(this.result);
        recipe.shape("123", "456", "789");
        for (int i = 1; i <= 9; ++i) {
            ItemStack itemStack2 = this.ingredients[i - 1];
            if (itemStack2.getType() == Material.AIR) continue;
            recipe.setIngredient(String.valueOf(i).charAt(0), itemStack2.getType());
        }
        Bukkit.addRecipe(recipe);
        recipes.add(this);
    }

    public static ArrayList<CraftingBuilder> getRecipes() {
        return recipes;
    }

    public final ItemStack getResult() {
        return this.result;
    }

    public final ItemStack[] getIngredients() {
        return this.ingredients;
    }
}
