package pl.crazymc.core.inventories;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import pl.crazymc.core.configuration.CraftingsConfig;
import pl.crazymc.core.managers.UserManager;
import pl.crazymc.core.objects.CaseItem;
import pl.crazymc.core.objects.User;
import pl.crazymc.core.utils.GlassPane;
import pl.crazymc.core.builders.InventoryBuilder;
import pl.crazymc.core.builders.ItemBuilder;
import pl.crazymc.core.utils.Util;

import java.util.Map;

public class CaseGui {
    private static final ItemStack enableMessages = new ItemBuilder(Material.GREEN_STAINED_GLASS_PANE, (short) 5).setTitle("&aWlacz powiadomienia z PremiumCase.").build();
    private static final ItemStack disableMessages = new ItemBuilder(Material.RED_STAINED_GLASS_PANE, (short) 14).setTitle("&cWylacz powiadomienia z PremiumCase.").build();

    public static void open(final Player player) {
        final InventoryBuilder inv = new InventoryBuilder("&8» &aDrop z PremiumCase&6:", 54);
        final User user = UserManager.getUser(player);
        for (Map.Entry<Integer, CaseItem> entry : CaseItem.getCaseItems().entrySet()) {
            inv.setItem(entry.getKey(), entry.getValue().getItemStack());
        }
        for (int i = 0; i < 4; i++) {
            inv.setItem(i,enableMessages,event -> user.caseMessages = true);
        }
        for (int i = 5; i < 9; i++) {
            inv.setItem(i,disableMessages,event -> user.caseMessages = false);
        }
        inv.setItem(4, CraftingsConfig.getCase(1));
        inv.open(player, GlassPane.LIGHT_BLUE);
    }
}
