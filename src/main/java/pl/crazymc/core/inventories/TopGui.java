package pl.crazymc.core.inventories;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import pl.crazymc.core.builders.InventoryBuilder;
import pl.crazymc.core.builders.ItemBuilder;
import pl.crazymc.core.managers.TopManager;
import pl.crazymc.core.managers.UserManager;
import pl.crazymc.core.objects.User;
import pl.crazymc.core.utils.GlassPane;
import pl.crazymc.core.utils.Util;

public class TopGui {

    private static final TopManager topManager = new TopManager();

    public static void open(final Player player) {
        final InventoryBuilder inv = new InventoryBuilder("&8» &aTopki&6:", 45);
        final User user = UserManager.getUser(player);
        inv.setItem(10, topManager.getTopStone());
        inv.setItem(11, topManager.getTopGodApples());
        inv.setItem(12, topManager.getTopTime());
//        inv.setItem(13, topManager.getTopKills());
//        inv.setItem(14, topManager.getTopDeaths());
        inv.setItem(15, topManager.getTopWalkedDistance());
        inv.setItem(16, topManager.getTopCaseOpened());
        inv.setItem(31, new ItemBuilder(Material.BOOK).setTitle("&6&l* &a&lTWOJE STATYSTYKI &6&l*")
                .addLore(
                        "",
                        " &f&l* &7Nick: &e&l" + player.getName(),
                        "",
                        " &f* &7Wykopanego kamienia: &7" + user.getBreakStone(),
                        " &f* &7Zjedzonych koxow: &6" + user.getGodApplesEat(),
                        " &f* &7Spedzonego czasu: &5" + user.getPlayedTime(),
//                        " &f* &7Zabojstwa: &c" + user.getKills(),
//                        " &f* &7Smierci: &4" + user.getDeaths(),
                        " &f* &7Przebytego dystansu: &2" + Util.distanceToString(user.getWalkedDistance()),
                        " &f* &7Otworzonych premiumcase: &9" + user.getCaseOpened(),
                        "").build());
        inv.open(player, GlassPane.LIGHT_BLUE);
    }
}
