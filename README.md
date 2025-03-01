Assignment 2: THE VIDEO GAME

Developed as assignment for the programming subject.

Author: Miguel Márquez Roldán
Teacher: Javier Aparicio León
Language: Java

Date: 28/02/2025

------------------------

# **Role-Playing Game Project in Java**
This project is a role-playing game (RPG) developed in Java that allows players to create characters, explore a map, battle enemies, and complete missions. The game includes different character types, enemies, equipment, and a shop for purchasing items. Below is a description of the project structure and how it works.

## **Project Structure**
The project is organized into multiple Java files, each with a specific function:

### **1. Archer**
- Represents the Archer class, a character type that can attack from a distance.
- Implements the `Skill` interface for special abilities.
- Has base damage and an initial equipment set (bow, leather chestplate, and leather pants).
- Can perform basic attacks and a special (ultimate) attack that consumes mana.

### **2. Character**
- Abstract class representing a character in the game.
- Contains attributes such as strength, agility, mana, gold, experience, etc.
- Defines abstract methods like `attack`, `ultimate`, and `levelUp`.
- Manages the character’s inventory and equipment.

### **3. Chestplate**
- Represents an equippable chestplate.
- Provides defense and has a specific material.
- Implements methods to equip and unequip the chestplate.

### **4. Dragon**
- Represents a dragon-type enemy.
- Has base damage and a method to describe its stats.

### **5. Entity**
- Abstract class representing an entity in the game (characters, enemies, etc.).
- Contains attributes such as name, health, level, map coordinates, etc.
- Defines methods for movement and checking if the entity is alive.

### **6. Equipment**
- Abstract class representing an equipment item.
- Defines attributes such as name, required level, and cost.
- Implements methods to apply and remove equipment effects.

### **7. Main**
- Main class that starts the game.
- Manages the creation of the map, enemies, and allies.
- Controls the game flow, including player turns, shop interactions, and inventory management.

### **8. Missions**
- Contains missions that players can complete.
- Each mission has a reward, such as gold or experience.

### **9. Pants**
- Represents equippable pants.
- Provides defense and includes methods to equip and unequip them.

### **10. Warrior**
- Represents the Warrior class, specializing in melee combat.
- Implements the `Skill` interface for special abilities.
- Has base damage and an initial equipment set (basic sword, leather chestplate, and leather pants).
- Can perform basic attacks and a special attack (ultimate) called "Indomitable Will," which deals extra damage and consumes mana.
- The warrior has higher resistance and strength than other characters.

### **11. Weapon**
- Represents an equippable weapon.
- Weapons have specific types (swords, bows, staffs, and wands) and provide additional damage.
- Implements methods to equip and unequip weapons and manage inventory weapon swaps.
- Weapons have level requirements and associated costs, affecting the player's ability to purchase or equip them.

### **12. Wearable**
- Interface defining methods for equipping and unequipping items.
- Implemented by `Weapon`, `Chestplate`, and `Pants` to manage character equipment.

### **13. Witch**
- Represents a witch-type enemy.
- Has base damage and a method to describe its stats.
- Witches deal magic damage and have higher intelligence than other enemies.

### **14. Wizard**
- Represents the Wizard class, specializing in magic.
- Implements the `Skill` interface for special abilities.
- Has base damage and an initial equipment set (apprentice scepter, leather chestplate, and leather pants).
- Can perform basic attacks and a special attack (ultimate) called "Arcane Cataclysm," which deals massive magic damage and consumes mana.
- The wizard has a larger mana pool and can cast powerful spells.

### **15. World**
- Manages the game world, including map generation, enemy placement, and interactions.
- The world has defined dimensions (height and width) and a map representing entity locations.
- Includes methods to find nearby enemies, display the map, and manage the game state (alive allies, alive enemies, etc.).

### **16. Shop**
- Represents the in-game shop where players can buy weapons, chestplates, and pants.
- The shop has an inventory of available items, each with a required level and cost.
- Players can purchase and equip items if they have enough gold and meet the level requirements.
- The shop also manages missions related to equipment purchases.

### **17. Skill**
- Interface defining the `cast` and `description` methods for character special abilities.
- Implemented by `Archer`, `Warrior`, and `Wizard` to define their unique skills.

### **18. Troll**
- Represents a troll-type enemy.
- Has base damage and a method to describe its stats.
- Trolls are strong and durable enemies, ideal for melee combat.

## **Main Features**
- **Character Creation**: Players can create characters of different types (Warrior, Archer, Wizard) and customize their names.
- **Map Exploration**: Characters can move across a dynamically generated map.
- **Combat**: Characters can attack nearby enemies using basic attacks or special abilities.
- **Missions**: Players can complete missions to earn rewards.
- **Shop**: Players can buy weapons, chestplates, and pants from the shop.
- **Inventory**: Characters have an inventory to store and equip items.

## **Requirements**
- Java JDK 8 or higher.
- Basic knowledge of Java programming to understand and modify the code.

## **Contributions**
If you want to contribute to this project, you can do so via pull requests on GitHub. Any improvements, bug fixes, or new features are welcome.

## **License**
This project is licensed under the MIT License. See the `LICENSE` file for more details.

---
**Have fun playing!** 🎮
