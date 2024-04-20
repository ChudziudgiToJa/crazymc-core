package pl.crazymc.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import pl.crazymc.core.commands.api.Command;
import pl.crazymc.core.commands.api.interfaces.CommandInfo;
import pl.crazymc.core.managers.ServiceManager;
import pl.crazymc.core.objects.Service;
import pl.crazymc.core.utils.Util;

@CommandInfo(name = "service",
        perm = "core.cmd.serwice"
)
public class ServiceCommand extends Command {
    @Override
    public void execute(CommandSender sender, String[] args) {
        final Service service = ServiceManager.getService(args[1]);
        if (service != null) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), service.getCommand().replace("{NICK}", args[0]));
            for (final String s : service.getMessage()) {
                Util.broadcast(s.replace("{NICK}", args[0]));
            }
        } else Util.error(sender, "Nie odnaleziono podanej uslugi!");
    }
}