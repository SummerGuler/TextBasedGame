public class GameRunner {

    public enum GameState {
        MOVING,
        OFF_THE_EDGE,
        QUIT,
        WRONG_OPTION,
        DEAD,
        WON_GAME
    }

    private final Grid grid;
    private final GameInput input;

    GameRunner(Grid grid, GameInput input) {
        this.grid = grid;
        this.input = input;
    }


    public void runGame() {
        /**
         * Runs the game by taking action with the given current and new coordinates */

        while (true) {
            GameState gameState = takeTurn();
            if (gameState == GameState.DEAD
                    || gameState == GameState.WON_GAME
                    || gameState == GameState.QUIT) {
                break;
            }
        }
    } // end of runGame()


    public GameState takeTurn() {
        /**
         * Determines the state of the game after taking turns */

        int[] coordinates = grid.findPlayer();
        int current_x = coordinates[0];
        int current_y = coordinates[1];
        grid.printGrid();
        char answer = input.askPlayer();

        if (answer == 'q') {
            System.out.println();
            System.out.println("Thanks for playing. Goodbye!");
            return GameState.QUIT;
        }

        if (answer == 'n') {
            int new_x = current_x;
            int new_y = current_y - 1;
            if (new_y < 0) {
                grid.offTheEdge();
                return GameState.OFF_THE_EDGE;
            }
            return movePlayer(current_x, current_y, new_x, new_y);
        }

        if (answer == 's') {
            int new_x = current_x;
            int new_y = current_y + 1;
            if (new_y > 7) {
                grid.offTheEdge();
                return GameState.OFF_THE_EDGE;
            }
            return movePlayer(current_x, current_y, new_x, new_y);
        }

        if (answer == 'w') {
            int new_x = current_x - 1;
            int new_y = current_y;
            if (new_x < 0) {
                grid.offTheEdge();
                return GameState.OFF_THE_EDGE;
            }
            return movePlayer(current_x, current_y, new_x, new_y);
        }

        if (answer == 'e') {
            int new_x = current_x + 1;
            int new_y = current_y;
            if (new_x > 7) {
                grid.offTheEdge();
                return GameState.OFF_THE_EDGE;
            }
            return movePlayer(current_x, current_y, new_x, new_y);
        }

        if (answer != 'q' && answer != 'n' && answer != 's' && answer != 'w' && answer != 'e') {
            System.out.println("\nWrong option. Please choose again.\n");
            return GameState.WRONG_OPTION;
        }

        return GameState.MOVING;
    } // end of takeTurn()


    private GameState movePlayer(int current_x, int current_y, int new_x, int new_y) {
        /**
         * Takes the current and new x and y coordinates to move around the grid */

        Element obstacle = grid.getElementFromGrid(new_x, new_y);
        if (obstacle == grid.getSword()) {
            grid.incrementSwordCount();
            grid.setElementOnGrid(new_x, new_y, grid.getPlayer());
            grid.setElementOnGrid(current_x, current_y, null);
        } else if (obstacle == grid.getPotion()){
            grid.incrementPotionCount();
            grid.setElementOnGrid(new_x, new_y, grid.getPlayer());
            grid.setElementOnGrid(current_x, current_y, null);
        } else if (obstacle == grid.getMonster()) {
            grid.incrementMonsterCount();
            if ((grid.getSwordCount() > 0 || grid.getPotionCount() == 1) && grid.getMonsterCount() <= 5) {
                grid.setElementOnGrid(new_x, new_y, grid.getPlayer());
                grid.setElementOnGrid(current_x, current_y, null);
                System.out.printf("\nYou killed %d monster(s) so far!\n\n", grid.getMonsterCount());
                grid.decrementPotionCount();
                if (grid.getMonsterCount() == 5) {
                    grid.printGrid();
                    System.out.println("\nYou have won the game.");
                    System.out.println("Thanks for playing. Goodbye!");
                    return GameState.WON_GAME;
                }
            } else {
                System.out.println("\nMonster killed you. RIP! ");
                return GameState.DEAD;
            }
        } else {
            grid.setElementOnGrid(new_x, new_y, grid.getPlayer());
            grid.setElementOnGrid(current_x, current_y, null);
        }

        return GameState.MOVING;
    } // end of movePlayer()
}
