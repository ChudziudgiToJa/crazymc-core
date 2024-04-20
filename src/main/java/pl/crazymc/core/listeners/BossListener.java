package pl.crazymc.core.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import pl.crazymc.core.builders.ItemBuilder;
import pl.crazymc.core.utils.RandomUtil;
import pl.crazymc.core.utils.Util;

import java.util.Arrays;
import java.util.List;


public class BossListener implements Listener {
    private static final List<ItemStack> bossDrops = Arrays.asList(new ItemBuilder(Material.DIAMOND_SWORD).setTitle("&c&lBOSKI MIECZ").addEnchant(Enchantment.DAMAGE_ALL, 7).addEnchant(Enchantment.FIRE_ASPECT, 2).build(), new ItemBuilder(Material.BEACON).setTitle("&c&lBOSKI BEACON").build(), new ItemBuilder(Material.DIAMOND_HELMET).setTitle("&c&lBOSKI HELM").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5).addEnchant(Enchantment.DURABILITY, 4).build(), new ItemBuilder(Material.DIAMOND_CHESTPLATE).setTitle("&c&lBOSKA KLATA").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5).addEnchant(Enchantment.DURABILITY, 4).build(), new ItemBuilder(Material.DIAMOND_LEGGINGS).setTitle("&c&lBOSKIE SPODNIE").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5).addEnchant(Enchantment.DURABILITY, 4).build(), new ItemBuilder(Material.DIAMOND_BOOTS).setTitle("&c&lBOSKIE BUTY").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5).addEnchant(Enchantment.DURABILITY, 4).build());

    @EventHandler
    public void onDeath(final EntityDeathEvent event) {
        final Entity entity = event.getEntity();
        if (entity.getCustomName() != null && entity.getCustomName().contains(Util.fixColor("&6&lBOSS"))) {
            event.getDrops().clear();
//            entity.getWorld().spigot().playEffect(entity.getLocation(), Effect.CLOUD, 1, 1, 1.f, 1.3f, 1.f, 0.1f, 50, 25);
//            entity.getWorld().spigot().playEffect(entity.getLocation(), Effect.COLOURED_DUST, 1, 1, 1.f, 1.3f, 1.f, 0, 30, 25);
            for (int i = 0; i < 3; i++) {
                entity.getWorld().strikeLightningEffect(entity.getLocation());
            }
            for (int i = 0; i < 2; i++) {
                event.getDrops().add(bossDrops.get(RandomUtil.randomInts(bossDrops.size())));
            }
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                if (Util.fastDistance(onlinePlayer.getLocation(), entity.getLocation()) < 25) {
//                    onlinePlayer.getWorld().playSound(onlinePlayer.getLocation(), Sound.ENDERDRAGON_DEATH, 20.f, 20.f);
                }
            }
            Bukkit.broadcastMessage(Util.fixColor("&6&lBOSS &8* &7Boss zostal zabity!"));
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                final Location loc = entity.getLocation();
                double radius = 0.3;
                for (double i = 0; i < 50; i += 0.05) {
                    final double x = (radius * Math.cos(i));
                    final double z = (radius * Math.sin(i));
                    loc.add(x, 0.01, z);
//                    onlinePlayer.getWorld().spigot().playEffect(loc, Effect.FLAME, 0, 0, 0, 0, 0, 0, 1, 25);
                    loc.subtract(x, 0.0, z);
                    radius += 0.005;
                }
            }
        }
    }

    @EventHandler
    public void onDamage(final EntityDamageByEntityEvent event) {
        final Entity entity = event.getEntity();
        final Entity damager = event.getDamager();
        if (damager instanceof Player && entity.getCustomName() != null && entity.getCustomName().contains(Util.fixColor("&6&lBOSS")) && entity.getType() == EntityType.SKELETON) {
            final Skeleton skeleton = (Skeleton) entity;
            skeleton.setCustomName(Util.fixColor("&6&lBOSS &a" + (int) skeleton.getHealth() + "&8/&c" + skeleton.getMaxHealth()));
//            ((Player) damager).playSound(damager.getLocation(), Sound.ZOMBIE_WOOD, 15.f, 15.f);
//            entity.getWorld().spigot().playEffect(entity.getLocation(), Effect.TILE_BREAK, 1, 1, 1.f, 1.3f, 1.f, 0, 30, 25);
//            entity.getWorld().spigot().playEffect(entity.getLocation(), Effect.COLOURED_DUST, 1, 1, 1.f, 1.3f, 1.f, 0, 30, 25);
            if (Math.random() * 100.0 <= 5.0) {
                ((Player) damager).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 120, 2, true));
                ((Player) damager).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 120, 2, true));
                ((Player) damager).addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 120, 2, true));
            }
        }
    }


}
