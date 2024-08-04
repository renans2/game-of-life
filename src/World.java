public class World {
    private static final int NEIGHBOURS_TO_REVIVE = 3;
    private static final int MIN_NEIGHBOURS_STAY_ALIVE = 2;
    private static final int MAX_NEIGHBOURS_STAY_ALIVE = 3;
    private static final int MIN_OVERPOPULATION = 3;
    private static final int MAX_UNDERPOPULATION = 2;

    private final boolean[][] grid;

    public World(int cols, int rows) {
        grid = new boolean[cols][rows];
    }

    public void updateCells() {

    }
}
