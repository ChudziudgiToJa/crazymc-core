package pl.crazymc.core.objects;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import pl.crazymc.core.builders.ItemBuilder;

import java.util.HashMap;

public class Kit {
    private static final HashMap<Integer, Kit> kits = new HashMap<>();

    static {
        kits.put(10, new Kit("start", new ItemBuilder(Material.LEATHER_CHESTPLATE).setTitle("&3&l» &bZestaw: &3GRACZ").build()));
        kits.put(11, new Kit("vip", new ItemBuilder(Material.IRON_CHESTPLATE).setTitle("&3&l» &bZestaw: &6VIP").build()));
        kits.put(12, new Kit("svip", new ItemBuilder(Material.GOLDEN_CHESTPLATE).setTitle("&3&l» &bZestaw: &eSVIP").build()));
        kits.put(13, new Kit("ultravip", new ItemBuilder(Material.DIAMOND_CHESTPLATE).setTitle("&3&l» &bZestaw: &b&lUltraVIP").build()));
        kits.put(14, new Kit("jedzenie", new ItemBuilder(Material.COOKED_BEEF).setTitle("&3&l» &bZestaw: &6Jedzenie").build()));
        kits.put(15, new Kit("tnt", new ItemBuilder(Material.TNT).setTitle("&3&l» &bZestaw: &4&lTNT").build()));
        kits.put(16, new Kit("youtube", new ItemBuilder(Material.NETHERITE_CHESTPLATE).setTitle("&3&l» &bZestaw: &4You&fTuber").build()));
    }

    private final String name;
    private final ItemStack itemStack;
    public Kit(String name, ItemStack itemStack) {
        this.name = name;
        this.itemStack = itemStack;
    }

    public static HashMap<Integer, Kit> getKits() {
        return kits;
    }

    public String getPermission() {
        return "essentials.kits." + name;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public String getName() {
        return name;
    }

    public void give(final Player player) {
        player.performCommand("essentials:kit " + name);
    }
}
