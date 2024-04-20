package pl.crazymc.core.managers;

import org.bukkit.configuration.file.FileConfiguration;
import pl.crazymc.core.objects.Service;
import pl.crazymc.core.utils.Yaml;

import java.util.ArrayList;
import java.util.List;

public class ServiceManager {
    private static final List<Service> serviceList = new ArrayList<>();

    public static void load() {
        serviceList.clear();
        final FileConfiguration config = Yaml.getYaml("itemshop.yml");
        for (final String string : config.getConfigurationSection("itemshop").getKeys(false)) {
            serviceList.add(new Service(string, config.getString("itemshop." + string + ".command"), config.getStringList("itemshop." + string + ".message")));
        }
    }

    public static Service getService(final String name) {
        for (final Service service : serviceList) {
            if (service.getName().equals(name)) {
                return service;
            }
        }
        return null;
    }
}
