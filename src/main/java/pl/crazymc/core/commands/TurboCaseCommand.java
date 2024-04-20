package pl.crazymc.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.crazymc.core.commands.api.Command;
import pl.crazymc.core.commands.api.interfaces.CommandInfo;
import pl.crazymc.core.configuration.Config;
import pl.crazymc.core.utils.DataUtil;
import pl.crazymc.core.utils.Util;

@CommandInfo(
        name = "turbocase",
        perm = "core.cmd.turbocase"
)
public class TurboCaseCommand extends Command {

    @Override
    public void execute(CommandSender sender, String[] args) {
        final long time = System.currentTimeMillis() + DataUtil.parseString(args[0]);
        Bukkit.broadcastMessage(Util.fixColor("&aTURBOCASE &7zostaly aktywowane do: &9" + DataUtil.getDate(time)));
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            Util.sendTitle(onlinePlayer,"&aDrop PremiumCase","&7Zostal aktywowany na: &3" + args[0],40,60,40);
        }
        Config.turboCase = time;
    }
}
