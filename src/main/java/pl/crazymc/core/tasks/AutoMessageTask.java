package pl.crazymc.core.tasks;

import org.bukkit.scheduler.BukkitRunnable;
import pl.crazymc.core.configuration.Config;
import pl.crazymc.core.utils.Util;

public class AutoMessageTask extends BukkitRunnable {
    private int i = 0;

    @Override
    public void run() {
        if (Config.autoMessage.size() != 0) {
            Util.broadcast(Config.autoMessage.get(i++));
            if (i >= Config.autoMessage.size()) i = 0;
        }
    }
}
