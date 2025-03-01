package practica2;

import java.util.ArrayList;

public class Warrior extends Character implements Skill{

    private final int BASE_DAMAGE; // Base damage for the Warrior
    private ArrayList<Equipment> equipment; // List of equipment items

    // Constructor for the Warrior class
    public Warrior(String name, int health, int level, int xCoordinate, int yCoordinate, int strength, int agility, int mana, int gold, int range, int maxMana, int ultManaCost) {
        super(name, health, level, xCoordinate, yCoordinate, strength, agility, mana, gold, range, maxMana, ultManaCost);
        this.BASE_DAMAGE = 15;
        this.equipment = new ArrayList<>();

        // Initializing the default equipment
        this.equipment.add(new Weapon("Basic Sword", 1, 5, "Sword", 0));
        this.equipment.add(new Chestplate("Leather cuirass", 1, 3, "Leather", 0));
        this.equipment.add(new Pants("Leather pants", 1, 2, 0));
    }

    @Override
    public void attack(Entity enemy) {

        // Calculate the attack damage
        int allyDamage = (((Weapon)equipment.getFirst()).getExtraDamage() + BASE_DAMAGE + getStrength()); // falta fuerza

        // Apply damage to the enemy
        enemy.setHealth(enemy.getHealth() - allyDamage);
        System.out.println("You've done " + allyDamage + " damage to " + enemy.getName() + "(" + enemy.getHealth() + " hp)");

        // If the enemy is still alive, it counterattacks
        if (enemy.isAlive()) {
            if (enemy instanceof Troll) { // Troll counterattack
                setHealth(getHealth() - ((((Troll)enemy).getBASE_DAMAGE() + enemy.getLevel()) - (((Chestplate)equipment.get(1)).getDefense() + ((Pants)equipment.get(2)).getDefense())));
                System.out.println(enemy.getName() + " deals " + (((Troll)enemy).getBASE_DAMAGE() + enemy.getLevel()) + " to " + getName());
            } else if (enemy instanceof Witch) { // Witch counterattack
                setHealth(getHealth() - ((((Witch)enemy).getBASE_DAMAGE() + enemy.getLevel()) - (((Chestplate)equipment.get(1)).getDefense() + ((Pants)equipment.get(2)).getDefense())));
                System.out.println(enemy.getName() + " deals " + (((Witch)enemy).getBASE_DAMAGE() + enemy.getLevel()) + " to " + getName());
            } else { // Dragon counterattack
                setHealth(getHealth() - ((((Dragon)enemy).getBASE_DAMAGE() + enemy.getLevel()) - (((Chestplate)equipment.get(1)).getDefense() + ((Pants)equipment.get(2)).getDefense())));
                System.out.println(enemy.getName() + " deals " + (((Dragon)enemy).getBASE_DAMAGE() + enemy.getLevel()) + " to " + getName());
            }
        } else {
            // Enemy defeated, grant rewards
            System.out.println("You have slain " + enemy.getName());

            if (enemy instanceof Troll) {
                System.out.println("You gained 50xp and 150 gold.");

                if (!getMissions()[0]) {
                    Missions.killTroll(getMissions());
                    setGold(getGold() + 200);
                }
                setGold(getGold() +  150);
                setXp(50);
            } else if (enemy instanceof Witch) {
                System.out.println("You gained 75xp and 200 gold.");

                if (!getMissions()[1]) {
                    Missions.killWitch(getMissions());
                    setGold(getGold() + 250);

                }
                setGold(getGold() + 200);
                setXp(75);
            } else {

                if (!getMissions()[2]) {
                    Missions.killDragon(getMissions());
                    setGold(getGold() + 300);

                }
                System.out.println("You gained 100xp and 300 gold.");
                setGold(getGold() + 300);
                setXp(100);
            }

            // Level up if XP is sufficient
            if (getXp() > getXpNeeded()) {
                levelUp();
            }
        }
    }

    @Override
    public void ultimate(Entity enemy) {
        System.out.println("Indomitable Will...");

        int INDOMITABLE_WILL_ULTIMATE_DAMAGE = 30;
        int allyDamage = (((Weapon)equipment.getFirst()).getExtraDamage() + BASE_DAMAGE + (INDOMITABLE_WILL_ULTIMATE_DAMAGE + getLevel()));

        // Apply ultimate ability damage to the enemy
        enemy.setHealth(enemy.getHealth() - allyDamage);
        System.out.println("You've done " + allyDamage + " damage to " + enemy.getName() + "(" + enemy.getHealth() + " hp)");

        // Consume mana for the ultimate ability
        setMana(getMana() - getUltManaCost());

        // Check if the enemy is still alive or defeated
        if (enemy.isAlive()) {
            // Counterattack from the enemy
            if (enemy instanceof Troll) {
                setHealth(getHealth() - ((((Troll)enemy).getBASE_DAMAGE() + enemy.getLevel()) - (((Chestplate)equipment.get(1)).getDefense() + ((Pants)equipment.get(2)).getDefense())));
                System.out.println(enemy.getName() + " deals " + (((Troll)enemy).getBASE_DAMAGE() + enemy.getLevel()) + " to " + getName());
            } else if (enemy instanceof Witch) {
                setHealth(getHealth() - ((((Witch)enemy).getBASE_DAMAGE() + enemy.getLevel()) - (((Chestplate)equipment.get(1)).getDefense() + ((Pants)equipment.get(2)).getDefense())));
                System.out.println(enemy.getName() + " deals " + (((Witch)enemy).getBASE_DAMAGE() + enemy.getLevel()) + " to " + getName());
            } else {
                setHealth(getHealth() - ((((Dragon)enemy).getBASE_DAMAGE() + enemy.getLevel()) - (((Chestplate)equipment.get(1)).getDefense() + ((Pants)equipment.get(2)).getDefense())));
                System.out.println(enemy.getName() + " deals " + (((Dragon)enemy).getBASE_DAMAGE() + enemy.getLevel()) + " to " + getName());
            }
        } else {
            System.out.println("You have slain " + enemy.getName());

            if (enemy instanceof Troll) {
                System.out.println("You gained 50xp and 150 gold.");
                if (!getMissions()[0]) {
                    Missions.killTroll(getMissions());
                    setGold(getGold() + 200);
                }
                setGold(getGold() +  150);
                setXp(50);
            } else if (enemy instanceof Witch) {
                System.out.println("You gained 75xp and 200 gold.");

                if (!getMissions()[1]) {
                    Missions.killWitch(getMissions());
                    setGold(getGold() + 250);

                }
                setGold(getGold() + 200);
                setXp(75);
            } else {
                System.out.println("You gained 100xp and 300 gold.");

                if (!getMissions()[2]) {
                    Missions.killDragon(getMissions());
                    setGold(getGold() + 300);

                }
                setGold(getGold() + 300);
                setXp(100);
            }

            if (getXp() > getXpNeeded()) {
                levelUp();
            }
        }
    }

    @Override
    public void levelUp() {
        // Increase level and attributes when leveling up

        setLevel(getLevel() + 1);
        setHealth(100 + 5*getLevel());
        setGold(getGold() + 100);
        setMaxMana(getMaxMana() + 1);
        setXpNeeded(10);
        setXp(getXp() - getXpNeeded());
        setStrength(getStrength() + 1);

        System.out.println("\nLevel " + getLevel() + " reached!");

        if (getLevel() == 5) {
            Missions.reachLvL5(getMissions());
            setGold(getGold() + 200);
        }

    }

    @Override
    public void describe() { // Print character description and stats
        System.out.println("---------------------------------------------------------\n");
        System.out.println("      _,.\n" +
                "    ,` -.)\n" +
                "   ( _/-\\\\-._\n" +
                "  /,|`--._,-^|            ,\n" +
                "  \\_| |`-._/||          ,'|\n" +
                "    |  `-, / |         /  /\n" +
                "    |     || |        /  /\n" +
                "     `r-._||/   __   /  /\n" +
                " __,-<_     )`-/  `./  /\n" +
                "'  \\   `---'   \\   /  /\n" +
                "    |           |./  /\n" +
                "    /           //  /\n" +
                "\\_/' \\         |/  /\n" +
                " |    |   _,^-'/  /\n" +
                " |    , ``  (\\/  /_\n" +
                "  \\,.->._    \\X-=/^\n" +
                "  (  /   `-._//^`\n" +
                "   `Y-.____(__}\n" +
                "    |     {__)\n" +
                "          ()\n\n" +
                "============ STATS ============\n" +
                "Name: " + getName() +
                "\nHealth: " + getHealth() +
                "\nLevel: " + getLevel() +
                "\nStrength: " + getStrength() +
                "\nAgility: " + + getAgility() +
                "\nMana: " + getMana() +
                "\nGold: " + getGold() +
                "\nRange: " + getRange() +
                "\nXP: " + getXp());
        System.out.println("\n---------------------------------------------------------");
    }

    // Getter for the equipment list
    public ArrayList<Equipment> getEquipment() {
        return equipment;
    }

    @Override
    public void cast() {

    }

    @Override
    public void description() {

    }
}
