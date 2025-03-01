package practica2;

import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final String[] enemyType = {"Troll", "Witch", "Dragon"};
    private static final String[] allyType = {"Warrior", "Archer", "Wizard"};

    public static void main(String[] args) {

        // Display game title
        System.out.println("""
                
                 ______                        _                ______             _           _     _             _                        \s
                (_____ \\                   _  (_)              (_____ \\           | |         (_)   | |           (_)                       \s
                 _____) )___ _____  ____ _| |_ _  ____ _____     ____) )_    _____| |    _   _ _  __| |_____  ___  _ _   _ _____  ____  ___ \s
                |  ____/ ___|____ |/ ___|_   _) |/ ___|____ |   / ____/(_)  | ___ | |   | | | | |/ _  | ___ |/ _ \\| | | | | ___ |/ _  |/ _ \\\s
                | |   | |   / ___ ( (___  | |_| ( (___/ ___ |  | (_____ _   | ____| |    \\ V /| ( (_| | ____| |_| | | |_| | ____( (_| | |_| |
                |_|   |_|   \\_____|\\____)  \\__)_|\\____)_____|  |_______|_)  |_____)\\_)    \\_/ |_|\\____|_____)\\___/| |____/|_____)\\___ |\\___/\s
                                                                                                                (__/            (_____|     \s
                """
        );
        // Start a new game
        newGame();
    }

    public static void newGame() {
        System.out.println("==================\nLet's create a new game.\n");

        // First step, map creation.
        int height = askForInt("Introduce map height: ");
        int width = askForInt("Introduce map width: ");
        World map = new World(height, width);

        // Creating enemies
        int enemies = askForInt("\nHow many enemies do you want? -> ");
        for (int i = 0; i < enemies; i++) {
            System.out.println();
            int index = 1;
            for (String e : enemyType) {
                System.out.println((index++) + ". " + e);
            }
            int input = askForInt("Introduce enemy number: ");
            map.generateCreature(enemyType[input - 1]);
        }

        // Creating allies
        System.out.println("Let's choose our allies");
        int allies = askForInt("How many allies do you want? -> ");
        for (int i = 0; i < allies; i++) {
            System.out.println();
            int index = 1;
            for (String e : allyType) {
                System.out.println((index++) + ". " + e);
            }
            int input = askForInt("Introduce enemy number: ");
            String name = askForString("Name your ally: ");
            map.generateAlly(allyType[input - 1], name);
        }

        // Start playing
        playGame(allies, map);
    }

    public static void playGame(int allies, World map) {

        Shop.createShop(); // Create the shop for items

        int turn = 1;
        while (true) {

            boolean alliesAlive = map.alliesAlive();
            boolean enemiesAlive = map.enemiesAlive();

            // End of the game and also new game option
            if (!alliesAlive || !enemiesAlive) {
                System.out.println(alliesAlive ? "\n - All enemies are dead. YOU WON!! - " : "\n - All your allies are dead - ");

                int newGameOpt;
                do {
                    newGameOpt = askForInt("\n1. New game\n2. Exit\nYour option: ");
                    if (newGameOpt == 1) {
                        newGame();
                    } else if (newGameOpt == 2) {
                        System.out.println("Thanks for playing.");
                        return;
                    } else {
                        System.out.println("Invalid option");
                    }
                } while (newGameOpt != 1);
            }

            Entity ignoreAlly = null;

            // Iterate through the map
            for (int i = 0; i < map.getMap().length; i++) {
                for (int j = 0; j < map.getMap()[i].length; j++) {
                    if (map.getMap()[i][j] instanceof Character && (map.getMap()[i][j] != ignoreAlly || allies == 1)) {

                        // Restore mana if not at max
                        if (((Character) map.getMap()[i][j]).getMana() < ((Character) map.getMap()[i][j]).getMaxMana()) {
                            ((Character) map.getMap()[i][j]).setMana(((Character) map.getMap()[i][j]).getMana() + 1);
                        }

                        map.showMap(map.getMap()[i][j]);

                        System.out.println("Turn " + turn);
                        System.out.println(map.getMap()[i][j].getName() + "'s turn\n");
                        map.nearEnemy(map.getMap()[i][j]);
                        boolean turnAction = true;
                        while (turnAction) {
                            int option = askForInt("1. Move\n2. Attack\n3. Describe\n4. Shop\n5. Inventory\nYour option: ");

                            switch (option) {
                                case 1:
                                    // Move character
                                    System.out.println("\nUse W/A/S/D to move.");
                                    for (int k = 0; k < 1; k++) {
                                        System.out.println("Remaining moves: " + (2 - k));
                                        String movementDirection = askForString("Move nº" + (k + 1) + ": ").toLowerCase();

                                        if (movementDirection.equalsIgnoreCase("w") || movementDirection.equalsIgnoreCase("s") || movementDirection.equalsIgnoreCase("a") || movementDirection.equalsIgnoreCase("d")) {
                                            ignoreAlly = map.getMap()[i][j];
                                        }

                                        switch (movementDirection) {
                                            case "w" -> map.getMap()[i][j].moveUp(map.getMap()[i][j], map);
                                            case "a" -> map.getMap()[i][j].moveLeft(map.getMap()[i][j], map);
                                            case "s" -> map.getMap()[i][j].moveDown(map.getMap()[i][j], map);
                                            case "d" -> map.getMap()[i][j].moveRight(map.getMap()[i][j], map);
                                            default -> {
                                                System.out.println("Invalid option.");
                                                k--;
                                            }
                                        }
                                    }

                                    turnAction = false;
                                    break;
                                case 2:
                                    // Attack an enemy
                                    Entity enemy = map.fightEnemyMenu(map.getMap()[i][j], ((Character) map.getMap()[i][j]).getRange());
                                    if (enemy != null) {
                                        int attOption = askForInt("\n1. Basic attack\n2. Ultimate\nEnter an option: ");
                                        if (attOption == 1) { // Basic attack
                                            ((Character) map.getMap()[i][j]).attack(enemy);
                                            if (!map.getMap()[i][j].isAlive()) { // Deletes ally if true
                                                System.out.println(map.getMap()[i][j].getName() + " have been slain by a " + enemy.getName());
                                                map.getMap()[i][j] = null;
                                            }
                                            if (!enemy.isAlive()) { // Deletes dead enemy if true
                                                map.getMap()[enemy.getyCoordinate()][enemy.getxCoordinate()] = null;
                                            }
                                        } else if (attOption == 2) { // Ultimate attack
                                            if (((Character) map.getMap()[i][j]).getUltManaCost() < ((Character) map.getMap()[i][j]).getMana()) {
                                                ((Character) map.getMap()[i][j]).ultimate(enemy);
                                                if (!map.getMap()[i][j].isAlive()) { // Deletes ally if true
                                                    System.out.println(map.getMap()[i][j].getName() + " have been slain by a " + enemy.getName());
                                                    map.getMap()[i][j] = null;
                                                }
                                                if (!enemy.isAlive()) { // Deletes dead enemy if true
                                                    map.getMap()[enemy.getyCoordinate()][enemy.getxCoordinate()] = null;
                                                }
                                            } else {
                                                System.out.println("You don't have enough mana for this action.");
                                            }
                                        } else {
                                            System.out.println("Invalid option.");
                                            continue;
                                        }
                                        turnAction = false;
                                        break;
                                    } else {
                                        System.out.println("No enemies nearby.");
                                        continue;
                                    }
                                case 3:
                                    // Describe character
                                    map.getMap()[i][j].describe();
                                    break;
                                case 4:
                                    // Shop interaction
                                    int shopOption = askForInt("\n1. Weapons\n2. Chesplates\n3. Pants\nYour option: ");

                                    switch (shopOption) {
                                        case 1:
                                            Shop.showWeapons((Character) map.getMap()[i][j]);
                                            continue;
                                        case 2:
                                            Shop.showChestplates((Character) map.getMap()[i][j]);
                                            continue;
                                        case 3:
                                            Shop.showPants((Character) map.getMap()[i][j]);
                                            continue;
                                        default:
                                            System.out.println("Invalid option");
                                            continue;
                                    }
                                case 5:
                                    // Show inventory
                                    ((Character) map.getMap()[i][j]).showInventory((Character) map.getMap()[i][j]);
                                    continue;
                                default:
                                    System.out.println("Invalid option.");
                            }
                        }
                        turn++;
                    }
                }
            }
        }
    }

    // Console String request
    public static String askForString(String text) {
        System.out.print(text);
        while (true) {
            try {
                return sc.next();
            } catch (RuntimeException e) {
                System.out.println("\nInvalid option.\n");
                askForString(text);
            }
        }

    }

    // Console int request
    public static int askForInt(String text) {
        System.out.print(text);
        while (true) {
            try {
                return sc.nextInt();
            } catch (RuntimeException e) {
                System.out.println("\nInvalid option.\n");
                askForInt(text);
            }
        }
    }
}
