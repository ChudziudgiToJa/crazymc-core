//package pl.crazymc.core.inventories;
//
//import org.bukkit.Material;
//import org.bukkit.entity.Player;
//import org.bukkit.inventory.ItemStack;
//import org.bukkit.inventory.meta.ItemMeta;
//import pl.crazymc.core.utils.GlassPane;
//import pl.crazymc.core.builders.InventoryBuilder;
//import pl.crazymc.core.builders.ItemBuilder;
//import pl.crazymc.core.utils.Util;
//
//import java.util.Arrays;
//import java.util.List;
//
//public class VillagerGui {
//
//    private static final Integer[] slotList = {10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25, 28, 29, 30, 31, 32, 33, 34};
//    private static final ItemStack is1 = new ItemBuilder(Material.DIAMOND_CHESTPLATE).setTitle("&bZbroja i narzedzia").setGlow(true).build();
//    private static final ItemStack is2 = new ItemBuilder(Material.GOLDEN_APPLE).setTitle("&eUlepszone przedmioty").build();
//    private static final ItemStack is3 = new ItemBuilder(Material.CAKE).setTitle("&6Przydatne przedmioty").build();
//    private static final ItemStack is4 = new ItemBuilder(Material.OAK_LOG).setTitle("&7Drewno").build();
//    private static final ItemStack is5 = new ItemBuilder(Material.SNOW_BLOCK).setTitle("&fSnieg").build();
//    private static final ItemStack is6 = new ItemBuilder(Material.NETHERRACK).setTitle("&cNether").build();
//    private static final ItemStack is7 = new ItemBuilder(Material.FLOWERING_AZALEA_LEAVES).setTitle("&dKwiatki").build();
//    private static final ItemStack is8 = new ItemBuilder(Material.CLAY).setTitle("&7Glina").build();
//    private static final ItemStack is9 = new ItemBuilder(Material.RED_STAINED_GLASS).setTitle("&7Szklo").build();
//    private static final ItemStack is10 = new ItemBuilder(Material.WHITE_WOOL).setTitle("&7Welna").build();
//    private static final ItemStack is11 = new ItemBuilder(Material.EMERALD_ORE).setTitle("&aGeneratory").setGlow(true).build();
//    private static final ItemStack is12 = new ItemBuilder(Material.TNT).setTitle("&cWbita").build();
//    private static final ItemStack is13 = new ItemBuilder(Material.CHEST).setTitle("&7Kopanie").build();
//    private static final ItemStack is14 = new ItemBuilder(Material.BEDROCK).setTitle("&5Bloki").build();
//
//    private static final ItemStack backItem = new ItemBuilder(Material.RED_BANNER).setTitle("&cPowrot.").build();
//
//    public static Integer[] getSlotList() {
//        return slotList;
//    }
//
//    public static void open(final Player player) {
//        final InventoryBuilder inv = new InventoryBuilder("&8» &aWymiana&6:", 45);
//        inv.setItem(10, is1, event -> openPage(player, 0, "Zbroja i narzedzia"));
//        inv.setItem(11, is2, event -> openPage(player, 1, "Ulepszone przedmioty"));
//        inv.setItem(12, is3, event -> openPage(player, 2, "Przydatne przedmioty"));
//        inv.setItem(13, is4, event -> openPage(player, 3, "Drewno"));
//        inv.setItem(14, is5, event -> openPage(player, 4, "Snieg"));
//        inv.setItem(15, is6, event -> openPage(player, 5, "Nether"));
//        inv.setItem(16, is7, event -> openPage(player, 6, "Kwiatki"));
//        inv.setItem(19, is8, event -> openPage(player, 7, "Glina"));
//        inv.setItem(20, is9, event -> openPage(player, 8, "Szklo"));
//        inv.setItem(21, is10, event -> openPage(player, 9, "Welna"));
//        inv.setItem(22, is11, event -> openPage(player, 10, "Generatory"));
//        inv.setItem(23, is12, event -> openPage(player, 11, "Wbita"));
//        inv.setItem(24, is13, event -> openPage(player, 12, "Kopanie"));
//        inv.setItem(25, is14, event -> openPage(player,13,"Bloki"));
//        inv.open(player, GlassPane.LIGHT_BLUE);
//    }
//
//    private static void openPage(final Player player, int integer, String title) {
//        final InventoryBuilder inv = new InventoryBuilder("&8» &aWymiana - " + title + "&6:", 45);
//        final List<Villager> list = Villager.getVillagerList().get(integer);
//        if (list != null) {
//            int i = 0;
//            for (Villager villager : list) {
//                final ItemStack itemStack = villager.getItemStack().clone();
//                final ItemMeta itemMeta = itemStack.getItemMeta();
//                itemMeta.setLore(Util.fixColor(Arrays.asList(" &7Kup za: &a" + villager.getCostItem().getAmount() + (villager.getCostItem().getType() == Material.GOLD_BLOCK ? " blok zlota" : " zlota"), " &7Kliknij, aby kupic!")));
//                itemStack.setItemMeta(itemMeta);
//                inv.setItem(getSlotList()[i++], itemStack, event -> villager.trade(player));
//            }
//            inv.setItem(44, backItem, event -> open(player));
//            inv.open(player, GlassPane.LIGHT_BLUE);
//        }
//    }
//}
