package pl.crazymc.core.listeners;

import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pl.crazymc.core.builders.CraftingBuilder;

public class PrepareItemCraftListener implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onPrepareItemCraft(PrepareItemCraftEvent event) {
        CraftingInventory crafting = event.getInventory();
        for (CraftingBuilder recipe : CraftingBuilder.getRecipes()) {
            if (crafting.getRecipe().getResult().isSimilar(recipe.getResult())) {
                ItemStack[] input = crafting.getMatrix();
                for (int i = 0; i < 8; ++i) {
                    if (input[i].equals(recipe.getIngredients()[i])) continue;
                    crafting.setResult(null);
                }
            }
        }
    }

    @EventHandler(ignoreCancelled = true)
    public final void onInventoryClick(InventoryClickEvent e) {
        Inventory crafting = e.getInventory();
        if (crafting instanceof CraftingInventory && e.getSlotType() == InventoryType.SlotType.RESULT) {
            if (e.getCurrentItem().getType() == null || e.getCurrentItem().getType() == Material.AIR) {
                return;
            }
            ItemStack result = ((CraftingInventory) crafting).getResult();
            for (CraftingBuilder recipe : CraftingBuilder.getRecipes()) {
                if (result.isSimilar(recipe.getResult())) {
                    e.setCancelled(true);
                    for (int i = 0; i < 10; ++i) {
                        crafting.setItem(i, null);
                    }
                    ClickType ct = e.getClick();
                    if (ct == ClickType.SHIFT_LEFT || ct == ClickType.SHIFT_RIGHT) {
                        HumanEntity he = e.getWhoClicked();
                        if (he.getInventory().firstEmpty() < 0) {
                            he.closeInventory();
                            he.getWorld().dropItem(he.getEyeLocation(), result);
                        } else {
                            he.getInventory().addItem(result);
                        }
                    } else {
                        e.getWhoClicked().setItemOnCursor(result);
                    }
                }
            }
        }
    }
}