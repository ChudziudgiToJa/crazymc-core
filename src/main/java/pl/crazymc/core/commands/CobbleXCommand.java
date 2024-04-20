package pl.crazymc.core.commands;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pl.crazymc.core.commands.api.Command;
import pl.crazymc.core.commands.api.interfaces.CommandInfo;
import pl.crazymc.core.configuration.CraftingsConfig;
import pl.crazymc.core.utils.Util;

@CommandInfo(name = "Cobblestonex",
        perm = "core.chat.admin",
        aliases = { "cx" }
)
public class CobbleXCommand extends Command {

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        final Inventory inv = player.getInventory();
        if (Util.getAmount(player, Material.COBBLESTONE) >= 576) {
            inv.removeItem(new ItemStack(Material.COBBLESTONE,576));
            Util.giveItems(player, CraftingsConfig.cobbleX);
            Util.succes(player,"Stworzyles CobbleX!");
        } else Util.error(player,"Aby stworzyc CobbleX musisz posiadac 9x64 cobblestone!");
    }
}
