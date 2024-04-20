package pl.crazymc.core.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.crazymc.core.commands.api.Command;
import pl.crazymc.core.commands.api.interfaces.CommandInfo;
import pl.crazymc.core.inventories.BlocksGui;


@CommandInfo(
        name = "bloki",
        player = true
)
public class BlocksCommand extends Command {
    @Override
    public void execute(CommandSender sender, String[] args) {
        BlocksGui.open((Player)sender);
    }
}
