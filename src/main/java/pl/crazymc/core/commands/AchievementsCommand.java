package pl.crazymc.core.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.crazymc.core.commands.api.Command;
import pl.crazymc.core.commands.api.interfaces.CommandInfo;
import pl.crazymc.core.inventories.AchievementGui;

@CommandInfo(
        name = "Osiągnięcia",
        player = true
)

public class AchievementsCommand extends Command {

    @Override
    public void execute(CommandSender sender, String... args) {
        AchievementGui.open((Player) sender);
    }
}
