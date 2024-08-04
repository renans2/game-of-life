public class World {
    private static final int NEIGHBOURS_TO_REVIVE = 3;
    private static final int MIN_NEIGHBOURS_STAY_ALIVE = 2;
    private static final int MAX_NEIGHBOURS_STAY_ALIVE = 3;
    private static final int MIN_OVERPOPULATION = 3;
    private static final int MAX_UNDERPOPULATION = 2;

    private final int rows;
    private final int cols;
    private boolean[][] grid;

    public World(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        grid = new boolean[rows][cols];

        // Calcula a posição central
        int centerX = 20;
        int centerY = 20;

        // Posiciona o glider no meio da matriz
        grid[centerY - 1][centerX] = true;   // O
        grid[centerY][centerX + 1] = true;   // O
        grid[centerY + 1][centerX - 1] = true; // O
        grid[centerY + 1][centerX] = true;   // O
        grid[centerY + 1][centerX + 1] = true;
    }

    public boolean willLive(int row, int col) {
        boolean alive = grid[row][col];
        int neighbours = countNeighbours(row, col);

        if (alive && neighbours < MAX_UNDERPOPULATION) return false;

        else if (alive && neighbours >= MIN_NEIGHBOURS_STAY_ALIVE && neighbours <= MAX_NEIGHBOURS_STAY_ALIVE) return true;

        else if (alive && neighbours > MIN_OVERPOPULATION) return false;

        else if (!alive && neighbours == NEIGHBOURS_TO_REVIVE) return true;

        else return false;
    }

    private int countNeighbours(int row, int col) {
        int count = 0;

        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if(i == row && j == col)
                    continue;

                if (0 <= i && i < rows && 0 <= j && j < cols && grid[i][j])
                    count++;
            }
        }

        return count;
    }

    public boolean isAlive(int row, int col) {
        return grid[row][col];
    }

    public void updateCells() {
        boolean[][] newGrid = new boolean[rows][cols];

        for (int row = 0; row < rows; row++)
            for (int col = 0; col < cols; col++)
                if(willLive(row, col))
                    newGrid[row][col] = true;

        grid = newGrid;
    }
}
