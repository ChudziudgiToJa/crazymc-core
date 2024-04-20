package pl.crazymc.core.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import pl.crazymc.core.configuration.CraftingsConfig;
import pl.crazymc.core.managers.AntiLegsManager;

public class AntiLegsListener implements Listener {
    @EventHandler
    public void onDamage(final EntityDamageByEntityEvent event) {
        final Entity entity = event.getEntity();
        final Entity damager = event.getDamager();
        if (entity instanceof Player) {
            if (damager instanceof Player) {
                if (AntiLegsManager.getAntiLegsPlayer().containsKey(entity.getUniqueId())) {
                    if (AntiLegsManager.canBeTeleported(((Player) entity).getPlayer())) {
                        entity.teleport(damager);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPotion(final PlayerItemConsumeEvent event) {
        if (event.getItem().isSimilar(CraftingsConfig.antiLegs)) {
            event.setCancelled(true);
            event.getPlayer().getInventory().removeItem(CraftingsConfig.antiLegs);
            AntiLegsManager.getAntiLegsPlayer().put(event.getPlayer().getUniqueId(), System.currentTimeMillis() + 10000L);
        }
    }
}
