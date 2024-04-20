package pl.crazymc.core.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import pl.crazymc.core.CorePlugin;
import pl.crazymc.core.commands.CheckCommand;
import pl.crazymc.core.commands.HelpopCommand;
import pl.crazymc.core.configuration.Config;
import pl.crazymc.core.managers.AntiLegsManager;
import pl.crazymc.core.managers.UserManager;
import pl.crazymc.core.managers.VanishManager;
import pl.crazymc.core.objects.User;
import pl.crazymc.core.utils.Util;

public class PlayerJoinQuitListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.setJoinMessage(null);
        Player player = event.getPlayer();
        UserManager.getUser(player).join();
        Util.sendTitle(player, Config.joinTitle.replace("{NICK}", player.getName()), Config.joinSubtitle.replace("{NICK}", player.getName()), 20, 50, 20);
        for (String string : Config.joinMessage) {
            Util.msg(player, string.replace("{NICK}", player.getName()).replace("{ONLINE}", String.valueOf(Bukkit.getOnlinePlayers().size())));
        }
        if (!player.hasPermission("core.vanish.see")) {
            for (Player vanishPlayer : VanishManager.getVanishPlayers()) {
                player.hidePlayer(vanishPlayer);
            }
        } else VanishManager.toggleVanish(player,true);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        event.setQuitMessage(null);
        Player player = event.getPlayer();
//        FightCommand.cooldownPlayers.remove(player.getUniqueId());
        HelpopCommand.cooldownPlayers.remove(player.getUniqueId());
        EnderchestListener.cooldownPlayers.remove(player.getUniqueId());
        AsyncPlayerChatListener.chatCooldown.remove(player.getUniqueId());
        AntiLegsManager.antiLegsPlayer.remove(player.getUniqueId());
        if (CheckCommand.checkPlayers.contains(player.getUniqueId())) {
            CheckCommand.checkPlayers.remove(player.getUniqueId());
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), Config.checkLogoutCommand.replace("{PLAYER}",player.getName()));
        }
        User user = UserManager.getUser(player);
        user.quit();
        Bukkit.getScheduler().runTaskAsynchronously(CorePlugin.getInstance(), () -> UserManager.saveObject(user));
    }
}
