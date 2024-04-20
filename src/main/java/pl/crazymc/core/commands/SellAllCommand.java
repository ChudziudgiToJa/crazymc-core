package pl.crazymc.core.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.crazymc.core.commands.api.Command;
import pl.crazymc.core.commands.api.interfaces.CommandInfo;
import pl.crazymc.core.objects.Shop;
import pl.crazymc.core.utils.Util;

@CommandInfo(name = "sellall",
        perm = "core.cmd.sellall"
)
public class SellAllCommand extends Command {

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        Shop.sellAll(player);
        Util.succes(player, "Wszystkie przedmioty zostaly sprzedane pomyslnie!");
    }
}
