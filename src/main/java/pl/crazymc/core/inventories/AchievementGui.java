package pl.crazymc.core.inventories;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import pl.crazymc.core.managers.UserManager;
import pl.crazymc.core.objects.Achievement;
import pl.crazymc.core.objects.User;
import pl.crazymc.core.utils.DataUtil;
import pl.crazymc.core.utils.GlassPane;
import pl.crazymc.core.builders.InventoryBuilder;
import pl.crazymc.core.builders.ItemBuilder;

public class AchievementGui {
    private static final ItemStack backItem = new ItemBuilder(Material.RED_DYE, 1).setTitle("&cWstecz").build();

    private static final ItemStack killsItem = new ItemBuilder(Material.DIAMOND_SWORD).setTitle("&cZabojstwa").build();
    private static final ItemStack godApplesItem = new ItemBuilder(Material.ENCHANTED_GOLDEN_APPLE, 1).setTitle("&eZjedzone koxy").build();
    private static final ItemStack timeItem = new ItemBuilder(Material.CLOCK).setTitle("&dSpedzony czas").build();
    private static final ItemStack mineItem = new ItemBuilder(Material.DIAMOND_PICKAXE).setTitle("&7Wykopany kamien").build();

    private static Achievement killsAchievement, godApplesAchievement, timeAchievement, mineAchievement;

    public static void open(final Player player) {
        final User user = UserManager.getUser(player);
        final InventoryBuilder inv = new InventoryBuilder("&8» &aOsiagniecia&6:", 27);

//        killsAchievement = new Achievement(0, new Achievement.Prize[]{
//                new Achievement.Prize("&c&lZabij 10 graczy", user.getKills(), 2, 10, new ItemBuilder(Material.DIAMOND_SWORD)),
//                new Achievement.Prize("&c&lZabij 20 graczy", user.getKills(), 5, 20, new ItemBuilder(Material.DIAMOND_SWORD)),
//                new Achievement.Prize("&c&lZabij 50 graczy", user.getKills(), 10, 50, new ItemBuilder(Material.DIAMOND_SWORD)),
//                new Achievement.Prize("&c&lZabij 100 graczy", user.getKills(), 16, 100, new ItemBuilder(Material.DIAMOND_SWORD))
//        });

        godApplesAchievement = new Achievement(1, new Achievement.Prize[]{
                new Achievement.Prize("&e&lZjedz 10 koxow", user.godApplesEat, 2, 10, new ItemBuilder(Material.GOLDEN_APPLE, 1, (short) 1)),
                new Achievement.Prize("&e&lZjedz 100 koxow", user.godApplesEat, 5, 100, new ItemBuilder(Material.ENCHANTED_GOLDEN_APPLE, 1)),
                new Achievement.Prize("&e&lZjedz 1000 koxow", user.godApplesEat, 10, 1000, new ItemBuilder(Material.GOLDEN_APPLE, 1, (short) 1)),
                new Achievement.Prize("&e&lZjedz 3000 koxow", user.godApplesEat, 16, 3000, new ItemBuilder(Material.ENCHANTED_GOLDEN_APPLE, 1))
        });

        timeAchievement = new Achievement(2, new Achievement.Prize[]{
                new Achievement.Prize("&5&lSpedz na serwerze 1 godz", (int) user.getTime(), 2, DataUtil.Time.HOUR.getTime(1), new ItemBuilder(Material.CLOCK)),
                new Achievement.Prize("&5&lSpedz na serwerze 12 godz", (int) user.getTime(), 5, DataUtil.Time.HOUR.getTime(12), new ItemBuilder(Material.CLOCK)),
                new Achievement.Prize("&5&lSpedz na serwerze 1 dzien", (int) user.getTime(), 10, DataUtil.Time.DAY.getTime(1), new ItemBuilder(Material.CLOCK)),
                new Achievement.Prize("&5&lSpedz na serwerze 7 dni", (int) user.getTime(), 16, DataUtil.Time.DAY.getTime(7), new ItemBuilder(Material.CLOCK))
        });

        mineAchievement = new Achievement(3, new Achievement.Prize[]{
                new Achievement.Prize("&7&lWykop 1000 kamienia", user.breakStone, 2, 1000, new ItemBuilder(Material.DIAMOND_PICKAXE)),
                new Achievement.Prize("&7&lWykop 10.000 kamienia", user.breakStone, 5, 10000, new ItemBuilder(Material.DIAMOND_PICKAXE)),
                new Achievement.Prize("&7&lWykop 50.000 kamienia", user.breakStone, 10, 50000, new ItemBuilder(Material.DIAMOND_PICKAXE)),
                new Achievement.Prize("&7&lWykop 100.000 kamienia", user.breakStone, 16, 100000, new ItemBuilder(Material.DIAMOND_PICKAXE))
        });

        inv.setItem(10, killsItem, event -> openAchievement(player, killsAchievement));
        inv.setItem(12, godApplesItem, event -> openAchievement(player, godApplesAchievement));
        inv.setItem(14, timeItem, event -> openAchievement(player, timeAchievement));
        inv.setItem(16, mineItem, event -> openAchievement(player, mineAchievement));

        inv.open(player, GlassPane.LIGHT_BLUE);
    }

    private static void openAchievement(final Player player, final Achievement achievement) {
        final InventoryBuilder inv = new InventoryBuilder("&8» &aOsiagniecia&6:", 27);
        final User user = UserManager.getUser(player);
        final ItemStack statsItem = new ItemBuilder(Material.SKELETON_SKULL, 1).setOwner(player.getName()).setTitle("&3(Informacja)").addLore("&7Zabojstwa: &c" + user.name, "&7Zjedzone koxy: &e" + user.godApplesEat, "&7Spedzony czas: &5" + user.getPlayedTime(), "&7Wykopany kamien: " + user.breakStone).build();
        for (int i = 0; i < achievement.getPrizes().length; i++) {
            final int n2 = i + 1;
            final Achievement.Prize prize = achievement.getPrizes()[i];
            inv.setItem(i + 10, prize.getItemStack().setTitle(prize.getName()).addLore("&7Status&8: " + (user.isReedemd(achievement.getNumber(), n2) ? "&a✔" : prize.isCompleted() ? "&6Odbierz nagrode!" : "&c✖"), "&7Nagroda: &6PremiumCase x" + prize.getPcase()).build(), event -> user.reedemPrize(achievement, achievement.getNumber(), n2));
        }
        inv.setItem(15, statsItem);
        inv.setItem(26, backItem, event -> open(player));
        inv.open(player, GlassPane.LIGHT_BLUE);
    }
}
