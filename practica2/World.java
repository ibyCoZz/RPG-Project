package practica2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class World {

    private final int height;
    private final int width;
    private final Entity[][] map;

    // Constructor to initialize the world with given dimensions
    public World(int height, int width) {
        this.height = height;
        this.width = width;
        this.map = new Entity[height][width];
    }

    // Generates a random enemy (Troll, Witch, or Dragon) and places it on the map
    public void generateCreature(String type) {
        Random rand = new Random();
        while (true) {
            int x = rand.nextInt(width);
            int y = rand.nextInt(height);
            if (map[y][x] == null) {
                if (type.equals("Troll")) {
                    Troll troll = new Troll("Troll", 100, rand.nextInt(20), x, y);
                    map[y][x] = troll;
                } else if (type.equals("Witch")) {
                    Witch witch = new Witch("Witch", 100, rand.nextInt(35), x, y);
                    map[y][x] = witch;
                } else {
                    Dragon dragon = new Dragon("Dragon", 150, rand.nextInt(55), x, y);
                    map[y][x] = dragon;
                }
                map[y][x].describe();
                return;
            }
        }
    }

    // Generates an ally (Warrior, Archer, or Wizard) and places it on the map
    public void generateAlly(String type, String name) {
        Random rand = new Random();
        while (true) {
            int x = rand.nextInt(width);
            int y = rand.nextInt(height);
            if (map[y][x] == null) {
                if (type.equals("Warrior")) {
                    Warrior warrior = new Warrior(name, 100, 1, x, y, rand.nextInt(10), rand.nextInt(10), 5, 0, 1, 5, 4);
                    map[y][x] = warrior;
                } else if (type.equals("Archer")) {
                    Archer archer = new Archer(name, 100, 1, x, y, rand.nextInt(10), rand.nextInt(10), 10, 0, 3, 10, 8);
                    map[y][x] = archer;
                } else {
                    Wizard wizard = new Wizard(name, 100, 1, x, y, rand.nextInt(10), rand.nextInt(10), 15, 0, 2, 15, 12);
                    map[y][x] = wizard;
                }
                map[y][x].describe();
                return;
            }
        }
    }

    // Finds the closest enemy to a given entity
    public void nearEnemy(Entity entity) {

        Entity closestEnemy = null;
        double minDistance = Double.MAX_VALUE;

        for (Entity[] entities : map) {
            for (Entity value : entities) {
                if (value instanceof Troll || value instanceof Witch || value instanceof Dragon) {

                    // Distance to our character
                    double distance = Math.sqrt(Math.pow(value.getxCoordinate() - entity.getxCoordinate(), 2) +
                            Math.pow(value.getyCoordinate() - entity.getyCoordinate(), 2));

                    if (distance < minDistance) {
                        minDistance = distance;
                        closestEnemy = value;
                    }
                }
            }
        }

        double roundedDistance = Math.round(minDistance * 100.0) / 100.0;

        if (closestEnemy != null) {
            System.out.println("The closest enemy is " + closestEnemy.getName() +
                    " at distance " + roundedDistance + "(" + closestEnemy.getxCoordinate() + ", " + closestEnemy.getyCoordinate() + ")" +
                    "\nYour position: (" + entity.getxCoordinate() + ", " + entity.getyCoordinate() + ")\n");
        } else {
            System.out.println("No enemies found.");
        }
    }

    // Displays a menu to fight an enemy within a given range
    public Entity fightEnemyMenu(Entity entity, double range) {

        ArrayList<Entity> nearEnemies = new ArrayList<>();

        for (Entity[] entities : map) {
            for (Entity value : entities) {
                if (value instanceof Troll || value instanceof Witch || value instanceof Dragon) {

                    // Distance to our character
                    double distance = Math.sqrt(Math.pow(value.getxCoordinate() - entity.getxCoordinate(), 2) +
                            Math.pow(value.getyCoordinate() - entity.getyCoordinate(), 2));

                    if (distance <= range) {
                        nearEnemies.add(value);
                    }
                }
            }
        }

        if (!nearEnemies.isEmpty()) {
            int index = 1;
            for (Entity enemy : nearEnemies) {
                System.out.println(index + ". " + enemy.getName());
                index++;
            }
            while (true) {
                System.out.print("Introduce a number (1-" + (index - 1) + "): ");
                int enemyOption = (new Scanner(System.in).nextInt());
                if (enemyOption < index && enemyOption > 0) {
                    return nearEnemies.get(enemyOption - 1);
                } else {
                    System.out.println("\nInvalid option.");
                }
            }
        } else {
            return null;
        }
    }

    // Displays the current state of the map
    public void showMap(Entity you) {
        System.out.println("\n============= MAP =============\n");
        for (Entity[] entities : map) {
            for (Entity entity : entities) {
                if (entity == null) {
                    System.out.print(" - ");
                } else if (entity instanceof Troll || entity instanceof Witch || entity instanceof Dragon) {
                    System.out.print(" E ");
                } else if (entity instanceof Character) {
                    if (entity == you) {
                        System.out.print("[A]");
                    } else {
                        System.out.print(" A ");
                    }
                }
            }
            System.out.println();
        }
        System.out.println("\n=============\n");
    }

    public boolean alliesAlive() {

        for (Entity[] entities : map) {
            for (Entity entity : entities) {
                if (entity instanceof Warrior || entity instanceof Archer || entity instanceof Wizard) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean enemiesAlive() {

        for (Entity[] entities : map) {
            for (Entity entity : entities) {
                if (entity instanceof Troll || entity instanceof Witch || entity instanceof Dragon) {
                    return true;
                }
            }
        }
        return false;
    }

    // Returns the map of entities
    public Entity[][] getMap() {
        return map;
    }
}
