//package pl.crazymc.core.commands;
//
//import net.minecraft.server.v1_8_R3.NBTTagCompound;
//import org.bukkit.Bukkit;
//import org.bukkit.Location;
//import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
//import org.bukkit.entity.Entity;
//import org.bukkit.entity.EntityType;
//import org.bukkit.entity.Player;
//import org.bukkit.entity.Villager;
//import pl.crazymc.core.inventories.VillagerGui;
//import pl.crazymc.core.utils.Util;
//
//public class VillagerCommand extends PlayerCommand {
//
//    public VillagerCommand() {
//        super("villager", "", "core.cmd.user", "wymiana");
//    }
//
//    @Override
//    public void execute(Player player, String[] args) {
//        if (args.length == 1 && player.hasPermission("core.cmd.villager")) {
//            if (args[0].equalsIgnoreCase("spawn")) {
//                final Location location = player.getLocation();
//                final Villager villager = (Villager) Bukkit.getWorld("world").spawnEntity(location, EntityType.VILLAGER);
//                villager.setCustomName(Util.fixColor("&2&lWymiana za zloto"));
//                this.noAI(villager);
//            }
//        } else VillagerGui.open(player);
//    }
//    private void noAI(final Entity bukkitEntity) {
//        final net.minecraft.server.v1_8_R3.Entity nmsEntity = ((CraftEntity) bukkitEntity).getHandle();
//        NBTTagCompound tag = nmsEntity.getNBTTag();
//        if (tag == null) {
//            tag = new NBTTagCompound();
//        }
//        nmsEntity.c(tag);
//        tag.setInt("NoAI", 1);
//        nmsEntity.f(tag);
//    }
//}
