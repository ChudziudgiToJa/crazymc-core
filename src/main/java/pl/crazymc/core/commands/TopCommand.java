package pl.crazymc.core.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.crazymc.core.commands.api.Command;
import pl.crazymc.core.commands.api.interfaces.CommandInfo;
import pl.crazymc.core.inventories.TopGui;

@CommandInfo(
        name = "topki",
        player = true
)
public class TopCommand extends Command {

    @Override
    public void execute(CommandSender sender, String[] args) {
        TopGui.open((Player) sender);
    }
}
