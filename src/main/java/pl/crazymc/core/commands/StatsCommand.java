package pl.crazymc.core.commands;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import pl.crazymc.core.commands.api.Command;
import pl.crazymc.core.commands.api.interfaces.CommandInfo;
import pl.crazymc.core.managers.UserManager;
import pl.crazymc.core.objects.Drop;
import pl.crazymc.core.objects.User;
import pl.crazymc.core.utils.DataUtil;
import pl.crazymc.core.utils.Util;

import java.util.LinkedList;
import java.util.List;

@CommandInfo(
        name = "statystyki",
        player = true
)
public class StatsCommand extends Command {
    @Override
    public void execute(CommandSender sender, String[] args) {
        final User user = UserManager.getUserOrNull(args[0]);
        if (user != null) {
            final Player target = user.getPlayer();
            final List<String> enabledDrops = new LinkedList<>();
            final List<String> effects = new LinkedList<>();
            for (Drop enabledDrop : user.enabledDrops) {
                enabledDrops.add(enabledDrop.getName());
            }
            if (target != null) {
                for (PotionEffect activePotionEffect : target.getActivePotionEffects()) {
                    effects.add(activePotionEffect.getType().getName() + " " + (activePotionEffect.getAmplifier() +1));
                }
            }
            Util.msg(sender, "");
            Util.msg(sender, "&f* &7INFORMACJE: &9&l&n" + user.getName());
            Util.msg(sender, "  &7Wykopany kamien: &f" + user.breakStone);
            Util.msg(sender, "  &7Spedzony czas: &f" + user.getPlayedTime());
            Util.msg(sender, "  &7Zjedzone koxy: &f" + user.godApplesEat);
            Util.msg(sender, "  &7Pieniadze: &f" + user.coins/100.0 + "zl");
            Util.msg(sender, "  &7Osiagniecia: &f" + user.achievements);
            Util.msg(sender, "  &7Wiadomosci z case: &f" + (user.caseMessages ? "&aTAK" : "&cNIE"));
            Util.msg(sender, "  &7Drop cobblestone: &f" + (user.dropCobblestone ? "&aTAK" : "&cNIE"));
            Util.msg(sender, "  &7Turbodrop: &f" + (user.turboDrop > System.currentTimeMillis() ? "&aTAK ( " + DataUtil.secondsToString(user.turboDrop - System.currentTimeMillis()) + " )" : "&cNIE"));
            Util.msg(sender, "  &7Odblokowany czat: &f" + (user.breakStone <= 150 && !sender.hasPermission("core.chatmine") ? "&cNIE" : "&aTAK"));
            Util.msg(sender, "  &7Wlaczone dropy: &f" + (enabledDrops.isEmpty() ? "BRAK" : StringUtils.join(enabledDrops,", ")));
            Util.msg(sender, "  &7Efekty: &f" + (user.getPlayer() == null ?  "&cOFFLINE" : (effects.isEmpty() ? "BRAK" : StringUtils.join(effects,", "))));
            Util.msg(sender, "");
        }
    }
}
