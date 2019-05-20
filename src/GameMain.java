/**
 * Summer Guler
 * It's a text based game to collect a sword or a potion to kill the monsters
 * */

public class GameMain {

    public static void main(String[] args) {

        // Creates a Grid class instance
        Grid myGrid = new Grid();
        myGrid.initGrid();

        GameInput input = new GameInput();

        // Starts and runs the game
        GameRunner myGameRunner = new GameRunner(myGrid, input);
        myGameRunner.runGame();
    }
}
