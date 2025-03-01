package practica2;

public interface Wearable {

    void equip(Equipment item, Character ally, String type);
    void unequip(Equipment item, Character ally, int index);
}
