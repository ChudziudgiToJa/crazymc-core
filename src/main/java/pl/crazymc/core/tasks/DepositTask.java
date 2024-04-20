package pl.crazymc.core.tasks;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import pl.crazymc.core.configuration.DepositConfig;
import pl.crazymc.core.managers.UserManager;
import pl.crazymc.core.objects.User;
import pl.crazymc.core.utils.Util;

public class DepositTask extends BukkitRunnable {
    @Override
    public void run() {
        for (final Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            final User user = UserManager.getUser(onlinePlayer);
            if (Util.getAmount(onlinePlayer, Material.ENCHANTED_GOLDEN_APPLE) > DepositConfig.godApplesLimit) {
                final int amount = Util.remove(onlinePlayer, Material.GOLDEN_APPLE, (short) 1, DepositConfig.godApplesLimit);
                user.godApples += amount;
                Util.msg(onlinePlayer, DepositConfig.chatGodApplesTake.replace("{LIMIT}", String.valueOf(DepositConfig.godApplesLimit)).replace("{AMOUNT}", String.valueOf(amount)));
            } else if (Util.getAmount(onlinePlayer, Material.GOLDEN_APPLE) > DepositConfig.goldenApplesLimit) {
                final int amount = Util.remove(onlinePlayer, Material.GOLDEN_APPLE, (short) 0, DepositConfig.goldenApplesLimit);
                user.goldenApples += amount;
                Util.msg(onlinePlayer, DepositConfig.chatGoldenApplesTake.replace("{LIMIT}", String.valueOf(DepositConfig.goldenApplesLimit)).replace("{AMOUNT}", String.valueOf(amount)));
            } else if (Util.getAmount(onlinePlayer, Material.ENDER_PEARL) > DepositConfig.enderPearlsLimit) {
                final int amount = Util.remove(onlinePlayer, Material.ENDER_PEARL, (short) 0, DepositConfig.enderPearlsLimit);
                user.enderPearls += amount;
                Util.msg(onlinePlayer, DepositConfig.chatEnderPearlsTake.replace("{LIMIT}", String.valueOf(DepositConfig.enderPearlsLimit)).replace("{AMOUNT}", String.valueOf(amount)));
            }
        }
    }
}
