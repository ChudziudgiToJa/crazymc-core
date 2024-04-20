package pl.crazymc.core.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.crazymc.core.commands.api.Command;
import pl.crazymc.core.commands.api.interfaces.CommandInfo;
import pl.crazymc.core.inventories.EffectsGui;

@CommandInfo(name = "AdminChat",
        player = true
)
public class EffectsCommand extends Command {
    @Override
    public void execute(CommandSender sender, String[] args) {
        EffectsGui.open((Player) sender);
    }
}
