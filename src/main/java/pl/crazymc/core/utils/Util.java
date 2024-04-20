package pl.crazymc.core.utils;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Util {

    public static String fixColor(final String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static List<String> fixColor(final List<String> strings) {
        for (int i = 0; i < strings.size(); i++) {
            strings.set(i, fixColor(strings.get(i)));
        }
        return strings;
    }

    public static void sendActionbar(Player player, String message) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(fixColor(message)));
    }

    public static void sendTitle(Player player, String title, String subTitle, int fadeInTime, int stayTime, int fadeOutTime) {
        player.sendTitle(fixColor(title), fixColor(subTitle), fadeInTime, stayTime, fadeOutTime);
    }

    public static void giveItems(final Player player, final ItemStack... items) {
        final HashMap<Integer, ItemStack> notStored = player.getInventory().addItem(items);
        for (final Map.Entry<Integer, ItemStack> e : notStored.entrySet()) {
            player.getWorld().dropItemNaturally(player.getLocation(), e.getValue());
        }
    }

    public static ItemStack getItemStackFromString(final String itemstack) {
        final String[] splits = itemstack.split(":");
        final String type = splits[0];
        final String data = (splits.length == 2) ? splits[1] : null;
        Material material = Material.getMaterial(type);
        if (material == null) {
            return new ItemStack(Material.AIR, 1);
        }
        if (data == null) {
            return new ItemStack(material, 1);
        }
        return new ItemStack(material, 1, (short) Integer.parseInt(data));
    }

    public static void msg(final CommandSender commandSender, final String string) {
        commandSender.sendMessage(fixColor(string));
    }

    public static void succes(final CommandSender commandSender, final String message) {
        msg(commandSender, "&2&l» &7" + message);
    }

    public static void info(final CommandSender commandSender, final String message) {
        msg(commandSender, "&8» &7" + message);
    }

    public static void warning(final CommandSender commandSender, final String message) {
        msg(commandSender, "&4&l» &7" + message);
    }

    public static void error(final CommandSender commandSender, final String error) {
        msg(commandSender, "&4&l» &c" + error);
    }

    public static void broadcast(final String message) {
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            msg(onlinePlayer, message);
        }
    }

    public static int getAmount(final Player player, final Material material) {
        int amount = 0;
        for (final ItemStack itemStack : player.getInventory().getContents()) {
            if (itemStack != null && itemStack.getType().equals(material)) {
                amount += itemStack.getAmount();
            }
        }
        return amount;
    }

    public static int remove(final Player player, final Material material, final short durability, final int limit) {
        final PlayerInventory inv = player.getInventory();
        int removed = 0;
        for (final ItemStack slot : inv.getContents()) {
            if (slot != null && slot.getType() == material && slot.getDurability() == durability) {
                inv.remove(slot);
                removed += slot.getAmount();
            }
        }
        inv.addItem(new ItemStack(material, limit, durability));
        player.updateInventory();
        return removed - limit;
    }

    public static boolean isIn(Location location, int minX, int maxX, int minZ, int maxZ) {
        return location.getWorld() == Bukkit.getWorlds().get(0) && (location.getX() < maxX && location.getX() > minX && location.getZ() < maxZ && location.getZ() > minZ);
    }

    public static double fastDistance(final Location location1, final Location location) {
        double x = location1.getX() - location.getX();
        double z = location1.getZ() - location.getZ();
        return Math.hypot(x, z);
    }

    public static String distanceToString(final int i) {
        return (i < 1000) ? (i + " m") : (i / 1000.0 + " km");
    }

}
