package pl.crazymc.core.listeners;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import pl.crazymc.core.managers.UserManager;

import java.util.Arrays;
import java.util.List;

public class PlayerMoveListener implements Listener {
    private final List<Material> blockList = Arrays.asList(Material.STONE, Material.SAND, Material.GRASS, Material.GRAVEL, Material.DIRT, Material.STONE_BRICKS, Material.BRICK, Material.CLAY, Material.NETHERRACK);

    @EventHandler
    public void onShadowBlockMove(final PlayerMoveEvent event) {
        Player player = event.getPlayer();
        GameMode gameMode = player.getGameMode();
        Location from = event.getFrom();
        Location to = event.getTo();
        Block blockTo = to.getBlock();
        Material blockToMaterial = blockTo.getType();
        int fromX = from.getBlockX();
        int toX = to.getBlockX();
        int fromZ = from.getBlockZ();
        int toZ = to.getBlockZ();
        int fromY = from.getBlockY();
        int toY = to.getBlockY();
        if (isBadBlock(blockToMaterial) && gameMode == GameMode.SURVIVAL && (fromX != toX || fromZ != toZ || fromY != toY)) {
            event.setTo(from);
        }
    }
    @EventHandler
    public void onMove(final PlayerMoveEvent event){
        if (event.getFrom().getBlockX() != event.getTo().getBlockX() || event.getFrom().getBlockZ() != event.getTo().getBlockZ()) {
            UserManager.getUser(event.getPlayer()).walkedDistance++;
        }
    }

    private boolean isBadBlock(final Material material) {
        return blockList.contains(material);
    }
}
