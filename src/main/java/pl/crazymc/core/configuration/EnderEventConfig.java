package pl.crazymc.core.configuration;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class EnderEventConfig {
    public static final List<ItemStack> endermanDrops = Arrays.asList(CraftingsConfig.getCase(1),
            new ItemStack(Material.GOLD_INGOT, 5),
            new ItemStack(Material.GOLD_INGOT, 5),
            new ItemStack(Material.GOLD_INGOT, 5),
            new ItemStack(Material.ENDER_PEARL, 1),
            new ItemStack(Material.ENDER_PEARL, 1),
            new ItemStack(Material.TNT),
            new ItemStack(Material.GOLD_NUGGET),
            new ItemStack(Material.GOLD_NUGGET),
            new ItemStack(Material.GOLD_NUGGET));

    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
    private static final LocalTime protectionStartTime = LocalTime.parse("16:00", timeFormatter);
    private static final LocalTime protectionEndTime = LocalTime.parse("20:00", timeFormatter);
    private static final boolean protectionMode = protectionStartTime.isAfter(protectionEndTime);

    public static boolean isEnabled() {
        LocalTime now = LocalDateTime.now().toLocalTime();

        boolean afterStart = now.isAfter(protectionStartTime);
        boolean beforeEnd = now.isBefore(protectionEndTime);

        return protectionMode ? afterStart || beforeEnd : afterStart && beforeEnd;
    }
}
