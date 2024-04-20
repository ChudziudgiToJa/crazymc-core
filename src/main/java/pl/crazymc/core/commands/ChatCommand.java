package pl.crazymc.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.crazymc.core.commands.api.Command;
import pl.crazymc.core.commands.api.interfaces.CommandInfo;
import pl.crazymc.core.utils.Util;

@CommandInfo(
        name = "chat",
        perm = "core.chat.command"
)

public class ChatCommand extends Command {
    public static boolean isChat = true;

    @Override
    public void execute(CommandSender sender, String[] args) {

        final Player player = (Player) sender;
        switch (args[0]) {
            case "clear":
            case "c":
                for (int i = 0; i < 1000; i++) {
                    Bukkit.broadcastMessage("");
                }
                Bukkit.broadcastMessage(Util.fixColor("&5&l» &3Czat serwera zostal &fwyczyszczony &3przez &7" + player.getName() + "&7!"));
                break;
            case "off":
                Bukkit.broadcastMessage(Util.fixColor("&5&l» &3Czat serwera zostal &cwylaczony &3przez &7" + player.getName() + "&7!"));
                isChat = false;
                break;
            case "on":
                Bukkit.broadcastMessage(Util.fixColor("&5&l» &3Czat serwera zostal &2wlaczony &3przez &7" + player.getName() + "&7!"));
                isChat = true;
                break;
            default:
                sendUsage(player);
        }
    }
}
