package practica2;

public class Pants extends Equipment{

    private final int defense;

    public Pants(String itemName, int levelRequired, int defense, int cost) {
        super(itemName, levelRequired, cost);
        this.defense = defense;
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
            Pants pants = (Pants) ((Warrior)ally).getEquipment().get(2);
            ((Warrior) ally).getEquipment().set(2, item);
            unequip(pants, ally, 2);
        } else if (ally instanceof Archer) {
            Pants pants = (Pants) ((Archer)ally).getEquipment().get(2);
            ((Archer) ally).getEquipment().set(2, item);
            unequip(pants, ally, 2);
        } else if (ally instanceof Wizard) {
            Pants pants = (Pants) ((Wizard)ally).getEquipment().get(2);
            ((Wizard) ally).getEquipment().set(2, item);
            unequip(pants, ally, 2);
        }
        System.out.println(item.getItemName() + " has been equipped.");
    }

    @Override
    public void unequip(Equipment item, Character ally, int index) {
        ally.getInventory().add(item);
    }


    public static void equipInventoryItem(Equipment item, Character ally) { // Future changes: this must a Wearable interface method
        if (ally instanceof Warrior) {
            Equipment equippedItem = ((Warrior) ally).getEquipment().get(2);
            ((Warrior) ally).getEquipment().set(2, item);
            ally.getInventory().set(ally.getInventory().indexOf(item), equippedItem);
        } else if (ally instanceof Archer) {
            Equipment equippedItem = ((Archer) ally).getEquipment().get(2);
            ((Archer) ally).getEquipment().set(2, item);
            ally.getInventory().set(ally.getInventory().indexOf(item), equippedItem);
        } else if (ally instanceof  Wizard) {
            Equipment equippedItem = ((Wizard) ally).getEquipment().get(2);
            ((Wizard) ally).getEquipment().set(2, item);
            ally.getInventory().set(ally.getInventory().indexOf(item), equippedItem);
        }
        System.out.println(item.getItemName() + " has been equipped.");
    }

    public int getDefense() {
        return defense;
    }
}
