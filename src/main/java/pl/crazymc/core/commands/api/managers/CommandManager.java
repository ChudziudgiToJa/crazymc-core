package pl.crazymc.core.commands.api.managers;


import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.java.JavaPlugin;
import pl.crazymc.core.commands.api.BukkitCommand;
import pl.crazymc.core.commands.api.Command;

import java.lang.reflect.Field;
import java.util.Arrays;

public class CommandManager {

    private CommandMap commandMap;

    public CommandManager(final JavaPlugin plugin) {
        try {
            final Field f = plugin.getServer().getClass().getDeclaredField("commandMap");
            f.setAccessible(true);
            this.commandMap = (CommandMap)f.get(Bukkit.getServer());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void registerCommand(final Command command) {
        this.commandMap.register(command.getName(), new BukkitCommand(command));
    }

    public void registerCommands(final Command... commands) {
        Arrays.stream(commands).forEachOrdered(this::registerCommand);
    }
}
