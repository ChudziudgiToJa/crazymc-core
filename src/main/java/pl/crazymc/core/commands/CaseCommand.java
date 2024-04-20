package pl.crazymc.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.crazymc.core.commands.api.Command;
import pl.crazymc.core.commands.api.interfaces.CommandInfo;
import pl.crazymc.core.configuration.CraftingsConfig;
import pl.crazymc.core.inventories.CaseGui;
import pl.crazymc.core.utils.DataUtil;
import pl.crazymc.core.utils.Util;

@CommandInfo(name = "AdminChat",
        perm = "core.case.command")
public class CaseCommand extends Command {

    public static long lastCaseGive = 0L;

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 2 && sender.hasPermission("core.cmd.case")) {
            final int size = Integer.parseInt(args[1]);
            if (args[0].equalsIgnoreCase("all")) {
                for (final Player player : Bukkit.getOnlinePlayers()) {
                    Util.giveItems(player, CraftingsConfig.getCase(size));
                }
                lastCaseGive = System.currentTimeMillis() + DataUtil.Time.HOUR.getTime(6);
                Bukkit.broadcastMessage(Util.fixColor("&7Caly serwer otrzymal &9&l&nPremiumCase &7x&9" + size));
            } else {
                final Player target = Bukkit.getPlayerExact(args[0]);
                if (target != null) {
                    final String name = target.getName();
                    target.getInventory().addItem(CraftingsConfig.getCase(size));
                    Util.info(sender, "Gracz: &3" + name + "&7 otrzymal &9&l&nPremiumCase &7x&9" + size);
                }
            }
        } else {
            if (sender instanceof Player) {
                CaseGui.open((Player) sender);
            } else sendUsage(sender);
        }
    }
}

