package pl.crazymc.core.objects;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import pl.crazymc.core.builders.ItemBuilder;
import pl.crazymc.core.utils.Util;

import java.util.HashMap;

public class Effect {
    public static HashMap<Integer,Effect> effects = new HashMap<>();
    static {
        effects.put(10,new Effect(52, new ItemBuilder(Material.DIAMOND_SWORD).setTitle("&3&lSILKA I").addLore("","&8» &7Koszt: &e54 bloki zlota.","&8» &7Czas trwania: &f3min.",""," &8» &aKliknij, aby zakupic ten efekt!").build(),new PotionEffect(PotionEffectType.INCREASE_DAMAGE,3600,0,false)));
        effects.put(12,new Effect(12, new ItemBuilder(Material.IRON_BOOTS).setTitle("&3&lSZYBKOSC I").addLore("","&8» &7Koszt: &e12 blokow zlota.","&8» &7Czas trwania: &f5min.",""," &8» &aKliknij, aby zakupic ten efekt!").build(),new PotionEffect(PotionEffectType.SPEED,6000,0,false)));
        effects.put(14,new Effect(12, new ItemBuilder(Material.CARROT).setTitle("&3&lWYSOKIE SKAKANIE II").addLore("","&8» &7Koszt: &e12 blokow zlota.","&8» &7Czas trwania: &f1min.",""," &8» &aKliknij, aby zakupic ten efekt!").build(),new PotionEffect(PotionEffectType.JUMP,1200,1,false)));
        effects.put(16,new Effect(10, new ItemBuilder(Material.IRON_PICKAXE).setTitle("&3&lSZYBKIE KOPANIE II").addLore("","&8» &7Koszt: &e10 blokow zlota.","&8» &7Czas trwania: &f5min.",""," &8» &aKliknij, aby zakupic ten efekt!").build(),new PotionEffect(PotionEffectType.FAST_DIGGING,6000,1,false)));
        effects.put(19,new Effect(8, new ItemBuilder(Material.CLOCK).setTitle("&3&lWIDZENIE W CIEMNOSCI I").addLore("","&8» &7Koszt: &e8 blokow zlota.","&8» &7Czas trwania: &f15min.",""," &8» &aKliknij, aby zakupic ten efekt!").build(),new PotionEffect(PotionEffectType.NIGHT_VISION,18000,0,false)));
        effects.put(21,new Effect(20, new ItemBuilder(Material.DIAMOND_BOOTS).setTitle("&3&lSZYBKOSC II").addLore("","&8» &7Koszt: &e20 blokow zlota.","&8» &7Czas trwania: &f5min.",""," &8» &aKliknij, aby zakupic ten efekt!").build(),new PotionEffect(PotionEffectType.SPEED,6000,1,false)));
        effects.put(23,new Effect(18, new ItemBuilder(Material.GOLDEN_CARROT).setTitle("&3&lWYSOKIE SKAKANIE III").addLore("","&8» &7Koszt: &e18 blokow zlota.","&8» &7Czas trwania: &f1min.",""," &8» &aKliknij, aby zakupic ten efekt!").build(),new PotionEffect(PotionEffectType.JUMP,1200,2,false)));
        effects.put(25,new Effect(15, new ItemBuilder(Material.DIAMOND_PICKAXE).setTitle("&3&lSZYBKIE KOPANIE III").addLore("","&8» &7Koszt: &e15 blokow zlota.","&8» &7Czas trwania: &f5min.",""," &8» &aKliknij, aby zakupic ten efekt!").build(),new PotionEffect(PotionEffectType.FAST_DIGGING,6000,2,false)));
    }
    private static final ItemStack emeraldItem = new ItemStack(Material.GOLD_BLOCK);

    private final int cost;
    private final ItemStack itemStack;
    private final PotionEffect potionEffect;

    public Effect(int cost, final ItemStack itemStack, final PotionEffect potionEffect) {
        this.cost = cost;
        this.itemStack = itemStack;
        this.potionEffect = potionEffect;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public void buy(final Player player) {
        final Inventory inv = player.getInventory();
        final ItemStack emerald = emeraldItem.clone();
        if (inv.containsAtLeast(emerald, cost)) {
            emerald.setAmount(cost);
            inv.removeItem(emerald);
            player.removePotionEffect(potionEffect.getType());
            player.addPotionEffect(potionEffect);
            Util.succes(player, "&aPomyslnie zakupiles ten efekt.");
        } else Util.error(player, "Nie posiadasz tyle blokow zlota.");
    }
}
