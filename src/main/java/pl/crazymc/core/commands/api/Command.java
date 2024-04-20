package pl.crazymc.core.commands.api;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.crazymc.core.commands.api.exceptions.CommandNotFoundException;
import pl.crazymc.core.commands.api.interfaces.CommandInfo;
import pl.crazymc.core.utils.Util;

import java.util.Arrays;
import java.util.List;

public abstract class Command {

    private final List<String> aliases;
    private final boolean player;
    private final String name, usage, permission;

    protected Command() {
        final CommandInfo commandInfo = getClass().getDeclaredAnnotation(CommandInfo.class);
        if (commandInfo == null)
            throw new CommandNotFoundException("Nie mozna zaladowac komendy " + this.getClass().getSimpleName() + ", ponieważ nie posiada ona adnotacji @CommandInfo");

        this.name = commandInfo.name();
        this.player = commandInfo.player();
        this.usage = "/" + commandInfo.name() + " " + commandInfo.usage();
        this.permission = commandInfo.perm();
        this.aliases = Arrays.asList(commandInfo.aliases());
    }


    public void sendUsage(final CommandSender commandSender) {
        Util.msg(commandSender, "&8▸ &7Poprawne uzycie: &a" + this.usage);
    }

    public void sendUsage(final Player player) {
        Util.msg(player, "&8▸ &7Poprawne uzycie: &a" + this.usage);
    }

    public String getName() {
        return name;
    }

    public boolean getPlayer() {
        return player;
    }

    public String getPermission() {
        return permission;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public abstract void execute(CommandSender sender, String[] args);
}
