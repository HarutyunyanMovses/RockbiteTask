import enums.Rarity;

import models.Inventory;
import models.InventoryUtils;
import models.Item;


import java.util.Random;
import java.util.Scanner;

public class ItemUpgradeSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = InventoryUtils.loadInventory("inventory.ser");

        while (true) {
            System.out.println("\n1. Add Item\n2. Upgrade Item\n3. Display Inventory\n4. Save Inventory\n5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter item rarity (COMMON, GREAT, RARE, EPIC, LEGENDARY): ");
                    String rarity = scanner.nextLine();
                    inventory.addItem(new Item(name, Rarity.valueOf(rarity.toUpperCase())));
                    break;
                case 2:
                    System.out.print("Enter item name to upgrade: ");
                    String itemName = scanner.nextLine();
                    inventory.upgradeItem(itemName);
                    break;
                case 3:
                    inventory.displayInventory();
                    break;
                case 4:
                    InventoryUtils.saveInventory(inventory, "inventory.ser");
                    System.out.println("Inventory saved.");
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }

        }
    }


}
