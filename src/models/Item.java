package models;

import enums.Rarity;
import java.io.Serializable;

public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private Rarity rarity;
    private int upgradeCount;

    public Item(String name, Rarity rarity) {
        this.name = name;
        this.rarity = rarity;
        this.upgradeCount = 0;
    }

    public String getName() {
        return name;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public int getUpgradeCount() {
        return upgradeCount;
    }

    public void incrementUpgrade() {
        upgradeCount++;
    }

    public void resetUpgradeCount() {
        upgradeCount = 0;
    }

    public Item upgrade() {
        if (rarity == Rarity.EPIC && upgradeCount == 0) {
            this.incrementUpgrade();  // Epic -> Epic 1
        } else if (upgradeCount == 1) {
            this.incrementUpgrade();  // Epic 1 -> Epic 2
        } else if (rarity == Rarity.EPIC && upgradeCount == 2) {
            return new Item(name, Rarity.LEGENDARY);  // Epic 2 -> Legendary
        } else if (rarity == Rarity.COMMON) {
            return new Item(name, Rarity.GREAT);  // Common -> Great
        } else if (rarity == Rarity.GREAT) {
            return new Item(name, Rarity.RARE);  // Great -> Rare
        } else if (rarity == Rarity.RARE) {
            return new Item(name, Rarity.EPIC);  // Rare -> Epic
        }
        return this;
    }

    @Override
    public String toString() {
        return name + " (" + rarity + " " + (upgradeCount > 0 ? upgradeCount : "") + ")";
    }
}
