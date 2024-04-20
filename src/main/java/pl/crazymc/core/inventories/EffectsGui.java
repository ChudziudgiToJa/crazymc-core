package pl.crazymc.core.inventories;

import org.bukkit.entity.Player;
import pl.crazymc.core.objects.Effect;
import pl.crazymc.core.utils.GlassPane;
import pl.crazymc.core.builders.InventoryBuilder;

import java.util.Map;

public class EffectsGui {

    public static void open(final Player player) {
        final InventoryBuilder inv = new InventoryBuilder("&8» &aEfekty&6:",36);
        for (Map.Entry<Integer, Effect> entry : Effect.effects.entrySet()) {
            inv.setItem(entry.getKey(),entry.getValue().getItemStack(), event -> entry.getValue().buy(player));
        }
        inv.open(player, GlassPane.LIGHT_BLUE);
    }
}
