package practica2;

public abstract class Entity {

    private final String name; // Entity name
    private int health; // Entity health
    private int level; // Entity level
    private int xCoordinate;
    private int yCoordinate;

    public Entity(String name, int health, int level, int xCoordinate, int yCoordinate) {
        this.name = name;
        this.health = health;
        this.level = level;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public abstract void describe();

    public void takeDmg() {

    }

    public boolean isAlive() {
        return health > 0;
    }

    public void moveUp(Entity entity, World map) {
        try {
            if (map.getMap()[entity.yCoordinate - 1][entity.xCoordinate] == null) {
                entity.setyCoordinate(entity.getyCoordinate() - 1);
                System.out.println(entity.name + " has taken a step forward.\n");
                map.getMap()[entity.getyCoordinate()][entity.getxCoordinate()] = entity;
                map.getMap()[entity.getyCoordinate() + 1][entity.getxCoordinate()] = null;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Cannot move up! Edge of the map reached.\n");
        }
    }

    public void moveDown(Entity entity, World map) {
        try {
            if (map.getMap()[entity.yCoordinate + 1][entity.xCoordinate] == null) {
                entity.setyCoordinate(entity.getyCoordinate() + 1);
                System.out.println(entity.name + " has taken a step back.\n");
                map.getMap()[entity.getyCoordinate()][entity.getxCoordinate()] = entity;
                map.getMap()[entity.getyCoordinate() - 1][entity.getxCoordinate()] = null;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Cannot move up! Edge of the map reached.\n");
        }
    }

    public void moveRight(Entity entity, World map) {
        try {
            if (map.getMap()[entity.yCoordinate][entity.xCoordinate + 1] == null) {
                entity.setxCoordinate(entity.getxCoordinate() + 1);
                System.out.println(entity.name + " has taken a step to the right.\n");
                map.getMap()[entity.getyCoordinate()][entity.getxCoordinate()] = entity;
                map.getMap()[entity.getyCoordinate()][entity.getxCoordinate() - 1] = null;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Cannot move up! Edge of the map reached.\n");
        }
    }

    public void moveLeft(Entity entity, World map) {
        try {
            if (map.getMap()[entity.yCoordinate][entity.xCoordinate - 1] == null) {
                entity.setxCoordinate(entity.getxCoordinate() - 1);
                System.out.println(entity.name + " has taken a step to the left.\n");
                map.getMap()[entity.getyCoordinate()][entity.getxCoordinate()] = entity;
                map.getMap()[entity.getyCoordinate()][entity.getxCoordinate() + 1] = null;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Cannot move up! Edge of the map reached.\n");
        }
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    // Setters
    public void setHealth(int health) {
        this.health = health;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
}
