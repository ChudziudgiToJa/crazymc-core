package pl.crazymc.core.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.crazymc.core.commands.api.Command;
import pl.crazymc.core.commands.api.interfaces.CommandInfo;
import pl.crazymc.core.inventories.DepositGui;

@CommandInfo(name = "schowek",
        player = true
)
public class DepositCommand extends Command {

    @Override
    public void execute(CommandSender sender, String[] args) {
        DepositGui.open((Player)sender);
    }
}
