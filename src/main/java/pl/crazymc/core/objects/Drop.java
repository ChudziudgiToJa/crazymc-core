package pl.crazymc.core.objects;

import org.bukkit.inventory.ItemStack;

public class Drop {
    private final String name;
    private final String color;
    private final double chance;
    private final boolean fortune;
    private final int minAmount;
    private final int maxAmount;
    private final int exp;
    private final boolean isGuild;
    private final ItemStack itemStack;

    public Drop(final String name, final String color, final double chance, final boolean fortune, final int minAmount, final int maxAmount, final int exp, final boolean isGuild, final ItemStack itemStack) {
        this.name = name;
        this.color = color;
        this.chance = chance;
        this.fortune = fortune;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.exp = exp;
        this.isGuild = isGuild;
        this.itemStack = itemStack;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public double getChance() {
        return chance;
    }

    public boolean isFortune() {
        return fortune;
    }

    public int getMinAmount() {
        return minAmount;
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public int getExp() {
        return exp;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public boolean isGuild() {
        return isGuild;
    }
}
