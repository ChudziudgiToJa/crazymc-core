package pl.crazymc.core.listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import pl.crazymc.core.CorePlugin;
import pl.crazymc.core.configuration.CraftingsConfig;
import pl.crazymc.core.managers.DropManager;
import pl.crazymc.core.managers.GeneratorManager;
import pl.crazymc.core.utils.Util;

public class BlockBreakListener implements Listener {
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onBreak(final BlockBreakEvent event) {
        final Player player = event.getPlayer();
        final Block block = event.getBlock();
        if (player.getGameMode() == GameMode.SURVIVAL) {
            DropManager.breakBlock(player, block, player.getItemInHand());
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onBreak1(final BlockBreakEvent event) {
        final Player player = event.getPlayer();
        if (GeneratorManager.isGenerator(event.getBlock().getLocation())) {
            if (player.getItemInHand().getType() == Material.GOLDEN_PICKAXE && event.getBlock().getRelative(BlockFace.DOWN).getType() != Material.END_STONE) {
                GeneratorManager.deleteGenerator(event.getBlock().getLocation());
                player.getInventory().addItem(CraftingsConfig.generator);
                Util.warning(player,"Zniszczyles stoniarke.");
                return;
            }
            Bukkit.getScheduler().runTaskLater(CorePlugin.getInstance(), () -> event.getBlock().setType(Material.STONE), 25);
        }
    }
}
