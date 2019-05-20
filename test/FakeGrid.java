public class FakeGrid extends Grid {
    /** Creates a fake grid to be used for testing purposes */

    @Override
    public void initGrid() {

        // Initializes the fake grid with instances
        grid[2][0] = getPlayer();
        grid[1][1] = getSword();
        grid[1][3] = getSword();
        grid[4][1] = getMonster();
        grid[4][3] = getMonster();
        grid[4][5] = getMonster();
        grid[1][5] = getMonster();
        grid[3][5] = getMonster();
        grid[6][0] = getPotion();
    }
}
