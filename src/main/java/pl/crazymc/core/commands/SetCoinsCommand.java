package pl.crazymc.core.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.crazymc.core.commands.api.Command;
import pl.crazymc.core.commands.api.interfaces.CommandInfo;
import pl.crazymc.core.managers.UserManager;
import pl.crazymc.core.objects.User;
import pl.crazymc.core.utils.Util;

@CommandInfo(name = "setcoin",
        perm = "core.cmd.setcion"
)
public class SetCoinsCommand extends Command {

    @Override
    public void execute(CommandSender sender, String[] args) {
        final User user = UserManager.getUserOrNull(args[0]);
        if (user != null) {
            user.coins = Integer.parseInt(args[1]);
            Util.msg(sender,"&aUstawiono!");
        }
    }
}
