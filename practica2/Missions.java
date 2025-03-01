package practica2;

import java.util.ArrayList;

public class Missions {

    protected static final int MISSIONS = 7;

    // Mission 0
    public static void killTroll(boolean[] array) {
        array[0] = true;
        System.out.println("\nMission completed: kill a troll (+200 gold).\n");
    }

    // Mission 1
    public static void killWitch(boolean[] array) {
        array[1] = true;
        System.out.println("\nMission completed: kill a witch (+250 gold).\n");
    }

    // Mission 2
    public static void killDragon(boolean[] array) {
        array[2] = true;
        System.out.println("\nMission completed: kill a dragon (+300 gold).\n");
    }

    // Mission 3
    public static void reachLvL5(boolean[] array) {
        array[3] = true;
        System.out.println("\nMission completed: level 5 reached (+200 gold).\n");
    }

    // Mission 4
    public static void buyWeapon(boolean[] array) {
        array[4] = true;
        System.out.println("\nMission completed: you have bought a weapon (+75 xp)");
    }

    // Mission 5
    public static void buyChestplate(boolean[] array) {
        array[5] = true;
        System.out.println("\nMission completed: you have bought a chestplate (+75 xp)");
    }

    // Mission 6
    public static void buyPants(boolean[] array) {
        array[6] = true;
        System.out.println("\nMission completed: you have bought a pants (+75 xp)");

    }
}
