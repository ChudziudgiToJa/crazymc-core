package pl.crazymc.core.managers;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class AntiLegsManager {
    public static final HashMap<UUID, Long> antiLegsPlayer = new HashMap<>();


    public static boolean canBeTeleported(final Player player) {
        if (antiLegsPlayer.get(player.getUniqueId()) > System.currentTimeMillis()) {
            return true;
        }
        antiLegsPlayer.remove(player.getUniqueId());
        return false;
    }

    public static HashMap<UUID, Long> getAntiLegsPlayer() {
        return antiLegsPlayer;
    }
}
