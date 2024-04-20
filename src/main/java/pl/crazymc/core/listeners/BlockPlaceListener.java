package pl.crazymc.core.listeners;

import net.dzikoysk.funnyguilds.guild.RegionUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import pl.crazymc.core.configuration.Config;
import pl.crazymc.core.configuration.CraftingsConfig;
import pl.crazymc.core.managers.GeneratorManager;
import pl.crazymc.core.managers.UserManager;
import pl.crazymc.core.objects.CaseItem;
import pl.crazymc.core.objects.User;
import pl.crazymc.core.utils.RandomUtil;
import pl.crazymc.core.utils.Util;

public class BlockPlaceListener implements Listener {
    public static void sendCaseMessage(final String string) {
        for (final Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            final User user = UserManager.getUserOrNull(onlinePlayer);
            if (user != null && user.caseMessages) {
                Util.msg(onlinePlayer, string);
            }
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlace(final BlockPlaceEvent event) {
        final Player player = event.getPlayer();
        final Block block = event.getBlockPlaced();
        final ItemStack itemStack = player.getItemInHand();
        final Location location = block.getLocation();
        final User user = UserManager.getUser(player);
        if (itemStack.isSimilar(CraftingsConfig.getCase(1))) {
            event.setCancelled(true);
            if (Config.isCaseEnabled) {
                user.caseOpened++;
                int i = 0;
                sendCaseMessage("&5&l» &fGracz &6" + player.getName() + " &fotworzyl &9PremiumCase &fi wylosowal&8:");
                for (CaseItem caseItem : CaseItem.getCaseItems().values()) {
                    if (Math.random() * 100.0 <= caseItem.getChance() && i++ <= 7) {
                        player.getWorld().dropItemNaturally(block.getLocation(), caseItem.getItemStack());
                        sendCaseMessage(caseItem.getMessage());
                    }
                }
                sendCaseMessage("&e&l» &9PremiumCase &fzakupisz na &awww.CrazyMC.pl");
                if (itemStack.getAmount() > 1) itemStack.setAmount(itemStack.getAmount() - 1);
                else player.getInventory().removeItem(player.getItemInHand());
            } else Util.error(player, "PremiumCase sa wylaczone!");
        } else if (itemStack.isSimilar(CraftingsConfig.cobbleX)) {
            event.setCancelled(true);
            Util.giveItems(player, CraftingsConfig.cobbleXItems.get(RandomUtil.randomInts(CraftingsConfig.cobbleXItems.size())));
            Util.succes(player, "Otworzyles CobbleX!");
            if (itemStack.getAmount() > 1) itemStack.setAmount(itemStack.getAmount() - 1);
            else player.getInventory().removeItem(player.getItemInHand());
        } else if (itemStack.isSimilar(CraftingsConfig.generator)) {
            GeneratorManager.addGenerator(event.getBlock().getLocation());
            event.getBlock().setType(Material.STONE);
            Util.succes(player, "Postawiles stoniarke.");
//        } else if (itemStack.isSimilar(CraftingsConfig.boyFarmer)) {
//            if (RegionUtils.isIn(block.getLocation())) {
//                for (int i = block.getY(); i > 0; i--) {
//                    if (location.getBlock().getType() != Material.BEDROCK) {
//                        location.getBlock().setType(Material.OBSIDIAN);
//                        location.setY(i);
//                    }
//                }
//            } else {
//                Util.msg(player, "&cBoyFarmer mozesz postawic tylko na terenie gildii!");
//                event.setCancelled(true);
//            }
//        } else if (itemStack.isSimilar(CraftingsConfig.sandFarmer)) {
//            if (RegionUtils.isIn(block.getLocation())) {
//                for (int i = block.getY(); i > 0; i--) {
//                    if (location.getBlock().getType() != Material.BEDROCK) {
//                        location.getBlock().setType(Material.SAND);
//                        location.setY(i);
//                    }
//                }
//            } else {
//                Util.msg(player, "&cSandFarmer mozesz postawic tylko na terenie gildii!");
//                event.setCancelled(true);
//            }
//        } else if (itemStack.isSimilar(CraftingsConfig.kopaczFosy)) {
//            if (RegionUtils.isIn(block.getLocation())) {
//                for (int i = block.getY(); i > 0; i--) {
//                    if (location.getBlock().getType() != Material.BEDROCK) {
//                        location.getBlock().setType(Material.AIR);
//                        location.setY(i);
//                    }
//                }
//            } else {
//                Util.msg(player, "&cKopacz fosy mozesz postawic tylko na terenie gildii!");
//                event.setCancelled(true);
//            }
        }
    }
}
