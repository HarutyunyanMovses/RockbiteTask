package models;

import java.io.*;


public class InventoryUtils {

    // Save the inventory to a file
    public static void saveInventory(Inventory inventory, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(inventory);
        } catch (IOException e) {
            System.out.println("Error saving inventory: " + e.getMessage());
        }
    }

    // Load the inventory from a file
    public static Inventory loadInventory(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (Inventory) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading inventory: " + e.getMessage());
            return new Inventory();  // Return a new inventory if loading fails
        }
    }
}
