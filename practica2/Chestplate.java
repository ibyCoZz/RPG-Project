package practica2;

import java.time.chrono.AbstractChronology;

public class Chestplate extends Equipment{

    private final int defense;
    private int durability; // Optional here and can also be super attribute
    private final String material;

    public Chestplate(String itemName, int levelRequired, int defense, String material, int cost) {
        super(itemName, levelRequired, cost);
        this.defense = defense;
        this.material = material;
    }

    @Override
    public void applyEffect() {

    }

    @Override
    public void removeEffect() {

    }

    @Override
    public void equip(Equipment item, Character ally, String type) {
        if (ally instanceof Warrior) {
            Chestplate chestplate = (Chestplate) ((Warrior)ally).getEquipment().get(1);
            ((Warrior) ally).getEquipment().set(1, item);
            unequip(chestplate, ally, 1);
        } else if (ally instanceof Archer) {
            Chestplate chestplate = (Chestplate) ((Archer)ally).getEquipment().get(1);
            ((Archer) ally).getEquipment().set(1, item);
            unequip(chestplate, ally, 1);
        } else if (ally instanceof Wizard) {
            Chestplate chestplate = (Chestplate) ((Wizard)ally).getEquipment().get(1);
            ((Wizard) ally).getEquipment().set(1, item);
            unequip(chestplate, ally, 1);
        }
        System.out.println(item.getItemName() + " has been equipped.");
    }

    @Override
    public void unequip(Equipment item, Character ally, int index) {
        ally.getInventory().add(item);
    }

    public static void equipInventoryItem(Equipment item, Character ally) { // Future changes: this must a Wearable interface method
        if (ally instanceof Warrior) {
            Equipment equippedItem = ((Warrior) ally).getEquipment().get(1);
            ((Warrior) ally).getEquipment().set(1, item);
            ally.getInventory().set(ally.getInventory().indexOf(item), equippedItem);
        } else if (ally instanceof Archer) {
            Equipment equippedItem = ((Archer) ally).getEquipment().get(1);
            ((Archer) ally).getEquipment().set(1, item);
            ally.getInventory().set(ally.getInventory().indexOf(item), equippedItem);
        } else if (ally instanceof  Wizard) {
            Equipment equippedItem = ((Wizard) ally).getEquipment().get(1);
            ((Wizard) ally).getEquipment().set(1, item);
            ally.getInventory().set(ally.getInventory().indexOf(item), equippedItem);
        }
        System.out.println(item.getItemName() + " has been equipped.");
    }

    public int getDefense() {
        return defense;
    }

    public String getMaterial() {
        return material;
    }
}
