package pl.crazymc.core.objects;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import pl.crazymc.core.builders.ItemBuilder;
import pl.crazymc.core.utils.Util;

public class Boss {

    public Boss(Location location) {
        Skeleton skeleton = (Skeleton) location.getWorld().spawnEntity(location, EntityType.SKELETON);
        skeleton.setMaxHealth(2000.f);
        skeleton.setHealth(2000.f);
        skeleton.getEquipment().setHelmet(new ItemStack(Material.DRAGON_HEAD));
        skeleton.getEquipment().setChestplate(new ItemBuilder(Material.LEATHER_CHESTPLATE).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,200).addEnchant(Enchantment.DURABILITY,100).build());
        skeleton.getEquipment().setLeggings(new ItemBuilder(Material.CHAINMAIL_LEGGINGS).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,200).addEnchant(Enchantment.DURABILITY,100).build());
        skeleton.getEquipment().setBoots(new ItemBuilder(Material.GOLDEN_BOOTS).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,200).addEnchant(Enchantment.DURABILITY,100).build());
        skeleton.getEquipment().setItemInHand(new ItemBuilder(Material.BOW).addEnchant(Enchantment.ARROW_DAMAGE,5).addEnchant(Enchantment.ARROW_FIRE,10).addEnchant(Enchantment.ARROW_KNOCKBACK,5).build());
        skeleton.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,10000000, 1,true));
        skeleton.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,10000000, 1,true));
        skeleton.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE,10000000, 1,true));
        skeleton.setCustomName(Util.fixColor("&6&lBOSS &a" + (int)skeleton.getHealth() + "&8/&c" + skeleton.getMaxHealth()));
        Bukkit.broadcastMessage(Util.fixColor("&6&lBOSS &8* &7Na koordach X: " + location.getBlockX() + ", Z: " + location.getBlockZ() + " pojawil sie boss!"));
    }
}
