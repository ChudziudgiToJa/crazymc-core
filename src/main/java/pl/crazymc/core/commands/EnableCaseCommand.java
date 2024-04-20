package pl.crazymc.core.commands;

import org.bukkit.command.CommandSender;
import pl.crazymc.core.CorePlugin;
import pl.crazymc.core.commands.api.Command;
import pl.crazymc.core.commands.api.interfaces.CommandInfo;
import pl.crazymc.core.configuration.Config;
import pl.crazymc.core.utils.Util;

@CommandInfo(name = "case",
        perm = "core.case.command"
)
public class EnableCaseCommand extends Command {

    @Override
    public void execute(CommandSender sender, String[] args) {
        Config.isCaseEnabled = Boolean.parseBoolean(args[0]);
        CorePlugin.getInstance().getConfig().set("isCaseEnabled", Boolean.parseBoolean(args[0]));
        CorePlugin.getInstance().saveConfig();
        Util.warning(sender, "PremiumCase zostaly: &" + (Config.isCaseEnabled ? "awlaczone" : "cwylaczone"));
    }
}
