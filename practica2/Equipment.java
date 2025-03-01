package practica2;

public abstract class Equipment implements Wearable {

    private String itemName;
    private int levelRequired;
    private int cost;

    public Equipment(String itemName, int levelRequired, int cost) {
        this.itemName = itemName;
        this.levelRequired = levelRequired;
        this.cost = cost;
    }

    public abstract void applyEffect();

    public abstract void removeEffect();

    public String getItemName() {
        return itemName;
    }

    public int getLevelRequired() {
        return levelRequired;
    }

    public int getCost() {
        return cost;
    }
}
