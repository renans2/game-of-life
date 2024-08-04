public class World {
    private static final int NEIGHBOURS_TO_REVIVE = 3;
    private static final int MIN_NEIGHBOURS_STAY_ALIVE = 2;
    private static final int MAX_NEIGHBOURS_STAY_ALIVE = 3;
    private static final int MIN_OVERPOPULATION = 3;
    private static final int MAX_UNDERPOPULATION = 2;

    private final int rows;
    private final int cols;
    private final boolean[][] grid;

    public World(int cols, int rows) {
        this.rows = rows;
        this.cols = cols;
        grid = new boolean[cols][rows];
    }

    public void updateCells() {

    }

    public boolean isAlive(int row, int col) {
        return grid[col][row];
    }

    private void update() {
        boolean[][] newGrid = new boolean[rows][cols];

        for (int col = 0; col < cols; col++)
            for (int row = 0; row < rows; row++)
                if(willLive(col, row))
                    newGrid[col][row] = true;

        grid = newGrid;
    }
}
