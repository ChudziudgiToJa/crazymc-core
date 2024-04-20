package pl.crazymc.core.utils;

import org.apache.commons.lang3.Validate;

import java.util.Random;

public class RandomUtil {
    private static final Random rand = new Random();

    public static int getRandInt(final int min, final int max) throws IllegalArgumentException {
        Validate.isTrue(max > min, "Max can't be smaller than min!");
        return rand.nextInt(max - min + 1) + min;
    }

    private static Double getRandDouble() throws IllegalArgumentException {
        Validate.isTrue(true, "Max can't be smaller than min!");
        return rand.nextDouble() * (100.0 - 0.0) + 0.0;
    }

    public static boolean getChance(final double chance) {
        return chance >= 100.0 || chance >= getRandDouble();
    }

    public static int randomInts(final int i) {
        return rand.nextInt(i);
    }

}
