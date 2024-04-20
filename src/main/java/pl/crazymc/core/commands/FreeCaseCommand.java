package pl.crazymc.core.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.crazymc.core.commands.api.Command;
import pl.crazymc.core.commands.api.interfaces.CommandInfo;
import pl.crazymc.core.utils.DataUtil;
import pl.crazymc.core.utils.Util;


@CommandInfo(name = "freecase",
        perm = "core.case.free"
)
public class FreeCaseCommand extends Command {

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        if (CaseCommand.lastCaseGive > System.currentTimeMillis()) {
            Util.msg(player, "&cKtos juz rozdal dzisiaj premiumcase! (" + DataUtil.secondsToString((CaseCommand.lastCaseGive - System.currentTimeMillis())) + ")");
        } else Util.msg(player,"&aNikt nie rozdal jeszcze case! Mozesz je teraz rozdac! :D");
    }
}
