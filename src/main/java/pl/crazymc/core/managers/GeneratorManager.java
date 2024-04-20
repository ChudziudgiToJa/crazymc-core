package pl.crazymc.core.managers;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.scheduler.BukkitRunnable;
import pl.crazymc.core.CorePlugin;
import pl.crazymc.core.utils.Yaml;

import java.io.*;
import java.util.HashSet;

public class GeneratorManager {
    private static final File configFile = Yaml.getFile("generators.dat");
    private static HashSet<String> list = new HashSet<>();


    public static String locationToString(final Location location) {
        final String world = location.getWorld().getName();
        final double x = location.getBlockX();
        final double y = location.getBlockY();
        final double z = location.getBlockZ();
        return world + "," + x + "," + y + "," + z;
    }

    public static Location locationFromString(final String s) {
        final String[] strings = s.split(",");
        return new Location(Bukkit.getWorld(strings[0]), Double.parseDouble(strings[1]), Double.parseDouble(strings[2]), Double.parseDouble(strings[3]));
    }

    public static void load() {
        if (configFile.exists() && configFile.isFile()) {
            try {
                final ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(configFile));
                final Object object = objectInputStream.readObject();
                //noinspection unchecked
                list = (HashSet<String>) object;
                objectInputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        new BukkitRunnable() {
            @Override
            public void run() {
                for (String s : list) {
                    final Location location = locationFromString(s);
                    if (isGenerator(location)) {
                        location.getWorld().getBlockAt(location).setType(Material.STONE);
                    }
                }
            }
        }.runTaskLater(CorePlugin.getInstance(), 4L);

    }

    public static void save() {
        try {
            final ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(configFile));
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isGenerator(final Location s) {
        return list.contains(locationToString(s));
    }

    public static void deleteGenerator(final Location s) {
        if (isGenerator(s)) {
            list.remove(locationToString(s));
        }
    }

    public static void addGenerator(final Location s) {
        if (!isGenerator(s)) {
            list.add(locationToString(s));
        }
    }
}
