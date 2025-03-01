package practica2;

public class Witch extends Entity{

    private final int BASE_DAMAGE;
    public Witch(String name, int health, int level, int xCoordinate, int yCoordinate) {
        super(name, health, level, xCoordinate, yCoordinate);
        this.BASE_DAMAGE = 15;
    }

    @Override
    public void describe() {
        System.out.println("---------------------------------------------------------\n");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢢⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⣀⣤⡀⠀⠀⠍⠭⣔⣄⠀⠀⠀⠀⠀⢈⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⢰⢂⣀⣀⣤⣀⣹⣷⣤⣀⣀⠀⢉⣿⣶⣶⣶⣶⣿⣿⣿⠷⠆⠀⠀⠀⠀⣀⣄⠀\n" +
                "⠀⠈⠉⠹⠟⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣟⠋⠀⠀⠀⡤⠀⠀⣿⣏⠀\n" +
                "⠀⠀⠀⠐⠹⢟⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⣽⣿⣿⠿⣆⠀⠀⠀⠀⢸⢀⣿⣿⠀\n" +
                "⠀⠀⠀⠀⠀⠠⢴⣿⠟⢛⣿⣿⣟⣩⣴⣾⣿⡉⠹⢦⡈⠳⢤⡀⠀⠈⢼⣿⣿⡄\n" +
                "⠀⢀⣀⣀⣀⡀⠀⠀⠀⠀⠋⠀⣿⣿⣿⣿⣿⣿⣦⣀⡉⠶⡤⠈⠛⠂⠉⠁⠀⠀\n" +
                "⠀⠀⢺⣿⣿⣿⡿⠿⠿⣟⣛⣭⣽⣿⣿⣿⣿⣿⣿⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⢉⠕⠺⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠈⠉⠁⠛⢻⣿⠟⢑⡾⠁⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠁⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n\n" +
                "============ STATS ============\n" +
                "Name: " + getName() +
                "\nHealth: " + getHealth() +
                "\nLevel: " + getLevel());
        System.out.println("\n---------------------------------------------------------");
    }

    public int getBASE_DAMAGE() {
        return BASE_DAMAGE;
    }
}
