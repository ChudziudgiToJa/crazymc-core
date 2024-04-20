package pl.crazymc.core.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.hanging.HangingPlaceEvent;
import org.bukkit.event.player.*;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.projectiles.ProjectileSource;
import pl.crazymc.core.configuration.Config;
import pl.crazymc.core.configuration.RegionsConfig;
import pl.crazymc.core.managers.GeneratorManager;
import pl.crazymc.core.utils.Util;

public class RegionListener implements Listener {
    public static boolean isSpawn(final Location loc) {
        return Util.isIn(loc, -Config.spawnRegion, Config.spawnRegion, -Config.spawnRegion, Config.spawnRegion);
    }

    public static boolean isPvP(final Location loc) {
        return Util.isIn(loc, -Config.pvpRegion, Config.pvpRegion, -Config.pvpRegion, Config.pvpRegion);
    }

    @EventHandler
    public void onPearl(final PlayerTeleportEvent e) {
        if (e.getCause().equals(PlayerTeleportEvent.TeleportCause.ENDER_PEARL)) {
            if (isSpawn(e.getFrom()) || isSpawn(e.getTo())) {
                e.setCancelled(true);
                e.setTo(e.getFrom());
                Util.error(e.getPlayer(), RegionsConfig.chatCannotEnderPearHere);
            }
        }
    }

    @EventHandler
    public void onPistonExtend(final BlockPistonExtendEvent e) {
        if (isPvP(e.getBlock().getLocation())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onPistonRetract(final BlockPistonRetractEvent e) {
        if (isPvP(e.getBlock().getLocation())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onInteract(final PlayerInteractEvent e) {
        final Player player = e.getPlayer();
        final Location loc = player.getEyeLocation();
        if (isPvP(loc) && !e.getPlayer().hasPermission(RegionsConfig.permissionRegionsBypass)) {
            if (player.getItemInHand() != null && (player.getItemInHand().getType().equals(Material.OAK_BOAT) || player.getItemInHand().getType().equals(Material.PAINTING))) {
                e.setCancelled(true);
            }
            if (e.getClickedBlock() != null && e.getClickedBlock().getType().equals(Material.ITEM_FRAME)) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onFill(final PlayerBucketFillEvent e) {
        if (isPvP(e.getBlockClicked().getLocation()) && !e.getPlayer().hasPermission(RegionsConfig.permissionRegionsBypass)) {
            Util.error(e.getPlayer(), RegionsConfig.chatCannotDoThisHere);
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onEmpty(final PlayerBucketEmptyEvent e) {
        if (isPvP(e.getBlockClicked().getLocation()) && !e.getPlayer().hasPermission(RegionsConfig.permissionRegionsBypass)) {
            Util.error(e.getPlayer(), RegionsConfig.chatCannotDoThisHere);
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlace(final BlockPlaceEvent e) {
        if (isPvP(e.getBlockPlaced().getLocation()) && !e.getPlayer().hasPermission(RegionsConfig.permissionRegionsBypass)) {
            Util.error(e.getPlayer(), RegionsConfig.chatCannotBuildHere);
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onBreak(final BlockBreakEvent event) {
        final Block block = event.getBlock();
        final Player player = event.getPlayer();
        if (isPvP(block.getLocation()) && !player.hasPermission(RegionsConfig.permissionRegionsBypass)) {
            if (!GeneratorManager.isGenerator(block.getLocation())) {
                Util.error(player, RegionsConfig.chatCannotBreakHere);
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public final void onInteractEntity(final PlayerInteractEntityEvent event) {
        final Entity entity = event.getRightClicked();
        if (isPvP(entity.getLocation()) && !event.getPlayer().hasPermission(RegionsConfig.permissionRegionsBypass)) {
            if (entity.getType() == EntityType.ITEM_FRAME) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onBlockIgnite(final BlockIgniteEvent event) {
        if (isPvP(event.getBlock().getLocation())) {
            final BlockIgniteEvent.IgniteCause cause = event.getCause();
            if (cause == BlockIgniteEvent.IgniteCause.SPREAD || cause == BlockIgniteEvent.IgniteCause.LAVA) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onExplode(final EntityExplodeEvent e) {
        if (isPvP(e.getLocation())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onDamage(final EntityDamageByEntityEvent event) {
        final Entity damaged = event.getEntity();
        Entity damager = event.getDamager();
        if (damager instanceof Projectile) {
            final ProjectileSource shooter = ((Projectile) damager).getShooter();
            if (shooter instanceof Player) damager = (Entity) shooter;
        }
        if (damaged instanceof Player) {
            if (isSpawn(damaged.getLocation()) || isSpawn(damager.getLocation())) {
                Util.error(damager, RegionsConfig.chatCannotFightHere);
                event.setCancelled(true);
            }
        } else if (damaged instanceof ItemFrame) {
            if (isPvP(damaged.getLocation()) && !damager.hasPermission(RegionsConfig.permissionRegionsBypass)) {
                Util.error(damager, RegionsConfig.chatCannotFightHere);
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onDamage(final EntityDamageEvent e) {
        if (isSpawn(e.getEntity().getLocation())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onFoodLevel(final FoodLevelChangeEvent event) {
        final HumanEntity player = event.getEntity();
        if (player instanceof Player && isSpawn(player.getLocation())) {
            ((Player) player).setFoodLevel(20);
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onHangingPlace(final HangingPlaceEvent event) {
        if (isPvP(event.getBlock().getLocation()) && !event.getPlayer().hasPermission(RegionsConfig.permissionRegionsBypass) && event.getEntity() instanceof ItemFrame) {
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void onWeather(final WeatherChangeEvent event) {
        event.setCancelled(true);
    }
}
