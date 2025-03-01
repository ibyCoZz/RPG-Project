package practica2;

public class Weapon extends Equipment{

    private final int extraDamage;
    private final String weaponType;

    public Weapon(String itemName, int levelRequired, int extraDamage, String weaponType, int cost) {
        super(itemName, levelRequired, cost);
        this.extraDamage = extraDamage;
        this.weaponType = weaponType;
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
            Weapon weapon = (Weapon) ((Warrior)ally).getEquipment().getFirst();
            ((Warrior) ally).getEquipment().set(0, item);
            unequip(weapon, ally, 0);
        } else if (ally instanceof Archer) {
            Weapon weapon = (Weapon) ((Archer)ally).getEquipment().getFirst();
            ((Archer) ally).getEquipment().set(0, item);
            unequip(weapon, ally, 0);
        } else if (ally instanceof Wizard) {
            Weapon weapon = (Weapon) ((Wizard)ally).getEquipment().getFirst();
            ((Wizard) ally).getEquipment().set(0, item);
            unequip(weapon, ally, 0);
        }
        System.out.println(item.getItemName() + " has been equipped.");
    }

    @Override
    public void unequip(Equipment item, Character ally, int index) {
        ally.getInventory().add(index, item);
    }

    public static void equipInventoryItem(Equipment item, Character ally) { // REMINDER: this must a Wearable interface method

        if (ally instanceof Warrior) {
            Equipment equippedItem = ((Warrior) ally).getEquipment().getFirst();
            ((Warrior) ally).getEquipment().set(0, item);
            ally.getInventory().set(ally.getInventory().indexOf(item), equippedItem);
        } else if (ally instanceof Archer) {
            Equipment equippedItem = ((Archer) ally).getEquipment().getFirst();
            ((Archer) ally).getEquipment().set(0, item);
            ally.getInventory().set(ally.getInventory().indexOf(item), equippedItem);
        } else if (ally instanceof  Wizard) {
            Equipment equippedItem = ((Wizard) ally).getEquipment().getFirst();
            ((Wizard) ally).getEquipment().set(0, item);
            ally.getInventory().set(ally.getInventory().indexOf(item), equippedItem);
        }
        System.out.println(item.getItemName() + " has been equipped.");
    }

    public int getExtraDamage() {
        return extraDamage;
    }

    public String getWeaponType() {
        return weaponType;
    }
}
