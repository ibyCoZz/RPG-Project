package practica2;

import java.util.ArrayList;
import java.util.Scanner;

public class  Shop {

    private static final Scanner sc = new Scanner(System.in);

    private static final ArrayList<Weapon> weapons = new ArrayList<>();
    private static final ArrayList<Chestplate> chestplates = new ArrayList<>();
    private static final ArrayList<Pants> pants = new ArrayList<>();

    public static void createShop() {

        // Weapons ---------------------

        // Swords
        Weapon doomfang = new Weapon("Doomfang", 0, 7, "Sword", 0);
        Weapon nightfall  = new Weapon("Nightfall ", 3, 10, "Sword", 150);
        Weapon stormRender  = new Weapon("Storm render ", 4, 14, "Sword", 200);
        Weapon bloodFang = new Weapon("Blood fang ", 5, 16, "Sword", 250);
        Weapon shadowFang = new Weapon("Shadow fang ", 6, 17, "Sword", 300);
        Weapon celestialEdge = new Weapon("Celestial Edge ", 7, 20, "Sword", 350);
        Weapon eclipseBlade = new Weapon("Eclipse Blade ", 8, 24, "Sword", 400);
        Weapon infernalFang = new Weapon("Infernal Fang ", 9, 26, "Sword", 450);

        weapons.add(doomfang);
        weapons.add(nightfall);
        weapons.add(stormRender);
        weapons.add(bloodFang);
        weapons.add(shadowFang);
        weapons.add(celestialEdge);
        weapons.add(eclipseBlade);
        weapons.add(infernalFang);

        // Bows
        Weapon silentReaper = new Weapon("Silent Reaper", 0, 7, "Bow", 0);
        Weapon moonPiercer = new Weapon("Moon Piercer ", 3, 10, "Bow", 150);
        Weapon stormShot = new Weapon("Storm shot", 4, 13, "Bow", 200);
        Weapon widowsCry = new Weapon("Widow’s Cry", 5, 15, "Bow", 250);
        Weapon duskFang = new Weapon("Dusk fang", 6, 18, "Bow", 350);
        Weapon skyShatter = new Weapon("Sky shatter", 7, 20, "Bow", 400);
        Weapon phoenixString = new Weapon("Phoenix String", 8, 23, "Bow", 450);

        weapons.add(silentReaper);
        weapons.add(moonPiercer);
        weapons.add(stormShot);
        weapons.add(widowsCry);
        weapons.add(duskFang);
        weapons.add(skyShatter);
        weapons.add(phoenixString);

        // Staffs & Wands
        Weapon voidCaller = new Weapon("Void caller", 0, 7, "Staffs & Wands", 0);
        Weapon eldritchWhisper = new Weapon("Eldritch Whisper", 6, 10, "Staffs & Wands", 150);
        Weapon starBinder = new Weapon("Star binder", 3, 12, "Staffs & Wands", 200);
        Weapon runeBringer = new Weapon("Rune bringer", 4, 16, "Staffs & Wands", 250);
        Weapon arcaneNova = new Weapon("Arcane Nova", 5, 19, "Staffs & Wands", 300);
        Weapon frostHeart = new Weapon("Frost heart", 6, 21, "Staffs & Wands", 350);
        Weapon emberLight = new Weapon("Ember light", 7, 27, "Staffs & Wands", 400);

        weapons.add(voidCaller);
        weapons.add(eldritchWhisper);
        weapons.add(starBinder);
        weapons.add(runeBringer);
        weapons.add(arcaneNova);
        weapons.add(frostHeart);
        weapons.add(emberLight);

        // Chestplate ---------------------
        Chestplate aegisOfTheFallen = new Chestplate("Aegis of the Fallen", 0, 5, "Iron", 0);
        Chestplate shadowedBreastplate = new Chestplate("Shadowed Breastplate", 3, 7, "Dark steel", 150);
        Chestplate celestialArmor = new Chestplate("Celestial Armor", 4, 8, "Gold", 200);
        Chestplate dragonScalePlate = new Chestplate("Dragon Scale Plate", 5, 9, "Dragon Scales", 250);
        Chestplate wraithsEmbrace = new Chestplate("Wraith's Embrace", 6, 11, "Bone", 300);
        Chestplate crimsonShield = new Chestplate("Crimson Shield", 7, 12, "Steel", 350);
        Chestplate voidwalkersChesplate = new Chestplate("Void walker's Chestplate", 8, 14, "Void steel", 400);

        chestplates.add(aegisOfTheFallen);
        chestplates.add(shadowedBreastplate);
        chestplates.add(celestialArmor);
        chestplates.add(dragonScalePlate);
        chestplates.add(wraithsEmbrace);
        chestplates.add(crimsonShield);
        chestplates.add(voidwalkersChesplate);

        // Pants ---------------------
        Pants aegisGreaves = new Pants("Aegis Greaves", 2, 4, 100);
        Pants shadowedTrousers = new Pants("Shadowed Trousers", 3, 6, 150);
        Pants celestialPants = new Pants("Celestial Pants", 4, 7, 200);
        Pants wraithsShroud = new Pants("Wraith's Shroud", 5, 9, 250);
        Pants ironcladPants = new Pants("Ironclad Pants", 6, 11, 300);
        Pants voidWalkersPants = new Pants("Void walker's Pants", 7, 12, 350);
        Pants runicTrousers = new Pants("Runic Trousers", 8, 15, 400);

        pants.add(aegisGreaves);
        pants.add(shadowedTrousers);
        pants.add(celestialPants);
        pants.add(wraithsShroud);
        pants.add(ironcladPants);
        pants.add(voidWalkersPants);
        pants.add(runicTrousers);
    }

    public static void showWeapons(Character ally) {
        int index = 1;
        for (Weapon weapon : weapons) {
            System.out.println("     " + index + ". Name: " + weapon.getItemName() + ". Required level: " + weapon.getLevelRequired() + ". Damage: " + weapon.getExtraDamage() + ". Cost: " + weapon.getCost());
            index++;
        }

        System.out.print("\n1. Buy\n2. Exit\nYour option: ");
        int option = sc.nextInt();

        if (option == 1) {
            System.out.print("Introduce weapon number: ");
            int num = sc.nextInt();

            if (weapons.get(num - 1).getCost() <= ally.getGold() && weapons.get(num - 1).getLevelRequired() <= ally.getLevel()) {
                if (weapons.get(num - 1).getWeaponType().equalsIgnoreCase("Sword") && ally instanceof Warrior) {
                    System.out.print("You want to equip " + weapons.get(num - 1).getItemName() + "?\n1. Yes\n2. No\nYour option: ");
                    int yesNo = sc.nextInt();

                    if (yesNo == 1) {
                        weapons.get(num - 1).equip(weapons.get(num - 1), ally, "Weapon");
                    } else {
                        ally.getInventory().add(weapons.get(num - 1));
                    }

                    if (!ally.getMissions()[4]){
                        Missions.buyWeapon(ally.getMissions());
                        ally.setXp(ally.getXp() + 75);
                    }
                    ally.setGold(ally.getGold() - weapons.get(num - 1).getCost());
                } else if (weapons.get(num - 1).getWeaponType().equalsIgnoreCase("Bow") && ally instanceof Archer) {
                    System.out.print("You want to equip " + weapons.get(num - 1).getItemName() + "?\n1. Yes\n2. No\nYour option: ");
                    int yesNo = sc.nextInt();

                    if (yesNo == 1) {
                        weapons.get(num - 1).equip(weapons.get(num - 1), ally, "Bow");
                    } else {
                        ally.getInventory().add(weapons.get(num - 1));
                    }

                    if (!ally.getMissions()[4]){
                        Missions.buyWeapon(ally.getMissions());
                        ally.setXp(ally.getXp() + 75);
                    }
                    ally.setGold(ally.getGold() - weapons.get(num - 1).getCost());

                } else if (weapons.get(num - 1).getWeaponType().equalsIgnoreCase("Staffs & Wands") && ally instanceof Wizard) {
                    System.out.print("You want to equip " + weapons.get(num - 1).getItemName() + "?\n1. Yes\n2. No\nYour option: ");
                    int yesNo = sc.nextInt();

                    if (yesNo == 1) {
                        weapons.get(num - 1).equip(weapons.get(num - 1), ally, "Staffs & Wands");
                    } else {
                        ally.getInventory().add(weapons.get(num - 1));
                    }

                    if (!ally.getMissions()[4]){
                        Missions.buyWeapon(ally.getMissions());
                        ally.setXp(ally.getXp() + 75);
                    }
                    ally.setGold(ally.getGold() - weapons.get(num - 1).getCost());

                } else {
                    System.out.println("You can't buy this weapon\n");
                }
            } else {
                System.out.println("You can't buy this weapon.\n");
            }
            if (ally.getXp() > ally.getXpNeeded()) {
                ally.levelUp();
            }
        }
        System.out.println();
    }

    public static void showChestplates(Character ally) {
        int index = 1;
        for (Chestplate chestplate : chestplates) {
            System.out.println("     " + index + ". Name: " + chestplate.getItemName() + ". Required level: " +
                    chestplate.getLevelRequired() + ". Defense: " + chestplate.getDefense() + ". Material: " + chestplate.getMaterial() + ". Cost: " + chestplate.getCost());
            index++;
        }

        System.out.print("\n1. Buy\n2. Exit\nYour option: ");
        int option = sc.nextInt();

        if (option == 1) {
            System.out.print("Introduce chestplate number: ");
            int num = sc.nextInt();

            if (chestplates.get(num - 1).getCost() <= ally.getGold() && chestplates.get(num - 1).getLevelRequired() <= ally.getLevel()) {
                System.out.print("You want to equip " + chestplates.get(num - 1).getItemName() + "?\n1. Yes\n2. No\n Your option: ");
                int yesNo = sc.nextInt();

                if (yesNo == 1) {
                    chestplates.get(num - 1).equip(chestplates.get(num - 1), ally, "Weapon");
                } else {
                    ally.getInventory().add(chestplates.get(num - 1));
                }

                if (!ally.getMissions()[5]){
                    Missions.buyChestplate(ally.getMissions());
                    ally.setXp(ally.getXp() + 75);
                }
                ally.setGold(ally.getGold() - chestplates.get(num - 1).getCost());
            } else {
                System.out.println("You can't buy this chestplate.\n");
            }
        } else {
            System.out.println();
        }
    }

    public static void showPants(Character ally) {
        int index = 1;
        for (Pants pants : pants) {
            System.out.println("     " + index + ". Name: " + pants.getItemName() + ". Required level: " + pants.getLevelRequired() + ". Defense: " + pants.getDefense()+ ". Cost: " + pants.getCost());
            index++;
        }

        System.out.print("\n1. Buy\n2. Exit\nYour option: ");
        int option = sc.nextInt();

        if (option == 1) {
            System.out.print("Introduce pants number: ");
            int num = sc.nextInt();

            if (pants.get(num - 1).getCost() <= ally.getGold() && pants.get(num - 1).getLevelRequired() <= ally.getLevel()) {
                System.out.print("You want to equip " + pants.get(num - 1).getItemName() + "?\n1. Yes\n2. No\n Your option: ");
                int yesNo = sc.nextInt();

                if (yesNo == 1) {
                    pants.get(num - 1).equip(pants.get(num - 1), ally, "Weapon");
                } else {
                    ally.getInventory().add(pants.get(num - 1));
                }
                if (!ally.getMissions()[6]){
                    Missions.buyPants(ally.getMissions());
                    ally.setXp(ally.getXp() + 75);
                }
                ally.setGold(ally.getGold() - pants.get(num - 1).getCost());
                System.out.println();
            } else {
                System.out.println("You can't buy these pants.\n");
            }
        } else {
            System.out.println();
        }
    }
}
