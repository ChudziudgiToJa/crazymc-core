package pl.crazymc.core.listeners;

import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.player.*;
import org.bukkit.event.vehicle.VehicleDestroyEvent;
import org.bukkit.event.vehicle.VehicleEntityCollisionEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.projectiles.ProjectileSource;
import pl.crazymc.core.configuration.CraftingsConfig;
import pl.crazymc.core.inventories.EnchantGui;
import pl.crazymc.core.managers.UserManager;
import pl.crazymc.core.managers.VanishManager;
import pl.crazymc.core.objects.User;
import pl.crazymc.core.utils.Util;

public class PlayerInteractListener implements Listener {
    @EventHandler
    public void onInteract(final PlayerInteractEvent event) {
        final Player player = event.getPlayer();
        final Action action = event.getAction();
        if ((action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) && player.getItemInHand().isSimilar(CraftingsConfig.atomicTnT)) {
            event.setCancelled(true);
            player.getInventory().removeItem(CraftingsConfig.atomicTnT);
            final TNTPrimed tnt = player.getWorld().spawn(player.getLocation(), TNTPrimed.class);
            tnt.setFuseTicks(60);
            tnt.setVelocity(player.getEyeLocation().getDirection().normalize().multiply(0.9));
        } else if (action == Action.RIGHT_CLICK_BLOCK && event.getClickedBlock().getType() == Material.ENCHANTING_TABLE) {
            event.setCancelled(true);
            if (event.getItem() != null) {
                EnchantGui.open(player, event.getItem());
                return;
            }
            Util.error(player, "Musisz trzymac cos w reku!");
        }
    }

    @EventHandler
    public void onEat(final PlayerItemConsumeEvent event) {
        final Player p = event.getPlayer();
        final User user = UserManager.getUser(p);
        final ItemStack is = event.getItem();
        if (is.getType().equals(Material.GOLDEN_APPLE) && is.getDurability() == 1) {
            user.godApplesEat++;
        }
    }

//    @EventHandler
//    public void onInteract1(final PlayerInteractEntityEvent event) {
//        final Player player = event.getPlayer();
//        final Entity entity = event.getRightClicked();
//        if (entity instanceof Villager && entity.getCustomName().contains("Wymiana za zloto")) {
//            event.setCancelled(true);
//            VillagerGui.open(player);
//        }
//    }

    @EventHandler(ignoreCancelled = true)
    public void onPickup(final PlayerPickupItemEvent event) {
        final Player player = event.getPlayer();
        if (VanishManager.isVanished(player)) {
            event.setCancelled(true);
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onDrop(final PlayerDropItemEvent event) {
        final Player player = event.getPlayer();
        if (VanishManager.isVanished(player)) {
            event.setCancelled(true);
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onEntityTarget(final EntityTargetEvent event) {
        if (event.getTarget() instanceof Player && VanishManager.isVanished((Player) event.getTarget())) {
            event.setCancelled(true);
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onVehicleEntityCollision(final VehicleEntityCollisionEvent event) {
        if (event.getEntity() instanceof Player && VanishManager.isVanished((Player) event.getEntity())) {
            event.setCancelled(true);
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onVehicleDestroy(final VehicleDestroyEvent event) {
        final Entity entity = event.getAttacker();
        if (entity instanceof Player && VanishManager.isVanished((Player) event.getAttacker())) {
            event.setCancelled(true);
        }
    }

    @EventHandler(ignoreCancelled = true)
    public final void onDamage(EntityDamageByEntityEvent event) {
        final Entity victim = event.getEntity();
        Entity attacker = event.getDamager();
        if (attacker != null && !(attacker instanceof TNTPrimed) && victim instanceof Player) {
            if (attacker instanceof Projectile) {
                ProjectileSource shooter = ((Projectile) attacker).getShooter();
                if (shooter instanceof Entity) {
                    attacker = (Entity) shooter;
                }
            }
            if (attacker instanceof Player && VanishManager.isVanished((Player) attacker)) {
                event.setCancelled(true);
            }
        }
    }
}
