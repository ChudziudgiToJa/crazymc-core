package pl.crazymc.core.commands.api;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.crazymc.core.utils.Util;

public class BukkitCommand extends org.bukkit.command.Command {

    private final Command command;

    public BukkitCommand(Command command) {
        super(command.getName(), "", "", command.getAliases());
        this.command = command;
    }

    @Override
    public boolean execute(CommandSender sender, String string, String[] args) {
        if (command.getPlayer() && !(sender instanceof Player)) {
            Util.msg(sender, "&4Blad: &cTej komendy nie mozna wywolac z poziomu konsoli!");
            return true;
        }
        final String permission = command.getPermission();
        if (!permission.isEmpty() && !sender.hasPermission(permission)) {
            Util.msg(sender, String.format("&4Blad: &cNie masz uprawnien! &8(&7%s&8)", permission));
            return true;
        }
        return true;
    }
}
