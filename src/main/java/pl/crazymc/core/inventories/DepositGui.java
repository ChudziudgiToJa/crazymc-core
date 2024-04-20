package pl.crazymc.core.inventories;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import pl.crazymc.core.builders.InventoryBuilder;
import pl.crazymc.core.builders.ItemBuilder;
import pl.crazymc.core.configuration.DepositConfig;
import pl.crazymc.core.managers.UserManager;
import pl.crazymc.core.objects.User;
import pl.crazymc.core.utils.GlassPane;
import pl.crazymc.core.utils.Util;

public class DepositGui {

    public static void open(final Player player) {
        final InventoryBuilder inv = new InventoryBuilder("&8» &aSchowek&6:", 45);
        final User user = UserManager.getUser(player);
        inv.setItem(10,
                new ItemBuilder(Material.ENCHANTED_GOLDEN_APPLE)
                        .setTitle("&f&l» &6&lKoxy&8:")
                        .addLore("",
                                "&8» &fW schowku&8: &a" + user.godApples,
                                "&8» &fLimit w EQ&8: &a" + DepositConfig.godApplesLimit,
                                "",
                                "&8» &ePPM &8- &fWyplacasz item do ekwipunku.").build(),
                event -> withdrawGodApples(player));
        inv.setItem(13,
                new ItemBuilder(Material.GOLDEN_APPLE)
                        .setTitle("&f&l» &e&lRefile&8:")
                        .addLore("",
                                "&8» &fW schowku&8: &a" + user.goldenApples,
                                "&8» &fLimit w EQ&8: &a" + DepositConfig.goldenApplesLimit,
                                "",
                                "&8» &ePPM &8- &fWyplacasz item do ekwipunku.").build(),
                event -> withdrawGoldenApples(player));
        inv.setItem(16,
                new ItemBuilder(Material.ENDER_PEARL)
                        .setTitle("&f&l» &9&lPerly&8:")
                        .addLore("",
                                "&8» &fW schowku&8: &a" + user.enderPearls,
                                "&8» &fLimit w EQ&8: &a" + DepositConfig.enderPearlsLimit,
                                "",
                                "&8» &ePPM &8- &fWyplacasz item do ekwipunku.").build(),
                event -> withdrawEnderPearls(player));
        inv.setItem(31,new ItemBuilder(Material.NETHER_STAR).setTitle("&8>&7>&f> &a&lDOBIERZ DO LIMITU &f<&7<&8<").build(), event -> {
            withdrawGodApples(player);
            withdrawGoldenApples(player);
            withdrawEnderPearls(player);
        });
        inv.open(player, GlassPane.LIGHT_BLUE);
    }

    public static void withdrawGodApples(final Player player) {
        final User user = UserManager.getUser(player);
        if (user.godApples > 0) {
            if (Util.getAmount(player, Material.ENCHANTED_GOLDEN_APPLE) < DepositConfig.godApplesLimit) {
                if (user.godApples > DepositConfig.godApplesLimit) {
                    Util.msg(player, DepositConfig.chatGodApplesWithdraw.replace("{AMOUNT}", String.valueOf(DepositConfig.godApplesLimit)));
                    Util.giveItems(player, new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, DepositConfig.godApplesLimit));
                    user.godApples -= DepositConfig.godApplesLimit;
                } else {
                    Util.msg(player, DepositConfig.chatGodApplesWithdraw.replace("{AMOUNT}", String.valueOf(user.godApples)));
                    Util.giveItems(player, new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, user.godApples));
                    user.godApples -= user.godApples;
                }
            }
        }
    }

    public static void withdrawGoldenApples(final Player player) {
        final User user = UserManager.getUser(player);
        if (user.goldenApples > 0) {
            if (Util.getAmount(player, Material.GOLDEN_APPLE) < DepositConfig.goldenApplesLimit) {
                if (user.goldenApples > DepositConfig.goldenApplesLimit) {
                    Util.msg(player, DepositConfig.chatGoldenApplesWithdraw.replace("{AMOUNT}", String.valueOf(DepositConfig.goldenApplesLimit)));
                    Util.giveItems(player, new ItemStack(Material.GOLDEN_APPLE, DepositConfig.goldenApplesLimit));
                    user.goldenApples -= DepositConfig.goldenApplesLimit;
                } else {
                    Util.msg(player, DepositConfig.chatGoldenApplesWithdraw.replace("{AMOUNT}", String.valueOf(user.goldenApples)));
                    Util.giveItems(player, new ItemStack(Material.GOLDEN_APPLE, user.goldenApples));
                    user.goldenApples -= user.goldenApples;
                }
            }
        }
    }

    public static void withdrawEnderPearls(final Player player) {
        final User user = UserManager.getUser(player);
        if (user.enderPearls > 0) {
            if (Util.getAmount(player, Material.ENDER_PEARL) < DepositConfig.enderPearlsLimit) {
                if (user.enderPearls > DepositConfig.enderPearlsLimit) {
                    Util.msg(player, DepositConfig.chatEnderPearlsWithdraw.replace("{AMOUNT}", String.valueOf(DepositConfig.enderPearlsLimit)));
                    Util.giveItems(player, new ItemStack(Material.ENDER_PEARL, DepositConfig.enderPearlsLimit));
                    user.enderPearls -= DepositConfig.enderPearlsLimit;
                } else {
                    Util.msg(player, DepositConfig.chatEnderPearlsWithdraw.replace("{AMOUNT}", String.valueOf(user.enderPearls)));
                    Util.giveItems(player, new ItemStack(Material.ENDER_PEARL, user.enderPearls));
                    user.enderPearls -= user.enderPearls;
                }
            }
        }
    }
}
