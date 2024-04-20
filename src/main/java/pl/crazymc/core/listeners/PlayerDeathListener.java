package pl.crazymc.core.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import pl.crazymc.core.builders.ItemBuilder;

public class PlayerDeathListener implements Listener {
    @EventHandler
    public void onDeath(final PlayerDeathEvent event) {
        event.getEntity().getWorld().strikeLightningEffect(event.getEntity().getLocation());
    }
}
