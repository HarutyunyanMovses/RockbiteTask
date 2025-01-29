# RockbiteTask
Item Upgrade System
This project implements an Item Upgrade System in Java where items can be generated, upgraded, and stored in an inventory. The system supports different rarities for items and allows for saving and loading the inventory data to and from a file. The project utilizes object serialization for saving and loading the inventory.

Features
Item Generation: Items are randomly generated with various rarities.
Item Upgrade: Items can be upgraded from one rarity to another, such as from "Common" to "Rare".
Inventory Management: View, add, and upgrade items in the inventory.
Serialization: Save the current inventory to a file and load it back later.
Project Structure
enums: Contains the Rarity enum defining the possible rarities for items (Common, Great, Rare, Epic, Legendary).
models: Contains the Item and Inventory classes:
Item: Represents an item with a name, rarity, and upgrade count.
Inventory: Represents a collection of items and provides methods to add items, upgrade them, and display the inventory.
DataGenerator: Responsible for generating random items with randomized rarities and saving the inventory to a file.
InventoryLoader: A class for loading an inventory from a file and displaying its contents.
Setup
Prerequisites
Java 17 or later installed.
An IDE like IntelliJ IDEA or Eclipse.
Installation
Clone this repository or download the project files.
Open the project in your Java IDE.
Compile and run the DataGenerator class to generate the inventory and save it to a file.
Optionally, you can use the InventoryLoader class to load the saved inventory and display its contents.
Usage
Generating Random Items
Run the DataGenerator class, and it will generate random items with different rarities and save them to a file called inventory.ser.

bash
Копировать
Редактировать
java DataGenerator
Loading Inventory
Run the InventoryLoader class to load the saved inventory from the file and display it.

bash
Копировать
Редактировать
java InventoryLoader
Adding, Upgrading, and Displaying Items
You can extend the system to provide a user interface (e.g., a command-line interface) for interacting with the inventory. For example, you could create options to add items manually, upgrade them, or display the current inventory. This could be implemented using a loop with user input.

How it Works
Item Generation: Items are randomly chosen from a predefined list of names, and each item is assigned a rarity based on defined probabilities.
Item Upgrades: Items can be upgraded through a series of rarity tiers. For example, "Common" items can be upgraded to "Great", and so on.
Serialization: The Inventory class is serialized into a file (by default, inventory.ser), and you can load the saved inventory at a later time using the InventoryLoader class.
Example Output
After running the DataGenerator and generating some random items, you might see an output similar to this:

bash
Копировать
Редактировать
Inventory saved successfully!

Current Inventory:
Iron Sword:
Iron Sword (COMMON) x3
Magic Wand:
Magic Wand (COMMON) x1
Magic Wand (EPIC) x1
Steel Armor:
Steel Armor (COMMON) x1
Steel Armor (RARE) x1
Golden Shield:
Golden Shield (COMMON) x1
Upgrading an Item
After upgrading an item (e.g., upgrading an Iron Sword), you might see the following output:

bash
Копировать
Редактировать
Upgraded 3 Iron Sword items to a higher rarity. The other two have been removed.
Iron Sword upgraded successfully!

Current Inventory:
Iron Sword:
Iron Sword (GREAT) x1
Contributing
Feel free to fork this project and submit issues or pull requests. You can add features, fix bugs, or improve the codebase. If you add a new feature, please update the README file accordingly.

License
This project is licensed under the MIT License - see the LICENSE file for details.

