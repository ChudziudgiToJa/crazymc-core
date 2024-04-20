package pl.crazymc.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.crazymc.core.commands.api.Command;
import pl.crazymc.core.commands.api.interfaces.CommandInfo;
import pl.crazymc.core.configuration.Config;
import pl.crazymc.core.managers.UserManager;
import pl.crazymc.core.objects.User;
import pl.crazymc.core.utils.DataUtil;
import pl.crazymc.core.utils.Util;

@CommandInfo(
        name = "turbodrop",
        perm = "core.cmd.turbodrop"
)
public class TurboDropCommand extends Command {

    @Override
    public void execute(CommandSender sender, String[] args) {
        final long time = System.currentTimeMillis() + DataUtil.parseString(args[1]);
        if (args[0].equalsIgnoreCase("all")) {
            Bukkit.broadcastMessage(Util.fixColor("&aTURBODROP &7zostal aktywowany do: &9" + DataUtil.getDate(time)));
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                Util.sendTitle(onlinePlayer,"&aTurboDrop","&7Zostal aktywowany na: &3" + args[1],40,60,40);
            }
            Config.turboDrop = time;
        } else {
            final User user = UserManager.getUserOrNull(args[0]);
            if (user != null) {
                user.turboDrop = time;
                Util.msg(sender, "&aTURBODROP &7dla: &9" + user.getName() + " zostal aktywowany do: &9" + DataUtil.getDate(time));
            } else Util.error(sender, "Nie odnaleziono podanego gracza w bazie danych.");
        }
    }
}
