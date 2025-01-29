package models;

import java.io.Serializable;
import java.util.*;

public class Inventory implements Serializable {
    private static final long serialVersionUID = 1L;
    private Map<String, List<Item>> items;

    public Inventory() {
        items = new HashMap<>();
    }

    // Add item to the inventory
    public void addItem(Item item) {
        items.computeIfAbsent(item.getName(), k -> new ArrayList<>()).add(item);
    }

    // Upgrade an item if possible
    public boolean upgradeItem(String itemName) {
        List<Item> itemList = items.get(itemName);
        if (itemList == null || itemList.size() < 3) {
            System.out.println("Not enough items to upgrade.");
            return false;
        }

        // Perform the upgrade
        Item upgradedItem = itemList.get(0).upgrade();  // Upgrade the first item

        // Remove 3 used items
        itemList.remove(0);  // Remove the first item
        itemList.remove(0);  // Remove the second item
        itemList.remove(0);  // Remove the third item

        // Add the upgraded item
        addItem(upgradedItem);
        System.out.println("Upgraded " + itemName + " successfully.");
        return true;
    }

    // Display the inventory
    public void displayInventory() {
        System.out.println("Current Inventory:");
        for (Map.Entry<String, List<Item>> entry : items.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Item item : entry.getValue()) {
                System.out.println("\t" + item);
            }
        }
    }
}
