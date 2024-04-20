package pl.crazymc.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import pl.crazymc.core.commands.api.Command;
import pl.crazymc.core.commands.api.interfaces.CommandInfo;
import pl.crazymc.core.managers.EnderchestManager;
import pl.crazymc.core.managers.UserManager;
import pl.crazymc.core.objects.User;
import pl.crazymc.core.utils.Util;

@CommandInfo(name = "enderchest",
        perm = "core.enderchest",
        aliases = { "ec" }
)

public class EnderchestCommand extends Command {

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player =(Player) sender;
        if (args.length == 1 && player.hasPermission("core.cmd.endersee")) {
            final User user = UserManager.getUserOrNull(args[0]);
            if (user != null) {
                final Inventory inv = Bukkit.createInventory(null, user.getEnderChest().length, "Ender Chest: " + args[0]);
                inv.setContents(user.getEnderChest());
                player.openInventory(inv);
            } else Util.warning(player, "Nie odnaleziono podanego gracza w bazie danych.");
            return;
        }
        EnderchestManager.openEnderChest(player);
    }
}