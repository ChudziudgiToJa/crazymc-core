package pl.crazymc.core.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import pl.crazymc.core.configuration.EnderEventConfig;
import pl.crazymc.core.utils.Util;

import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class EnderEventListener extends BukkitRunnable implements Listener {
    public static HashMap<UUID, Long> cooldownPlayers = new HashMap<>();
    final Random random = new Random();
    final Location locationSpawn = new Location(Bukkit.getWorlds().get(0), 0.5, 100, 0.5);
    final String endDisabledMessage = "&cEnd jest dostepny od godziny 16 do 20!";

    @EventHandler
    public void onPortal(final PlayerPortalEvent event) {
        final Player player = event.getPlayer();
        final PlayerTeleportEvent.TeleportCause cause = event.getCause();
        final Location location = Bukkit.getWorld("world_the_end").getSpawnLocation().add(0.5, 0.0, 0.5);
        if (cause == PlayerTeleportEvent.TeleportCause.END_PORTAL) {
            event.setCancelled(true);
            if (cooldownPlayers.getOrDefault(player.getUniqueId(), 0L) < System.currentTimeMillis()) {
                cooldownPlayers.put(player.getUniqueId(), System.currentTimeMillis() + 5000L);
                if (EnderEventConfig.isEnabled()) {
                    player.teleport(location);
                    Util.msg(player, "&eTeleportacja..");
                } else Util.msg(player, endDisabledMessage);
            }
        }
    }

    @EventHandler
    public void onBreak(final BlockBreakEvent event) {
        if (event.getBlock().getWorld().getName().equals("world_the_end") && !event.getPlayer().isOp()) {
            Util.msg(event.getPlayer(), "&cNie mozesz tutaj niszczyc!");
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlace(final BlockPlaceEvent event) {
        if (event.getBlock().getWorld().getName().equals("world_the_end") && !event.getPlayer().isOp()) {
            Util.msg(event.getPlayer(), "&cNie mozesz tutaj budowac!");
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onDeath(final EntityDeathEvent event) {
        final LivingEntity entity = event.getEntity();
        final List<ItemStack> drops = event.getDrops();
        if (entity.getType() == EntityType.ENDERMAN) {
            drops.clear();
            drops.add(EnderEventConfig.endermanDrops.get(random.nextInt(EnderEventConfig.endermanDrops.size())));
        }
    }

    @EventHandler
    public void onJoin(final PlayerJoinEvent event) {
        if (event.getPlayer().getWorld().getName().equals("world_the_end")) {
            if (!EnderEventConfig.isEnabled()) {
                Util.msg(event.getPlayer(), endDisabledMessage);
                event.getPlayer().teleport(locationSpawn);
            }
        }
    }

    @EventHandler
    public void onTeleport(final PlayerTeleportEvent event) {
        if (event.getTo().getWorld().getName().equals("world_the_end")) {
            if (!EnderEventConfig.isEnabled()) {
                Util.msg(event.getPlayer(), endDisabledMessage);
                event.getPlayer().teleport(locationSpawn);
            }
        }
    }

    @EventHandler
    public void onQuit(final PlayerQuitEvent event) {
        cooldownPlayers.remove(event.getPlayer().getUniqueId());
    }

    @Override
    public void run() {
        if (!EnderEventConfig.isEnabled()) {
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                if (onlinePlayer.getWorld().getName().equals("world_the_end")) {
                    Util.msg(onlinePlayer, endDisabledMessage);
                    onlinePlayer.teleport(locationSpawn);
                }
            }
        }
    }
}
