package pl.crazymc.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.crazymc.core.commands.api.Command;
import pl.crazymc.core.commands.api.interfaces.CommandInfo;
import pl.crazymc.core.managers.VanishManager;
import pl.crazymc.core.utils.Util;


@CommandInfo(
        name = "vanish",
        perm = "core.cmd.vanish",
        aliases = {"v"}
)
public class VanishCommand extends Command {

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        if (args.length < 1) {
            toggleVanish(player);
        } else {
            final Player target = Bukkit.getPlayerExact(args[0]);
            if (target != null) {
                toggleVanish(target);
                Util.msg(player, "&3&lVANISH &8- &7" + target.getName() + " jest teraz " + (VanishManager.isVanished(target) ? "niewidoczny" : "widoczny") + "!");
            }
        }
    }
    public void toggleVanish(final Player player) {
        VanishManager.toggleVanish(player);
        Util.msg(player, "&3&lVANISH &8- " + (VanishManager.isVanished(player) ? "&aJestes teraz niewidoczny!" : "&7Stales sie widoczny!"));
//        player.getWorld().spigot().playEffect(player.getLocation(), Effect.CLOUD,0,0,0.4f,0.4f,0.4f,0.1f,50,10);
//        player.getWorld().spigot().playEffect(player.getLocation(), Effect.FLAME,0,0,0.3f,0.3f,0.3f,0.1f,5,10);
    }
}
