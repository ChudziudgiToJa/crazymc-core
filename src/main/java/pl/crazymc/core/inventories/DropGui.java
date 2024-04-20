package pl.crazymc.core.inventories;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import pl.crazymc.core.configuration.Config;
import pl.crazymc.core.managers.DropManager;
import pl.crazymc.core.managers.UserManager;
import pl.crazymc.core.objects.Drop;
import pl.crazymc.core.objects.User;
import pl.crazymc.core.utils.DataUtil;
import pl.crazymc.core.utils.GlassPane;
import pl.crazymc.core.builders.InventoryBuilder;
import pl.crazymc.core.builders.ItemBuilder;

public class DropGui {
    private static final Integer[] slotList = {10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25, 28, 29, 30, 31, 32, 33, 34};
    private static final ItemStack enableItem = new ItemBuilder(Material.GREEN_CANDLE).setTitle("&aWlacz caly drop").build();
    private static final ItemStack disableItem = new ItemBuilder(Material.RED_CANDLE).setTitle("&cWylacz caly drop").build();
    private static final ItemStack guildItem = new ItemBuilder(Material.YELLOW_CANDLE).setTitle("&6Wlacz itemy na gildie").build();
    private static final ItemStack bookItem = new ItemBuilder(Material.BOOK).setTitle("&8* &9Bonusy:").addLore("&8» &fFortuna zwieksza drop&8:", " &eFortuna I &8(&f+0.25%&8)", " &eFortuna II &8(&f+0.50%&8)", " &eFortuna III &8(&f+1.00%&8)").build();

    public static Integer[] getSlotList() {
        return slotList;
    }

    public static void open(final Player player) {
        final InventoryBuilder inv = new InventoryBuilder("&8» &aDrop z kamienia&6:", 54);
        final User user = UserManager.getUser(player);
        int i = 0;
        for (Drop drop : DropManager.getDrops()) {
            if (drop.getName().contains("PremiumCase") && !(Config.turboCase > System.currentTimeMillis())) {
                continue;
            }
            inv.setItem(getSlotList()[i++], new ItemBuilder(drop.getItemStack().getType(), drop.getItemStack().getDurability()).setTitle(drop.getColor() + drop.getName()).addLore(
                    "&7Szansa: &f" + drop.getChance(),
                    "&7Ilosc: &f" + drop.getMinAmount() + "-" + drop.getMaxAmount(),
                    "&7Fortuna: " + (drop.isFortune() ? "&aTAK" : "&cNIE"),
                    "&7Status: " + (user.isEnabled(drop) ? "&awlaczony" : "&cwylaczony")).setGlow(user.isEnabled(drop)).build(), e -> {
                user.changeStatus(drop);
                open(player);
            });
        }
        final ItemStack dropCobblestone = new ItemBuilder(Material.COBBLESTONE).setTitle("&7&lBruk").addLore("&7Status: " + (user.dropCobblestone ? "&aTAK" : "&cNIE")).setGlow(user.dropCobblestone).build();
        final ItemStack turboDropItem = new ItemBuilder(Material.PAPER).setTitle("&e* &5&lTurbo&b&lDrop").addLore("&7Status: &f" + (Config.turboDrop > System.currentTimeMillis() ? "&aTAK ( " + DataUtil.secondsToString(Config.turboDrop - System.currentTimeMillis()) + " )" : "&cNIE"), "&7Status gracz: &f" + (user.turboDrop > System.currentTimeMillis() ? "&aTAK ( " + DataUtil.secondsToString(user.turboDrop - System.currentTimeMillis()) + " )" : "&cNIE")).build();
        inv.setItem(43, bookItem);
        inv.setItem(42, turboDropItem);
        inv.setItem(41, dropCobblestone, e -> {
            user.dropCobblestone = !user.dropCobblestone;
            open(player);
        });

        inv.setItem(39, disableItem, e -> {
            user.enabledDrops.clear();
            for (final Drop drop : DropManager.getDrops()) user.setStatus(drop, false);
            open(player);
        });
        inv.setItem(38, guildItem, e -> {
            user.enabledDrops.clear();
            for (final Drop drop : DropManager.getDrops()) user.setStatus(drop, drop.isGuild());
            open(player);
        });
        inv.setItem(37, enableItem, e -> {
            user.enabledDrops.clear();
            for (final Drop drop : DropManager.getDrops()) user.setStatus(drop, true);
            open(player);
        });
        inv.open(player, GlassPane.LIGHT_BLUE);
    }
}
