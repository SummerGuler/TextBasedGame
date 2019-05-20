import java.util.Random;

public class Grid extends Element {
    /** Child class of Element class to create a Grid instance */

    // Determines the grid dimensions
    private int width;
    private int height;
    protected Element[][] grid;

    // Creates Player, Monster, Sword, and Potion instances
    private Player player = new Player();
    private Monster monster = new Monster();
    private Sword sword = new Sword();
    private Potion potion = new Potion();

    // Determines the monster, sword, and potion counts
    private int monsterCount = 0;
    private int swordCount = 0;
    private int potionCount = 0;

    public Grid(){
        /**
         * Initializes the dimensions and 2D grid array */

        width = 8;
        height = 8;
        grid = new Element[8][8];

    } // end of constructor

    public Player getPlayer() {
        return player;
    }

    public Monster getMonster() {
        return monster;
    }

    public Sword getSword() {
        return sword;
    }

    public Potion getPotion() {
        return potion;
    }

    public Element getElementFromGrid(int x, int y) {
        return grid[x][y];
    }

    public void setElementOnGrid(int x, int y, Element element) {
        grid[x][y] = element;
    }

    public int getMonsterCount() {
        return monsterCount;
    }

    public void incrementMonsterCount() {
        monsterCount++;
    }

    public int getSwordCount() {
        return swordCount;
    }

    public void incrementSwordCount() {
        swordCount++;
    }

    public int getPotionCount() { return potionCount; }

    public void incrementPotionCount() { potionCount++; }

    public void decrementPotionCount() { potionCount--; }

    public void initGrid() {
        /**
         * Creates a grid and places the obstacles into the grid */

        Random rand = new Random();
        Element[] myElements = new Element[10];

        myElements[0] = player;
        myElements[1] = monster;
        myElements[2] = monster;
        myElements[3] = monster;
        myElements[4] = monster;
        myElements[5] = monster;
        myElements[6] = sword;
        myElements[7] = sword;
        myElements[8] = potion;
        myElements[9] = potion;

        for(int i = 0; i < myElements.length; i++) {

            int randWidth = rand.nextInt(7) + 0;
            int randHeight = rand.nextInt(7) + 0;

            while (grid[randWidth][randHeight] != null) {
                randWidth = rand.nextInt(7) + 0;
                randHeight = rand.nextInt(7) + 0;
            }
            grid[randWidth][randHeight] = myElements[i];
        }
    } // end of initGrid()

    public int[] findPlayer() {
        /**
         * Determines the player's location in the grid and returns its coordinates */

        int[] coordinates = new int[2];

        for(int row = 0; row < height; row++) {
            for(int col = 0; col < width; col++) {
                if(grid[col][row] == player) {
                    coordinates[0] = col;
                    coordinates[1] = row;
                    break;
                }
            }
        }
        return coordinates;
    } // end of findPlayer()

    public void offTheEdge() {
        /**
         * Warns the player when s/he is off the edge */

        System.out.println();
        System.out.println("You're off the edge. You cannot move there.");
        System.out.println();

    } // end of offTheEdge

    public void printGrid() {
        /**
         * Displays the grid */

        int row;
        int col;

        System.out.println();
        for(row = 0; row < height; row++) {
            for(col = 0; col < width; col++) {
                System.out.print(grid[col][row] + "\t\t");
            }
            System.out.println();
        }

    } // end of printGrid()

}
