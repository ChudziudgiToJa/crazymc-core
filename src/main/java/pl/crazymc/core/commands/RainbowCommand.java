package pl.crazymc.core.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.crazymc.core.commands.api.Command;
import pl.crazymc.core.commands.api.interfaces.CommandInfo;
import pl.crazymc.core.utils.Util;

import java.util.HashMap;
import java.util.UUID;

@CommandInfo(name = "tenczowy",
        perm = "core.cmd.tenczowy"
)
public class RainbowCommand extends Command {
    public static final HashMap<UUID, Boolean> nicks = new HashMap<>();

    public static boolean isRainbowNick(final Player p) {
        return nicks.getOrDefault(p.getUniqueId(), false);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        final boolean nickState = !isRainbowNick(player);
        nicks.put(player.getUniqueId(), nickState);
        player.sendMessage(Util.fixColor("&8• &aT&bE&CC&CZ&DO&EW&3Y &9N&FI&AC&1K &7zostal&8: &" + (nickState ? "awlaczony" : "cwylaczony") + "&7!"));
    }
}
