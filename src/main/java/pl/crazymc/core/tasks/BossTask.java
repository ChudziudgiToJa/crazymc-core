//package pl.crazymc.core.tasks;
//
//import org.bukkit.Bukkit;
//import org.bukkit.Effect;
//import org.bukkit.Location;
//import org.bukkit.entity.Entity;
//import org.bukkit.entity.Player;
//import org.bukkit.scheduler.BukkitRunnable;
//import pl.crazymc.core.utils.Util;
//
//public class BossTask extends BukkitRunnable {
//    private int degree = 8;
//
//    @Override
//    public void run() {
//        if (degree < 360) {
//            degree += 8;
//        } else degree = 0;
//        for (Entity entity : Bukkit.getWorlds().get(0).getEntities()) {
//            if (entity.getCustomName() != null && entity.getCustomName().contains(Util.fixColor("&6&lBOSS"))) {
//                for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
//                    final Location loc = entity.getLocation();
//                    double radius = 0.3;
//                    for (int i = 0; i < 12; i++) {
//                        final double radians = Math.toRadians(degree + (i * 30));
//                        final double x = (radius * Math.cos(radians));
//                        final double z = (radius * Math.sin(radians));
//                        loc.add(x, 0.12, z);
////                        onlinePlayer.getWorld().spigot().playEffect(loc, Effect.COLOURED_DUST, 0, 0, 1.0F, 1.0F, 1.0F, 1, 0, 15);
//                        loc.subtract(x, 0.0, z);
//                        radius += 0.05;
//                    }
//                }
//            }
//        }
//    }
//}
//
