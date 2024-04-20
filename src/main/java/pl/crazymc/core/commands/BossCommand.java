package pl.crazymc.core.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.crazymc.core.commands.api.Command;
import pl.crazymc.core.commands.api.interfaces.CommandInfo;
import pl.crazymc.core.objects.Boss;

@CommandInfo(name = "AdminChat",
        perm = "core.boss")

public class BossCommand extends Command {
    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        new Boss(player.getLocation());
    }
}
