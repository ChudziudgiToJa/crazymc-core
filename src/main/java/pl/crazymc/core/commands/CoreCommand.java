package pl.crazymc.core.commands;

import org.bukkit.command.CommandSender;
import pl.crazymc.core.CorePlugin;
import pl.crazymc.core.commands.api.Command;
import pl.crazymc.core.commands.api.interfaces.CommandInfo;
import pl.crazymc.core.managers.ConfigCommandsManager;
import pl.crazymc.core.managers.DropManager;
import pl.crazymc.core.managers.ServiceManager;
import pl.crazymc.core.utils.Util;

@CommandInfo(name = "reload",
        perm = "core.reload"
)
public class CoreCommand extends Command {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args[0].equals("reload")) {
            executeReload(sender);
        }
    }

    private void executeReload(final CommandSender sender) {
        CorePlugin.getInstance().reloadConfig();
        DropManager.load();
        ServiceManager.load();
        ConfigCommandsManager.load();
        Util.succes(sender, "Przeladowano!");
    }
}
