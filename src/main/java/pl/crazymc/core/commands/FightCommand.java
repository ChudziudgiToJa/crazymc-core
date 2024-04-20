//package pl.crazymc.core.commands;
//
//import net.dzikoysk.funnyguilds.basic.guild.Guild;
//import net.dzikoysk.funnyguilds.basic.user.User;
//import org.bukkit.Location;
//import org.bukkit.entity.Player;
//import pl.crazymc.core.configuration.Config;
//import pl.crazymc.core.utils.Util;
//
//import java.util.HashMap;
//import java.util.UUID;
//
//public class FightCommand extends PlayerCommand {
//    public static final HashMap<UUID, Long> cooldownPlayers = new HashMap<>();
//
//    public FightCommand() {
//        super("fight", "", "core.cmd.user", "walka");
//    }
//
//    @Override
//    public void execute(Player player, String[] args) {
//        final User user = User.get(player);
//        if (user.hasGuild()) {
//            if (user.isOwner()) {
//                if (cooldownPlayers.getOrDefault(player.getUniqueId(), 0L) < System.currentTimeMillis()) {
//                    final Guild guild = user.getGuild();
//                    final Location home = guild.getHome();
//                    for (String string : Config.fightMessage) {
//                        Util.broadcast(string.replace("{TAG}", guild.getTag())
//                                .replace("{X}", String.valueOf(home.getBlockX()))
//                                .replace("{Y}", String.valueOf(home.getBlockY()))
//                                .replace("{Z}", String.valueOf(home.getBlockZ())));
//                    }
//                    cooldownPlayers.put(player.getUniqueId(), System.currentTimeMillis() + 1000L * 60L);
//                } else Util.error(player, "Poczekaj troche zanim tego uzyjesz!");
//            } else Util.error(player, "Musisz byc liderem gildii, aby to zrobic!");
//        } else Util.error(player, "Nie masz gildii!");
//    }
//}
