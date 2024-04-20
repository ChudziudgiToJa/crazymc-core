package pl.crazymc.core;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pl.crazymc.core.builders.InventoryBuilder;
import pl.crazymc.core.commands.*;
import pl.crazymc.core.commands.api.managers.CommandManager;
import pl.crazymc.core.database.Database;
import pl.crazymc.core.listeners.*;
import pl.crazymc.core.managers.*;
import pl.crazymc.core.objects.User;
import pl.crazymc.core.tasks.AutoMessageTask;
import pl.crazymc.core.tasks.DepositTask;
import pl.crazymc.core.tasks.VanishTask;

public class CorePlugin extends JavaPlugin {
    private static CorePlugin instance;

    public static CorePlugin getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();
        Database.load();
        DropManager.load();
        GeneratorManager.load();
        ServiceManager.load();
        ConfigCommandsManager.load();

        final CommandManager commandManager = new CommandManager(this);

        Bukkit.getPluginManager().registerEvents(new AntiLegsListener(), this);
        Bukkit.getPluginManager().registerEvents(new AsyncPlayerChatListener(), this);
        Bukkit.getPluginManager().registerEvents(new BlockBreakListener(), this);
        Bukkit.getPluginManager().registerEvents(new BlockFromToListener(), this);
        Bukkit.getPluginManager().registerEvents(new BlockPlaceListener(), this);
        Bukkit.getPluginManager().registerEvents(new EnderchestListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerDeathListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInteractListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinQuitListener(), this);
        Bukkit.getPluginManager().registerEvents(new PrepareItemCraftListener(), this);
        Bukkit.getPluginManager().registerEvents(new RegionListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerMoveListener(), this);
        Bukkit.getPluginManager().registerEvents(new BossListener(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryBuilder.Listeners(), this);
        Bukkit.getPluginManager().registerEvents(new EnderEventListener(), this);


        commandManager.registerCommands(
                new AchievementsCommand(),
                new AdminChatCommand(),
                new AlertCommand(),
                new BlocksCommand(),
                new BossCommand(),
                new CaseCommand(),
                new ChatCommand(),
                new CheckCommand(),
                new CobbleXCommand(),
                new CoreCommand(),
                new CraftingsCommand(),
                new DepositCommand(),
                new DropCommand(),
                new EffectsCommand(),
                new EnableCaseCommand(),
                new EnderchestCommand(),
                new FreeCaseCommand(),
                new HelpopCommand(),
                new KitsCommand(),
                new RainbowCommand(),
                new SellAllCommand(),
                new ServiceCommand(),
                new SetCoinsCommand(),
                new ShopCommand(),
                new StatsCommand(),
                new TopCommand(),
                new TurboCaseCommand(),
                new TurboCaseCommand(),
                new TurboDropCommand()
        );

//        Bukkit.addRecipe(
//                new ShapedRecipe(CraftingsConfig.generator)
//                        .shape("aaa", "aba", "aaa")
//                        .setIngredient('a', Material.STONE)
//                        .setIngredient('b', Material.PISTON));
//
//        Bukkit.addRecipe(
//                new ShapedRecipe(CraftingsConfig.antiLegs)
//                        .shape("aaa", "aba", "aaa")
//                        .setIngredient('a', Material.EMERALD_BLOCK)
//                        .setIngredient('b', Material.GOLD_BLOCK));
//
//        Bukkit.addRecipe(
//                new ShapedRecipe(CraftingsConfig.boyFarmer)
//                        .shape("aaa", "aba", "aaa")
//                        .setIngredient('a', Material.OBSIDIAN)
//                        .setIngredient('b', Material.GOLDEN_APPLE));
//
//        Bukkit.addRecipe(
//                new ShapedRecipe(CraftingsConfig.sandFarmer)
//                        .shape("aaa", "aba", "aaa")
//                        .setIngredient('a', Material.SAND)
//                        .setIngredient('b', Material.GOLDEN_APPLE));
//
//        Bukkit.addRecipe(
//                new ShapedRecipe(CraftingsConfig.kopaczFosy)
//                        .shape("aaa", "aba", "aaa")
//                        .setIngredient('a', Material.COBBLESTONE)
//                        .setIngredient('b', Material.GOLDEN_APPLE));
//
//        new CraftingBuilder(CraftingsConfig.atomicTnT, new ItemStack(Material.TNT, 64), new ItemStack(Material.TNT, 64), new ItemStack(Material.TNT, 64), new ItemStack(Material.TNT, 64), new ItemStack(Material.TNT, 64), new ItemStack(Material.TNT, 64), new ItemStack(Material.TNT, 64), new ItemStack(Material.TNT, 64), new ItemStack(Material.TNT, 64));
//
//        new CraftingBuilder(CraftingsConfig.cobbleX, new ItemStack(Material.COBBLESTONE, 64), new ItemStack(Material.COBBLESTONE, 64), new ItemStack(Material.COBBLESTONE, 64), new ItemStack(Material.COBBLESTONE, 64), new ItemStack(Material.COBBLESTONE, 64), new ItemStack(Material.COBBLESTONE, 64), new ItemStack(Material.COBBLESTONE, 64), new ItemStack(Material.COBBLESTONE, 64), new ItemStack(Material.COBBLESTONE, 64));

        new AutoMessageTask().runTaskTimerAsynchronously(this, 20L, 20L * 60L);
        new VanishTask().runTaskTimerAsynchronously(this, 20L, 25L);
        new DepositTask().runTaskTimerAsynchronously(this, 20L, 20L * 2L);
//        new BossTask().runTaskTimerAsynchronously(this, 20L, 1L);
        new EnderEventListener().runTaskTimer(this,20L, 40L);

    }

    @Override
    public void onDisable() {
        for (User user : UserManager.objects.values()) {
             user.quit();
        }
        EnderchestManager.save();
        GeneratorManager.save();
        Database.saveDatabase();
    }
}
