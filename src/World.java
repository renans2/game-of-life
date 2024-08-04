public class World {
    private static final int NEIGHBOURS_TO_REVIVE = 3;
    private static final int MIN_NEIGHBOURS_STAY_ALIVE = 2;
    private static final int MAX_NEIGHBOURS_STAY_ALIVE = 3;
    private static final int MIN_OVERPOPULATION = 3;
    private static final int MAX_UNDERPOPULATION = 2;

    private final int rows;
    private final int cols;
    private boolean[][] grid;

    public World(int cols, int rows) {
        this.rows = rows;
        this.cols = cols;
        grid = new boolean[cols][rows];
    }

    public void updateCells() {

    }

    public boolean willLive(int row, int col) {
        boolean alive = grid[row][col];
        int neighbours = countNeighbours(row, col);

        if (alive && neighbours < MAX_UNDERPOPULATION) return false;

        else if (alive && neighbours < MIN_NEIGHBOURS_STAY_ALIVE && neighbours > MAX_NEIGHBOURS_STAY_ALIVE) return false;

        else if (alive && neighbours > MIN_OVERPOPULATION) return false;

        else if (!alive && neighbours == NEIGHBOURS_TO_REVIVE) return true;

        else return false;
    }

    private int countNeighbours(int row, int col) {
        int count = 0;

        for (int i = row - 1; i < row + 1; i++) {
            for (int j = col - 1; j < col + 1; j++) {
                if (i >= 0 && j >= 0 && grid[i][j]) count++;

            }
        }

        return count;
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
