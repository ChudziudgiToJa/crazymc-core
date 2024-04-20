package pl.crazymc.core.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;

public class BlockFromToListener implements Listener {
    @EventHandler
    public void onBlockFromTo(final BlockFromToEvent event) {
        final Block block = event.getBlock();
        final Material type = block.getType();
        if (type.equals(Material.WATER) || type.equals(Material.WATER_CAULDRON) || type.equals(Material.LAVA) || type.equals(Material.LAVA_CAULDRON)) {
            event.setCancelled(true);
        }
    }
}
