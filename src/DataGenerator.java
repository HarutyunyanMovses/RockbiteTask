import enums.Rarity;
import models.Inventory;
import models.Item;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.Random;

public class DataGenerator {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        generateRandomItems(inventory);

        // Save the generated inventory to a file
        saveInventoryToFile(inventory, "inventory.ser");

        System.out.println("Inventory saved successfully!");
    }

    private static void generateRandomItems(Inventory inventory) {
        Random random = new Random();
        String[] itemNames = {
                "Iron Sword", "Iron Sword", "Magic Wand", "Magic Wand", "Steel Armor",
                "Steel Armor", "Iron Sword", "Magic Wand", "Steel Armor",
                "Golden Shield", "Golden Shield", "Silver Dagger", "Silver Dagger",
                "Elven Bow", "Elven Bow"
        };
        // Probabilities for Common, Great, Rare, Epic, Legendary
        double[] rarityProbabilities = {0.5, 0.25, 0.15, 0.08, 0.02};
        Rarity[] rarities = Rarity.values();

        for (String itemName : itemNames) {
            int randomRarityIndex = getRandomIndex(rarityProbabilities, random);
            Rarity randomRarity = rarities[randomRarityIndex];
            inventory.addItem(new Item(itemName, randomRarity));
        }
    }

    private static int getRandomIndex(double[] probabilities, Random random) {
        double rand = random.nextDouble();
        double cumulativeProbability = 0.0;
        for (int i = 0; i < probabilities.length; i++) {
            cumulativeProbability += probabilities[i];
            if (rand <= cumulativeProbability) {
                return i;
            }
        }
        return probabilities.length - 1;
    }

    private static void saveInventoryToFile(Inventory inventory, String filename) {
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(inventory);
        } catch (IOException e) {
            System.out.println("Error saving inventory: " + e.getMessage());
        }
    }
}
