package pl.crazymc.core.managers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class VanishManager {
    private static final List<Player> vanishPlayers = new ArrayList<>();

    public static List<Player> getVanishPlayers() {
        return vanishPlayers;
    }

    public static boolean isVanished(final Player player) {
        return vanishPlayers.contains(player);
    }
    public static void toggleVanish(final Player player, final boolean set) {
        if (set) {
            vanishPlayers.add(player);
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                if (!onlinePlayer.hasPermission("core.vanish.see")) {
                    onlinePlayer.hidePlayer(player);
                }
            }
        } else {
            vanishPlayers.remove(player);
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                onlinePlayer.showPlayer(player);
            }

        }
    }

    public static void toggleVanish(final Player player) {
        toggleVanish(player,!isVanished(player));
    }
}
