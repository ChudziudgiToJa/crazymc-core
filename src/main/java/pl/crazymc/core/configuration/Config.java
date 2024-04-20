package pl.crazymc.core.configuration;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import pl.crazymc.core.CorePlugin;

import java.util.List;

public class Config {
    private static final FileConfiguration config = CorePlugin.getInstance().getConfig();
    public static final String joinTitle = config.getString("joinTitle");
    public static final String joinSubtitle = config.getString("joinSubtitle");
    public static final List<String> joinMessage = config.getStringList("joinMessage");
    public static final List<String> fightMessage = config.getStringList("fightMessage");
    public static final List<String> autoMessage = config.getStringList("autoMessages");
    public static long turboDrop = 0L;
    public static long turboCase = 0L;

    static final String[] split = config.getString("checkLocation").split(":");
    public static Location checkLocation = new Location(
            Bukkit.getWorld(split[0]),
            Double.parseDouble(split[1]),
            Double.parseDouble(split[2]),
            Double.parseDouble(split[3])).add(0.5,0.0,0.5);

    public static String playerAllowedCommands = config.getString("playerAllowedCommands");
    public static List<String> checkBlockedCommands = config.getStringList("checkBlockedCommands");
    public static List<String> checkCommandUsage = config.getStringList("checkCommandUsage");
    public static List<String> checkStartBroadcast = config.getStringList("checkStartBroadcast");
    public static String playerCheckStartMessage = config.getString("playerCheckStartMessage");
    public static String checkClearBroadcast = config.getString("checkClearBroadcast");
    public static String checkCheaterBroadcast = config.getString("checkCheaterBroadcast");
    public static String checkCheaterCommand = config.getString("checkCheaterCommand");
    public static String checkLogoutCommand = config.getString("checkLogoutCommand");
    public static String titleCheckStart = config.getString("titleCheckStart");
    public static String titleCheckClear = config.getString("titleCheckClear");
    public static String titleBlockedCommand = config.getString("titleBlockedCommand");
    public static String subTitleCheckStart = config.getString("subTitleCheckStart");
    public static String subTitleCheckClear = config.getString("subTitleCheckClear");
    public static String subTitleBlockedCommand = config.getString("subTitleBlockedCommand");

    public static int spawnRegion = config.getInt("spawnRegion");
    public static int pvpRegion = config.getInt("pvpRegion");

    public static boolean isCaseEnabled = config.getBoolean("isCaseEnabled");

}
