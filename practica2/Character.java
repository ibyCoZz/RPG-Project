package practica2;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Character extends Entity{

    private final Scanner sc = new Scanner(System.in);
    Equipment[] build = new Equipment[3]; // Index 0 = weapon. Index 1 = chestplate. Index 2 = pants.
    private ArrayList<Equipment> inventory;
    private boolean[] missions;


    private int strength; // Points per level
    private int agility; // Points per level
    private int mana;
    private int gold;
    private final int range;
    private int xp;
    private int xpNeeded;
    private int maxMana;
    private final int ultManaCost;

    public Character(String name, int health, int level, int xCoordinate, int yCoordinate, int strength, int agility, int mana, int gold, int range, int maxMana, int ultManaCost) {
        super(name, health, level, xCoordinate, yCoordinate);
        this.strength = strength;
        this.agility = agility;
        this.mana = mana;
        this.gold = gold;
        this.range = range;
        this.maxMana = maxMana;
        this.ultManaCost = ultManaCost;
        this.xp = 0;
        this.xpNeeded = 100;
        inventory = new ArrayList<>();
        missions = new boolean[Missions.MISSIONS];
    }

    public abstract void attack(Entity enemy);

    public abstract void ultimate(Entity enemy);

    public abstract void levelUp();

public void showInventory(Character ally) {
    int index = 1;

    if (!inventory.isEmpty()) {
        for (Equipment equipment : inventory) {
            System.out.println(index + ". " + inventory.get(index - 1).getItemName());
            index++;
        }

        System.out.print("\n1. Equip item\n2. Exit inventory\nYour option: ");
        int option = sc.nextInt();

        if (option == 1) {
            System.out.print("Introduce item number: ");
            int itemIndex = sc.nextInt() - 1;



            if (inventory.get(itemIndex) instanceof Weapon) {
                Weapon.equipInventoryItem(inventory.get(itemIndex), ally);
            } else if (inventory.get(itemIndex) instanceof Chestplate) {
                Chestplate.equipInventoryItem(inventory.get(itemIndex), ally);
            } else {
                Pants.equipInventoryItem(inventory.get(itemIndex), ally);

            }
        }

    } else {
        System.out.println("\nInventory is empty.\n");
    }
}

    // Getters
    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getMana() {
        return mana;
    }

    public int getGold() {
        return gold;
    }

    public double getRange() {
        return range;
    }

    public int getXp() {
        return xp;
    }

    public int getXpNeeded() {
        return xpNeeded;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public ArrayList<Equipment> getInventory() {
        return inventory;
    }

    public int getUltManaCost() {
        return ultManaCost;
    }

    public boolean[] getMissions() {
        return missions;
    }

    // Setters
    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setXp(int xp) {
        this.xp += xp;
    }

    public void setXpNeeded(int xpNeeded) {
        this.xpNeeded += xpNeeded;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public void setInventory(ArrayList<Equipment> inventory) {
        this.inventory = inventory;
    }

    public void setMissions(boolean[] missions) {
        this.missions = missions;
    }
}

