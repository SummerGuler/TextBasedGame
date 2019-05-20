import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameRunnerTest {
    /** Tests the game with different unit tests */

    private FakeGrid fakeGrid = new FakeGrid();
    private FakeGameInput fakeInput = new FakeGameInput();
    private GameRunner gameRunner;

    @Before
    public void setUp() {
        fakeGrid.initGrid();
        gameRunner = new GameRunner(fakeGrid, fakeInput);
    }

    @Test
    public void testOffTheEdge() {
        fakeInput.setAnswer('n');
        GameRunner.GameState gameState = gameRunner.takeTurn();
        assertEquals(GameRunner.GameState.OFF_THE_EDGE, gameState);
    }

    @Test
    public void testPlayerDead() {
        fakeInput.setAnswer('s');
        GameRunner.GameState gameState = gameRunner.takeTurn();
        assertEquals(GameRunner.GameState.MOVING, gameState);

        fakeInput.setAnswer('e');
        gameState = gameRunner.takeTurn();
        assertEquals(GameRunner.GameState.MOVING, gameState);

        fakeInput.setAnswer('e');
        gameState = gameRunner.takeTurn();
        assertEquals(GameRunner.GameState.DEAD, gameState);
    }

    @Test
    public void testPlayerWon() {
        fakeInput.setAnswer('w');
        GameRunner.GameState gameState = gameRunner.takeTurn();
        assertEquals(GameRunner.GameState.MOVING, gameState);

        fakeInput.setAnswer('s');
        gameState = gameRunner.takeTurn();
        assertEquals(GameRunner.GameState.MOVING, gameState);

        fakeInput.setAnswer('e');
        gameState = gameRunner.takeTurn();
        assertEquals(GameRunner.GameState.MOVING, gameState);

        fakeInput.setAnswer('e');
        gameState = gameRunner.takeTurn();
        assertEquals(GameRunner.GameState.MOVING, gameState);

        fakeInput.setAnswer('e');
        gameState = gameRunner.takeTurn();
        assertEquals(GameRunner.GameState.MOVING, gameState);

        fakeInput.setAnswer('s');
        gameState = gameRunner.takeTurn();
        assertEquals(GameRunner.GameState.MOVING, gameState);

        fakeInput.setAnswer('s');
        gameState = gameRunner.takeTurn();
        assertEquals(GameRunner.GameState.MOVING, gameState);

        fakeInput.setAnswer('s');
        gameState = gameRunner.takeTurn();
        assertEquals(GameRunner.GameState.MOVING, gameState);

        fakeInput.setAnswer('s');
        gameState = gameRunner.takeTurn();
        assertEquals(GameRunner.GameState.MOVING, gameState);

        fakeInput.setAnswer('w');
        gameState = gameRunner.takeTurn();
        assertEquals(GameRunner.GameState.MOVING, gameState);

        fakeInput.setAnswer('w');
        gameState = gameRunner.takeTurn();
        assertEquals(GameRunner.GameState.MOVING, gameState);

        fakeInput.setAnswer('w');
        gameState = gameRunner.takeTurn();
        assertEquals(GameRunner.GameState.WON_GAME, gameState);
    }

    @Test
    public void testPlayerQuit() {
        fakeInput.setAnswer('q');
        GameRunner.GameState gameState = gameRunner.takeTurn();
        assertEquals(GameRunner.GameState.QUIT, gameState);
    }


    @Test
    public void testPlayerWrongOption() {
        fakeInput.setAnswer('k');
        GameRunner.GameState gameState = gameRunner.takeTurn();
        assertEquals(GameRunner.GameState.WRONG_OPTION, gameState);
    }

    @Test
    public void testPlayerDrinkPotion() {
        fakeInput.setAnswer('e');
        GameRunner.GameState gameState = gameRunner.takeTurn();
        assertEquals(GameRunner.GameState.MOVING, gameState);

        fakeInput.setAnswer('e');
        gameState = gameRunner.takeTurn();
        assertEquals(GameRunner.GameState.MOVING, gameState);

        fakeInput.setAnswer('e');
        gameState = gameRunner.takeTurn();
        assertEquals(GameRunner.GameState.MOVING, gameState);

        fakeInput.setAnswer('e');
        gameState = gameRunner.takeTurn();
        assertEquals(GameRunner.GameState.MOVING, gameState);

        fakeInput.setAnswer('s');
        gameState = gameRunner.takeTurn();
        assertEquals(GameRunner.GameState.MOVING, gameState);

        fakeInput.setAnswer('w');
        gameState = gameRunner.takeTurn();
        assertEquals(GameRunner.GameState.MOVING, gameState);

        fakeInput.setAnswer('w');
        gameState = gameRunner.takeTurn();
        assertEquals(GameRunner.GameState.MOVING, gameState);

        fakeInput.setAnswer('s');
        gameState = gameRunner.takeTurn();
        assertEquals(GameRunner.GameState.MOVING, gameState);

        fakeInput.setAnswer('s');
        gameState = gameRunner.takeTurn();
        assertEquals(GameRunner.GameState.DEAD, gameState);
    }

    }
