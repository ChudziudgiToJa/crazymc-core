package pl.crazymc.core.managers;

import org.bukkit.configuration.file.FileConfiguration;
import pl.crazymc.core.objects.Command;
import pl.crazymc.core.utils.Yaml;

import java.util.ArrayList;
import java.util.List;

public class ConfigCommandsManager {
    private static final List<Command> commandList = new ArrayList<>();
    private static final List<String> blockedCommandList = new ArrayList<>();

    public static void load() {
        commandList.clear();
        blockedCommandList.clear();
        final FileConfiguration config = Yaml.getYaml("commands.yml");
        for (String commands : config.getConfigurationSection("commands").getKeys(false)) {
            commandList.add(new Command("/" + commands, config.getStringList("commands." + commands)));
        }
        blockedCommandList.addAll(config.getStringList("blocked-commands"));
    }

    public static List<Command> getCommandList() {
        return commandList;
    }

    public static List<String> getBlockedCommandList() {
        return blockedCommandList;
    }
}
