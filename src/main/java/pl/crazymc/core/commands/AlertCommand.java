package pl.crazymc.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.crazymc.core.commands.api.Command;
import pl.crazymc.core.commands.api.interfaces.CommandInfo;
import pl.crazymc.core.utils.Util;


@CommandInfo(name = "AdminChat",
        perm = "core.chat.alert"
)
public class AlertCommand extends Command {
    @Override
    public void execute(CommandSender sender, String[] args) {
        final StringBuilder message = new StringBuilder();
        for (int i = 1; i < args.length; ++i) {
            message.append(args[i]).append(" ");
        }
        switch (args[0]) {
            case "chat":
                Bukkit.broadcastMessage(Util.fixColor("&8[&4UWAGA&8] &6" + message));
                break;
            case "title":
                for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                    Util.sendTitle(onlinePlayer, "&6" + message.toString().replace("{PLAYER}", onlinePlayer.getName()), "", 20, 40, 20);
                }
                break;
            case "subtitle":
                for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                    Util.sendTitle(onlinePlayer, "&8[&4ALERT&8]", "&6" + message.toString().replace("{PLAYER}", onlinePlayer.getName()), 20, 40, 20);
                }
                break;
            case "actionbar":
                for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                    Util.sendActionbar(onlinePlayer, "&6" + message.toString().replace("{PLAYER}", onlinePlayer.getName()));
                }
                break;
            default:
                sendUsage(sender);
        }
    }
}
