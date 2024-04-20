package pl.crazymc.core.tasks;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import pl.crazymc.core.managers.VanishManager;
import pl.crazymc.core.utils.Util;

public class VanishTask extends BukkitRunnable {
    @Override
    public void run() {
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (VanishManager.isVanished(onlinePlayer)) {
                Util.sendActionbar(onlinePlayer,"&aJestes niewidoczny dla graczy!");
            }
        }
    }
}
