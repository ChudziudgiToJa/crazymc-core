package pl.crazymc.core.managers;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import pl.crazymc.core.objects.User;
import pl.crazymc.core.builders.ItemBuilder;
import pl.crazymc.core.utils.Util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TopManager {

    public ItemStack getTopCoins() {
        final List<User> sortedUsers = UserManager.objects.values().stream().sorted(Comparator.comparing(User::getCoins).reversed()).limit(10).collect(Collectors.toList());
        final ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            if (sortedUsers.size() >= i) {
                final User user = sortedUsers.get(i - 1);
                list.add("&8" + i + ". &f" + user.getName() + " &8(&e" + user.coins / 100.0 + " &7zl&8)");
            } else list.add("&8" + i + ". &7Brak");
        }
        return new ItemBuilder(Material.GOLD_INGOT).setTitle("&e&lTOPKA PIENIEDZY").addLore(list).build();
    }
    public ItemStack getTopStone() {
        final List<User> sortedUsers = UserManager.objects.values().stream().sorted(Comparator.comparing(User::getBreakStone).reversed()).limit(10).collect(Collectors.toList());
        final ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            if (sortedUsers.size() >= i) {
                final User user = sortedUsers.get(i - 1);
                list.add("&8" + i + ". &f" + user.getName() + " &8(&7" + user.breakStone + " &7wykopanego kamienia&8)");
            } else list.add("&8" + i + ". &7Brak");
        }
        return new ItemBuilder(Material.DIAMOND_PICKAXE).setTitle("&7&lTOPKA WYKOPANEGO KAMIENIA").addLore(list).build();
    }
//    public ItemStack getTopKills() {
//        final List<User> sortedUsers = UserManager.objects.values().stream().sorted(Comparator.comparing(User::getKills).reversed()).limit(10).collect(Collectors.toList());
//        final ArrayList<String> list = new ArrayList<>();
//        for (int i = 1; i < 11; i++) {
//            if (sortedUsers.size() >= i) {
//                final User user = sortedUsers.get(i - 1);
//                list.add("&8" + i + ". &f" + user.getName() + " &8(&c" + user.getKills() + " &7zabojstw&8)");
//            } else list.add("&8" + i + ". &7Brak");
//        }
//        return new ItemBuilder(Material.DIAMOND_SWORD).setTitle("&c&lTOPKA ZABOJSTW").addLore(list).build();
//    }
    public ItemStack getTopGodApples() {
        final List<User> sortedUsers = UserManager.objects.values().stream().sorted(Comparator.comparing(User::getGodApplesEat).reversed()).limit(10).collect(Collectors.toList());
        final ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            if (sortedUsers.size() >= i) {
                final User user = sortedUsers.get(i - 1);
                list.add("&8" + i + ". &f" + user.getName() + " &8(&6" + user.godApplesEat + " &7zjedzonych koxow&8)");
            } else list.add("&8" + i + ". &7Brak");
        }
        return new ItemBuilder(Material.GOLDEN_APPLE,(short)1).setTitle("&6&lTOPKA GLODOMOROW").addLore(list).build();
    }
    public ItemStack getTopTime() {
        final List<User> sortedUsers = UserManager.objects.values().stream().sorted(Comparator.comparing(User::getTime).reversed()).limit(10).collect(Collectors.toList());
        final ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            if (sortedUsers.size() >= i) {
                final User user = sortedUsers.get(i - 1);
                list.add("&8" + i + ". &f" + user.getName() + " &8(&5" + user.getPlayedTime()+ " &7spedzonego czasu&8)");
            } else list.add("&8" + i + ". &7Brak");
        }
        return new ItemBuilder(Material.CLOCK).setTitle("&5&lTOPKA SPEDZONEGO CZASU").addLore(list).build();
    }
//    public ItemStack getTopDeaths() {
//        final List<User> sortedUsers = UserManager.objects.values().stream().sorted(Comparator.comparing(User::getDeaths).reversed()).limit(10).collect(Collectors.toList());
//        final ArrayList<String> list = new ArrayList<>();
//        for (int i = 1; i < 11; i++) {
//            if (sortedUsers.size() >= i) {
//                final User user = sortedUsers.get(i - 1);
//                list.add("&8" + i + ". &f" + user.getName() + " &8(&4" + user.getDeaths() + " &7smierci&8)");
//            } else list.add("&8" + i + ". &7Brak");
//        }
//        return new ItemBuilder(Material.BONE).setTitle("&4&lTOPKA SMIERCI").addLore(list).build();
//    }
    public ItemStack getTopCaseOpened() {
        final List<User> sortedUsers = UserManager.objects.values().stream().sorted(Comparator.comparing(User::getCaseOpened).reversed()).limit(10).collect(Collectors.toList());
        final ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            if (sortedUsers.size() >= i) {
                final User user = sortedUsers.get(i - 1);
                list.add("&8" + i + ". &f" + user.getName() + " &8(&9" + user.getCaseOpened() + " &7otworzonych premiumcase&8)");
            } else list.add("&8" + i + ". &7Brak");
        }
        return new ItemBuilder(Material.CHEST).setTitle("&9&lTOPKA OTWORZONYCH PREMIUMCASE").addLore(list).build();
    }
    public ItemStack getTopWalkedDistance() {
        final List<User> sortedUsers = UserManager.objects.values().stream().sorted(Comparator.comparing(User::getWalkedDistance).reversed()).limit(10).collect(Collectors.toList());
        final ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            if (sortedUsers.size() >= i) {
                final User user = sortedUsers.get(i - 1);
                list.add("&8" + i + ". &f" + user.getName() + " &8(&2" + Util.distanceToString(user.getWalkedDistance()) + " &7przebytego dystansu&8)");
            } else list.add("&8" + i + ". &7Brak");
        }
        return new ItemBuilder(Material.IRON_BOOTS).setTitle("&2&lTOPKA PRZEBYTEGO DYSTANSU").addLore(list).build();
    }
}
