package pl.crazymc.core.commands;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.crazymc.core.commands.api.Command;
import pl.crazymc.core.commands.api.interfaces.CommandInfo;
import pl.crazymc.core.utils.Util;

import java.util.HashMap;
import java.util.UUID;

@CommandInfo(
        name = "helpop",
        perm = "core.helpop"
)
public class HelpopCommand extends Command {
    public static final HashMap<UUID, Long> cooldownPlayers = new HashMap<>();

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        if (args.length > 0) {
            if (cooldownPlayers.getOrDefault(player.getUniqueId(), 0L) <= System.currentTimeMillis()) {
                for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                    if (onlinePlayer.hasPermission("core.helpop")) {
                        Util.msg(onlinePlayer, "&9------------&8[ &6* &3&lHelpOp &6* &8]&9------------");
                        Util.info(onlinePlayer, "Gracz: &f" + player.getName());
                        Util.info(onlinePlayer, "Wiadomosc: &f" + StringUtils.join(args, " "));
                        Util.msg(onlinePlayer, "&9------------&8[ &6* &3&lHelpOp &6* &8]&9------------");
                    }
                }
                cooldownPlayers.put(player.getUniqueId(), System.currentTimeMillis() + 30000L);
                Util.succes(player,"&aTwoja wiadomosc zostala wyslana!");
            } else Util.error(player, "Poczekaj 30 sekund zanim wyslesz kolejna wiadomosc.");
        } else sendUsage(player);
    }
}
