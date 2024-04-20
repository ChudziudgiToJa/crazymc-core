package pl.crazymc.core.utils;

import org.bukkit.configuration.file.YamlConfiguration;
import pl.crazymc.core.CorePlugin;

import java.io.File;
import java.io.InputStream;

public class Yaml {
    public static YamlConfiguration getYaml(final String name) {
        return YamlConfiguration.loadConfiguration(getFile(name));
    }

    public static File getFile(final String name) {
        final File file = new File(CorePlugin.getInstance().getDataFolder(), name);
        if (!file.exists()) {
            final InputStream inputStream = CorePlugin.getInstance().getResource(name);
            if (inputStream != null) {
                CorePlugin.getInstance().saveResource(name, true);
            }
        }
        return file;
    }
}
