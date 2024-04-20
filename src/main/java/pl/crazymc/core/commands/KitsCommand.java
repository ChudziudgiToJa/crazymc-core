package pl.crazymc.core.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.crazymc.core.commands.api.Command;
import pl.crazymc.core.commands.api.interfaces.CommandInfo;
import pl.crazymc.core.inventories.KitsGui;

@CommandInfo(name = "kit", player = true, aliases = {"kity"})

public class KitsCommand extends Command {
    @Override
    public void execute(CommandSender sender, String[] args) {
        KitsGui.open((Player)sender);
    }
}
