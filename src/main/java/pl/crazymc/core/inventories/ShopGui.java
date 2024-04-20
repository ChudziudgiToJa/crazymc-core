package pl.crazymc.core.inventories;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.crazymc.core.managers.TopManager;
import pl.crazymc.core.managers.UserManager;
import pl.crazymc.core.objects.Shop;
import pl.crazymc.core.objects.User;
import pl.crazymc.core.utils.GlassPane;
import pl.crazymc.core.builders.InventoryBuilder;
import pl.crazymc.core.builders.ItemBuilder;
import pl.crazymc.core.utils.Util;

import java.util.Arrays;

public class ShopGui {
    private static final ItemStack buyItem = new ItemBuilder(Material.GREEN_CANDLE).setTitle("&a&lKup przedmioty.").build();
    private static final ItemStack sellItem = new ItemBuilder(Material.RED_CANDLE).setTitle("&c&lSprzedaj przedmioty.").build();
    private static final ItemStack villagerItem = new ItemBuilder(Material.GOLD_INGOT).setTitle("&2&lWymiana za zloto").build();
    private static final ItemStack informationItem = new ItemBuilder(Material.BOOK).setTitle("&6&lINFORMACJA").build();
    private static final ItemStack backItem = new ItemBuilder(Material.RED_BANNER).setTitle("&cPowrot.").build();
    private static final ItemStack sellAllItem = new ItemBuilder(Material.HOPPER).setTitle("&b&nSPRZEDAJ WSZYSTKO").addLore("&7Mozesz tez uzyc komendy &b/sellall").build();

    public static void open(final Player player) {
        final InventoryBuilder inv = new InventoryBuilder("&8» &aSklep&6:", 45);
        final User user = UserManager.getUser(player);
        inv.setItem(10, buyItem, event -> openBuy(player));
        inv.setItem(13, new ItemBuilder(Material.NETHER_STAR)
                .setTitle("&6&lStan konta:")
                .addLore("&7Posiadasz: &e&n" + user.coins / 100.0)
                .build());
       inv.setItem(16, sellItem, event -> openSell(player));
//        inv.setItem(28, villagerItem, event -> VillagerGui.open(player));
        inv.setItem(31, new TopManager().getTopCoins());
        inv.setItem(34, informationItem);
        inv.open(player, GlassPane.LIGHT_BLUE);
    }

    public static void openBuy(final Player player) {
        final InventoryBuilder inv = new InventoryBuilder("&8» &aSklep - kupowanie&6:", 45);
        int i = 0;
        for (final Shop shop : Shop.buyItems) {
            final ItemStack itemStack = shop.getItemStack().clone();
            final ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setLore(Util.fixColor(Arrays.asList(
                    "&8» &7Kupisz za: &b" + shop.getCost() + " &7zl.",
                    "&8» &7Kliknij, aby kupic ten przedmiot!")));
            if (shop.getName() != null) {
                itemMeta.setDisplayName(Util.fixColor(shop.getName()));
            }
            itemStack.setItemMeta(itemMeta);
            inv.setItem(i++, itemStack, event -> shop.shopItem(player, Shop.Type.BUY));
        }
        inv.setItem(44, backItem, event -> open(player));
        inv.open(player, GlassPane.LIGHT_BLUE);
    }

    public static void openSell(final Player player) {
        final InventoryBuilder inv = new InventoryBuilder("&8» &aSklep - sprzedawanie&6:", 45);
        int i = 0;
        for (Shop shop : Shop.sellItems) {
            final ItemStack itemStack = shop.getItemStack().clone();
            final ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setLore(Util.fixColor(Arrays.asList(
                    "&8» &7Sprzedasz za: &b" + shop.getCost() + "&7 zl.",
                    "&8» &7Kliknij, aby sprzedac ten przedmiot!")));
            if (shop.getName() != null) {
                itemMeta.setDisplayName(Util.fixColor(shop.getName()));
            }
            itemStack.setItemMeta(itemMeta);
            inv.setItem(i++, itemStack, event -> shop.shopItem(player, Shop.Type.SELL));
        }
        inv.setItem(44, backItem, event -> open(player));
        inv.setItem(43, sellAllItem, event -> Shop.sellAll(player));
        inv.open(player, GlassPane.LIGHT_BLUE);
    }
}
