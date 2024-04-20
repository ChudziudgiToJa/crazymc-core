package pl.crazymc.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.crazymc.core.commands.api.Command;
import pl.crazymc.core.commands.api.interfaces.CommandInfo;
import pl.crazymc.core.configuration.Config;
import pl.crazymc.core.utils.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@CommandInfo(name = "sprawdz",
        perm = "core.sprawdz"
)
public class CheckCommand extends Command {
    public static List<UUID> checkPlayers = new ArrayList<>();

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player =(Player)sender;
        switch (args[0].toLowerCase()) {
            case "czysty":
                if (args.length == 2) {
                    final Player target = Bukkit.getPlayerExact(args[1]);
                    if (target != null) {
                        if (checkPlayers.contains(target.getUniqueId())) {
                            checkPlayers.remove(target.getUniqueId());
                            target.teleport(target.getWorld().getSpawnLocation().add(0.5, 0.0, 0.5));
                            Bukkit.broadcastMessage(Util.fixColor(Config.checkClearBroadcast.replace("{PLAYER}", target.getName())));
                            Util.sendTitle(target, Config.titleCheckClear, Config.subTitleCheckClear, 30, 60, 30);
                        } else player.sendMessage(Util.fixColor("&cPodany gracz nie jest sprawdzany!"));
                    } else player.sendMessage(Util.fixColor("&cPodany gracz jest offline!"));
                } else sendUsage(player);
                break;
            case "czity":
                if (args.length == 2) {
                    final Player target = Bukkit.getPlayerExact(args[1]);
                    if (target != null) {
                        if (checkPlayers.contains(target.getUniqueId())) {
                            checkPlayers.remove(target.getUniqueId());
                            Bukkit.broadcastMessage(Util.fixColor(Config.checkCheaterBroadcast.replace("{PLAYER}", target.getName())));
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), Config.checkCheaterCommand.replace("{PLAYER}", target.getName()));
                        } else player.sendMessage(Util.fixColor("&cPodany gracz nie jest sprawdzany!"));
                    } else player.sendMessage(Util.fixColor("&cPodany gracz jest offline!"));
                } else sendUsage(player);
                break;
            default:
                final Player target = Bukkit.getPlayerExact(args[0]);
                if (target != null) {
                    if (!checkPlayers.contains(target.getUniqueId())) {
                        checkPlayers.add(target.getUniqueId());
                        target.sendMessage(Util.fixColor(Config.playerCheckStartMessage));
                        for (String message : Config.checkStartBroadcast) {
                            Bukkit.broadcastMessage(Util.fixColor(message
                                    .replace("{PLAYER}", target.getName())
                                    .replace("{ADMIN}", player.getName())));
                        }
                        target.teleport(Config.checkLocation);
                        Util.sendTitle(target, Config.titleCheckStart, Config.subTitleCheckStart, 30, 60, 30);
                        sendUsage(player);
                    }
                }
        }
    }
    public void sendUsage(final Player player) {
        for (String message : Config.checkCommandUsage) {
            player.sendMessage(Util.fixColor(message));
        }
    }
}
