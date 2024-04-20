package pl.crazymc.core.managers;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import pl.crazymc.core.configuration.Config;
import pl.crazymc.core.configuration.CraftingsConfig;
import pl.crazymc.core.objects.CaseItem;
import pl.crazymc.core.objects.Drop;
import pl.crazymc.core.objects.User;
import pl.crazymc.core.utils.DropUtil;
import pl.crazymc.core.utils.RandomUtil;
import pl.crazymc.core.utils.Util;
import pl.crazymc.core.utils.Yaml;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DropManager {
    private static final List<Drop> drops = new ArrayList<>();

    public static void load() {
        drops.clear();
        final FileConfiguration config = Yaml.getYaml("drops.yml");
        for (String drop : config.getConfigurationSection("drops").getKeys(false)) {
            drops.add(new Drop(drop,
                    config.getString("drops." + drop + ".color"),
                    config.getDouble("drops." + drop + ".chance"),
                    config.getBoolean("drops." + drop + ".fortune"),
                    config.getInt("drops." + drop + ".minAmount"),
                    config.getInt("drops." + drop + ".maxAmount"),
                    config.getInt("drops." + drop + ".exp"),
                    config.getBoolean("drops." + drop + ".isGuild"),
                    Util.getItemStackFromString(Objects.requireNonNull(config.getString("drops." + drop + ".item")))));
        }
        drops.add(new Drop("PremiumCase", "&a&l", 0.1, false, 1, 1, 1, false, CraftingsConfig.getCase(1)));
    }

    public static List<Drop> getDrops() {
        return drops;
    }

    public static void breakBlock(final Player player, final Block block, final ItemStack itemStack) {
        final List<ItemStack> drops = new ArrayList<>();
        if (block.getType() == Material.STONE) {
            int exp = 20;
            final User user = UserManager.getUser(player);
            user.breakStone++;
            if (user.breakStone == 150) {
                Util.succes(player, "Gratulacje! Twoj czat zostal &2odblokowany&7!");
            }
            for (final Drop drop : user.enabledDrops) {
                final ItemStack item = drop.getItemStack();
                int dropExp = drop.getExp();
                double chance = drop.getChance();
                if (Config.turboDrop > System.currentTimeMillis() || user.turboDrop > System.currentTimeMillis()) {
                    chance *= 2.0;
                }
                if (RandomUtil.getChance(chance)) {
                    if (itemStack.containsEnchantment(Enchantment.LOOT_BONUS_BLOCKS) && drop.isFortune()) {
                        final int amount = DropUtil.addFortuneEnchant(drop.getMinAmount() == drop.getMaxAmount() ? drop.getMinAmount() : RandomUtil.getRandInt(drop.getMinAmount(), drop.getMaxAmount()), itemStack);
                        item.setAmount(amount);
                        dropExp *= amount;
                    }
                    if (drop.getName().contains("PremiumCase") && !(Config.turboCase > System.currentTimeMillis())) {
                        continue;
                    }
                    drops.add(item);
                    exp += dropExp;
                }
            }
            player.giveExp(exp);
            if (user.dropCobblestone) {
                drops.add(new ItemStack(itemStack.containsEnchantment(Enchantment.SILK_TOUCH) ? Material.STONE : Material.COBBLESTONE));
            }
            player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.5f, (float) (Math.random() * 20.0) / 10.0f);
            DropUtil.addItemsToPlayer(player, drops, block);
        }
    }
}
