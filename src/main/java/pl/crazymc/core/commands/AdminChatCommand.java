package pl.crazymc.core.commands;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.crazymc.core.commands.api.Command;
import pl.crazymc.core.commands.api.interfaces.CommandInfo;
import pl.crazymc.core.utils.Util;

@CommandInfo(name = "AdminChat",
        perm = "core.chat.admin",
        aliases = { "ac" }
)
public class AdminChatCommand extends Command {
    @Override
    public void execute(CommandSender sender, String[] args) {
        final String message = StringUtils.join(args, " ");
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (onlinePlayer.hasPermission("core.cmd.adminchat")) {
                Util.msg(onlinePlayer,"&4&l[AdminCzat] &c" + sender.getName() + ": &7" + message);
            }
        }
    }
}
