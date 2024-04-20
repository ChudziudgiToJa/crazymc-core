package pl.crazymc.core.objects;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import pl.crazymc.core.managers.DropManager;
import pl.crazymc.core.utils.DataUtil;
import pl.crazymc.core.utils.ItemUtil;
import pl.crazymc.core.utils.Util;

import java.util.HashSet;
import java.util.Set;

@DatabaseTable(tableName = "users")
public class User {
    public final Set<Drop> enabledDrops = new HashSet<>();
    public boolean dropCobblestone;
    @DatabaseField(id = true)
    public String name;
    @DatabaseField
    public long turboDrop;
    @DatabaseField
    public String achievements;
    @DatabaseField
    public long time;
    @DatabaseField
    public long join;
    @DatabaseField
    public int godApplesEat;
    @DatabaseField
    public int breakStone;
    @DatabaseField(dataType = DataType.LONG_STRING)
    public String enderChest;
    @DatabaseField
    public int coins;
    @DatabaseField
    public boolean caseMessages;
    @DatabaseField
    public int godApples;
    @DatabaseField
    public int goldenApples;
    @DatabaseField
    public int enderPearls;
    @DatabaseField
    public int caseOpened;
    @DatabaseField
    public int walkedDistance;

    public User() {
    }


    public User(String name) {
        this.name = name;
        enabledDrops.addAll(DropManager.getDrops());
        achievements = "0:0:0:0";
        caseMessages = true;
    }

    public int getCaseOpened() {
        return caseOpened;
    }

    public int getWalkedDistance() {
        return walkedDistance;
    }

    public int getCoins() {
        return coins;
    }

    public String getName() {
        return name;
    }

    public Player getPlayer() {
        return Bukkit.getPlayerExact(name);
    }


    public boolean isEnabled(Drop drop) {
        return enabledDrops.contains(drop);
    }

    public void changeStatus(final Drop p) {
        if (!enabledDrops.contains(p)) {
            enabledDrops.add(p);
        } else enabledDrops.remove(p);
    }

    public void setStatus(final Drop p, final boolean b) {
        if (b) enabledDrops.add(p);
        else enabledDrops.remove(p);
    }

    public final boolean isReedemd(int n, int n2) {
        final String[] string = StringUtils.split(achievements, ":");
        return Integer.parseInt(string[n]) >= n2;
    }

    public void reedemPrize(Achievement achievement, int number, int n2) {
        final String[] collection = StringUtils.split(achievements, ":");
        if (collection != null) {
            final int amount = Integer.parseInt(collection[number]);
            if (amount < achievement.getPrizes().length) {
                if (!isReedemd(achievement.getNumber(), n2)) {
                    if (achievement.getPrizes()[amount].isCompleted()) {
                        collection[number] = String.valueOf((amount + 1));
                        achievements = StringUtils.join(collection, ":");
                        Util.sendTitle(getPlayer(), "&cOsiagniecia", "&aPomyslnie odebrano nagrode!", 20, 60, 20);
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "case " + name + " " + achievement.getPrizes()[amount].getPcase());
                        Util.broadcast("&f&l» &7Gracz &a" + name + " &7odebral osiagniecie: " + achievement.getPrizes()[amount].getName() + " &7Sprawdz tez swoje pod&8: &2/osiagniecia");
                    } else getPlayer().sendMessage(Util.fixColor("&8» &cNie spelniles wymagan aby odebrac nagrode!"));
                } else getPlayer().sendMessage(Util.fixColor("&8» &cOdebrales juz nagrode za to osiagniecie!"));
            } else getPlayer().sendMessage(Util.fixColor("&8» &cOdebrales juz wszystkie nagrody z tej kategorii!"));
            getPlayer().closeInventory();
        }
    }

    public final long getTime() {
        return ((join != 0L) ? (System.currentTimeMillis() - join) : 0L) + time;
    }

    public final String getPlayedTime() {
        return DataUtil.secondsToString(getTime());
    }

    public final void join() {
        join = System.currentTimeMillis();
    }

    public final void quit() {
        if (join != 0L) time += System.currentTimeMillis() - join;
        join = 0L;
    }

    public int getGodApplesEat() {
        return godApplesEat;
    }

    public int getBreakStone() {
        return breakStone;
    }

//    public final int getKills() {
//        final String name = this.name;
//        final net.dzikoysk.funnyguilds.basic.user.User value = net.dzikoysk.funnyguilds.basic.user.User.get(name);
//        final Rank rank = value.getRank();
//        return rank.getKills();
//    }

//    public final int getDeaths() {
//        final String name = this.name;
//        final net.dzikoysk.funnyguilds.basic.user.User value = net.dzikoysk.funnyguilds.basic.user.User.get(name);
//        final Rank rank = value.getRank();
//        return rank.getDeaths();
//    }

    public ItemStack[] getEnderChest() {
        return ItemUtil.itemStackFromBase(enderChest);
    }

    public void setEnderChest(ItemStack[] enderChest) {
        this.enderChest = ItemUtil.itemStackToBase(enderChest);

    }
}

