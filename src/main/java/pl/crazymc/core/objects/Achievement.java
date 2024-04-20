package pl.crazymc.core.objects;

import pl.crazymc.core.builders.ItemBuilder;

public class Achievement {
    private final int number;
    private final Prize[] prizes;

    public Achievement(final int number, final Prize[] prizes) {
        this.number = number;
        this.prizes = prizes;
    }

    public int getNumber() {
        return number;
    }

    public Prize[] getPrizes() {
        return prizes;
    }


    public static class Prize {
        private final String name;
        private final int amount;
        private final int requirements;
        private final int pcase;
        private final ItemBuilder itemBuilder;

        public Prize(final String name, int amount, final int pcase, final int requirements, ItemBuilder itemBuilder) {
            this.name = name;
            this.amount = amount;
            this.pcase = pcase;
            this.requirements = requirements;
            this.itemBuilder = itemBuilder;
        }

        public int getPcase() {
            return pcase;
        }

        public String getName() {
            return name;
        }

        public boolean isCompleted() {
            return amount >= requirements;
        }

        public ItemBuilder getItemStack() {
            return itemBuilder;
        }

    }
}
