package practica2;

import java.util.ArrayList;

public class Wizard extends Character implements Skill{

    private final int BASE_DAMAGE;
    private ArrayList<Equipment> equipment;

    public Wizard(String name, int health, int level, int xCoordinate, int yCoordinate, int strength, int agility, int mana, int gold, int range, int maxMana, int ultManaCost) {
        super(name, health, level, xCoordinate, yCoordinate, strength, agility, mana, gold, range, maxMana, ultManaCost);
        this.BASE_DAMAGE = 9;
        this.equipment = new ArrayList<>();
        this.equipment.add(new Weapon("Apprentice scepter", 1, 5, "Staffs & Wands", 0));
        this.equipment.add(new Chestplate("Leather cuirass", 1, 3, "Leather",0));
        this.equipment.add(new Pants("Leather pants", 1, 2, 0));
    }

    @Override
    public void attack(Entity enemy) {
        int allyDamage = (((Weapon)equipment.getFirst()).getExtraDamage() + BASE_DAMAGE);

        enemy.setHealth(enemy.getHealth() - allyDamage);
        System.out.println("You've done " + allyDamage + " damage to " + enemy.getName() + "(" + enemy.getHealth() + " hp)");

        if (enemy.isAlive()) {
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

    // Ultimate ability with increased damage
    @Override
    public void ultimate(Entity enemy) {
        System.out.println("Arcane Cataclysm...");

        int ARCANE_CATACLYSM_ULTIMATE_DAMAGE = 35;
        int allyDamage = (((Weapon)equipment.getFirst()).getExtraDamage() + BASE_DAMAGE + (ARCANE_CATACLYSM_ULTIMATE_DAMAGE + getLevel()));

        enemy.setHealth(enemy.getHealth() - allyDamage);
        System.out.println("You've done " + allyDamage + " damage to " + enemy.getName() + "(" + enemy.getHealth() + " hp)");

        setMana(getMana() - getUltManaCost());

        if (enemy.isAlive()) {
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
        setLevel(getLevel() + 1);
        setHealth(100 + 3*getLevel());
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
    public void describe() {
        System.out.println("---------------------------------------------------------\n");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠌⠀⠈⠐⠠⢀⡀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡠⠂⠀⠀⠈⢂⠀⠀⠀⠉⠒⢄⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠔⠁⠀⠀⠀⠀⠈⢎⠉⠉⠉⢢⠈⡆\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡔⠚⠒⠒⠒⠒⠒⠒⠒⠚⠒⡀⠀⠀⠡⡇\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠲⣒⠒⠐⠃⠀⠒⣒⣈⣉⣉⢁⣐⣒⢒⠃⣠⠖⠂⠀\n" +
                "⠀⠀⢠⠢⡀⠀⠀⠀⠀⠉⡹⡙⠉⠀⣤⡀⠀⠀⢀⠄⠀⢰⢱⠀⠀⠀⠀\n" +
                "⢠⣴⣺⠀⢩⠝⠋⠀⠀⠀⡇⠃⠀⠈⠋⠀⠀⠀⠘⠃⠀⡸⢠⠀⠀⠀⠀\n" +
                "⠀⠀⣮⢾⢲⠧⠀⠀⠀⠀⢱⠘⠄⠒⠉⣀⠀⢈⡍⠑⠒⠃⡜⠀⠀⠀⠀\n" +
                "⠀⠀⠈⠘⡜⠀⠀⠀⠀⠀⠀⢂⠀⠀⠀⠀⠉⠁⠀⠀⠀⡰⠁⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⢱⢣⠀⠀⠀⠀⠀⡨⢢⠀⠀⠀⠀⠀⠀⠀⣰⢣⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⢠⣟⣒⢄⠀⢀⠜⠁⢸⠀⠢⣀⠀⣀⠤⠊⠈⠀⢆⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⣿⣿⡼⠉⠉⠀⢠⡏⠀⠀⠀⠈⠀⠀⠀⠀⡄⠈⡀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠈⠇⢫⠐⠂⠴⠃⠃⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⢃⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠸⡬⠄⠀⠀⢸⠒⠀⠠⠤⠤⠤⠀⠀⠐⡏⢩⠃⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡌⠀⠒⠒⠒⠒⠒⠒⠒⠈⢩⠁⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠣⣀⠀⠀⠀⠀⠀⠀⠀⢀⣸⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀\n\n" +
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
