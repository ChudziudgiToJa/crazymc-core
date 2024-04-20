package pl.crazymc.core.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import pl.crazymc.core.commands.ChatCommand;
import pl.crazymc.core.commands.CheckCommand;
import pl.crazymc.core.commands.RainbowCommand;
import pl.crazymc.core.configuration.Config;
import pl.crazymc.core.managers.ConfigCommandsManager;
import pl.crazymc.core.managers.UserManager;
import pl.crazymc.core.objects.Command;
import pl.crazymc.core.objects.User;
import pl.crazymc.core.utils.Util;

import java.util.*;

public class AsyncPlayerChatListener implements Listener {
    public static final HashMap<String, String> emoji = new HashMap<>();
    static {
        emoji.put(":shrug:","¯\\_(ツ)_/¯");
        emoji.put(":tableflip:","(╯°□°）╯︵ ┻━┻");
        emoji.put(":unflip:","┬─┬ ノ( ゜-゜ノ)");
        emoji.put("<3","❤");
    }
    private static final String[] colors = new String[]{"&a", "&b", "&c", "&d", "&e", "&f", "&2", "&3", "&4", "&5", "&6", "&7", "&8"};
    public static final HashMap<UUID, Long> chatCooldown = new HashMap<>();
    private static final List<String> chatMineBlocked = Arrays.asList("/msg","/m", "/tell");

    @EventHandler(ignoreCancelled = true)
    public void onChat(final AsyncPlayerChatEvent event) {
        final Player player = event.getPlayer();
        final User user = UserManager.getUser(player);
        if (user.breakStone <= 150 && !player.hasPermission("core.chatmine")) {
            Util.error(player, "Aby pisac na czacie musisz wykopac &4150 &ckamienia. (" + user.breakStone + "/150)");
            event.setCancelled(true);
            return;
        } else if (!ChatCommand.isChat && !player.hasPermission("core.cmd.chat")) {
            Util.msg(player, "&5&l» &a&lCzat jest w tym momencie &cwylaczony&f!");
            event.setCancelled(true);
            return;
        } else if (chatCooldown.getOrDefault(player.getUniqueId(), 0L) > System.currentTimeMillis() && !player.hasPermission("core.cmd.chat")) {
            Util.msg(player, "&4&l» &7Na czacie mozesz pisac co &c7 sekund&7!");
            event.setCancelled(true);
            return;
        } else if (RainbowCommand.isRainbowNick(player)) {
            final Random random = new Random();
            final StringBuilder sb = new StringBuilder();
            for (final char c : player.getName().toCharArray()) {
                sb.append(colors[random.nextInt(colors.length)]).append("&l").append(c);

            }
            player.setDisplayName(Util.fixColor(sb.toString()));
        }
        String message = event.getMessage();
        for (Map.Entry<String, String> entry : emoji.entrySet()) {
            message = message.replace(entry.getKey(),entry.getValue());
        }
        event.setMessage(message);
        chatCooldown.put(player.getUniqueId(), System.currentTimeMillis() + 7000L);
    }

    @EventHandler
    public void onCommand(final PlayerCommandPreprocessEvent event) {
        final Player player = event.getPlayer();
        final User user = UserManager.getUser(player);
        final String[] split = event.getMessage().split(" ");
        for (String s : chatMineBlocked) {
            if (split[0].equals(s) && user.breakStone <= 150 && !player.hasPermission("core.chatmine")) {
                Util.error(player, "Aby pisac prywatne wiadomosci musisz wykopac &4150 &ckamienia. (" + user.breakStone + "/150)");
                event.setCancelled(true);

            }
        }
        if (!ConfigCommandsManager.getBlockedCommandList().contains(split[0])) {
            for (final Command configCommand : ConfigCommandsManager.getCommandList()) {
                if (configCommand.getName().equalsIgnoreCase(split[0])) {
                    for (final String message : configCommand.getMessage()) {
                        Util.msg(player, message.replace("{NICK}", player.getName()));
                    }
                    event.setCancelled(true);
                }
            }
        } else {
            Util.error(player, "Nie masz uprawnien!");
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void onCommand1(final PlayerCommandPreprocessEvent event) {
        final Player player = event.getPlayer();
        final String message = event.getMessage();
        if (CheckCommand.checkPlayers.contains(player.getUniqueId())) {
            for (String checkBlockedCommand : Config.checkBlockedCommands) {
                if (!message.startsWith(checkBlockedCommand)) {
                    player.sendMessage(Util.fixColor(Config.playerAllowedCommands));
                    Util.sendTitle(player,Config.titleBlockedCommand, Config.subTitleBlockedCommand,30,60,30);
                    event.setCancelled(true);
                }
            }
        }
    }
}
