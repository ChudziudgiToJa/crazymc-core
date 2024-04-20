package pl.crazymc.core.objects;

import org.bukkit.GameMode;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import pl.crazymc.core.inventories.EnchantGui;
import pl.crazymc.core.utils.Util;

public class Enchant {
    private final Enchantment enchant;
    private final int levelEnchant;
    private final int levelCost;

    public Enchant(final Enchantment e, final int levelEnchant, final int levelCost) {
        this.enchant = e;
        this.levelEnchant = levelEnchant;
        this.levelCost = levelCost;
    }

    public void execute(final Player player) {
        final ItemStack item = player.getItemInHand();
        if (item != null) {
            if (player.getLevel() >= this.levelCost || player.getGameMode() == GameMode.CREATIVE) {
                if (EnchantGui.isAllowedEnchant(item, this.enchant)) {
                    if (item.getEnchantmentLevel(this.enchant) < this.levelEnchant) {
                        item.addUnsafeEnchantment(this.enchant, this.levelEnchant);
                        Util.succes(player, "Pomyslnie zaczarowales przedmiot!");
                        if (player.getGameMode() != GameMode.CREATIVE) {
                            player.setLevel(player.getLevel() - this.levelCost);
                        } else Util.info(player, "Poziom &aEXP &7zostal pobrany z trybu gry: &2KREATYWNY");
                    } else Util.error(player, "Ten przedmiot posiada juz ten enchant na wyzszym lub takim samym poziomie!");
                } else Util.error(player, "Nie mozesz zaczarowac tego przedmiotu!");
            } else Util.error(player, "Musisz miec " + this.levelCost + " poziom aby zaczarowac ten przedmiot!");
        } else Util.error(player, "Musisz trzymac przedmiot w rece!");
        player.closeInventory();
    }
}