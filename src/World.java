public class World {
    private static final int NEIGHBOURS_TO_REVIVE = 3;
    private static final int MIN_NEIGHBOURS_STAY_ALIVE = 2;
    private static final int MAX_NEIGHBOURS_STAY_ALIVE = 3;
//    private static final int MIN_OVERPOPULATION = 3;
//    private static final int MAX_UNDERPOPULATION = 2;

    private final int rows;
    private final int cols;
    private boolean[][] grid;

    public World(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        grid = new boolean[rows][cols];

        // ChatGPT:
        int[][] gliderGun = {
                {1, 25},
                {2, 23}, {2, 25},
                {3, 13}, {3, 14}, {3, 21}, {3, 22}, {3, 35}, {3, 36},
                {4, 12}, {4, 16}, {4, 21}, {4, 22}, {4, 35}, {4, 36},
                {5, 1},  {5, 2},  {5, 11}, {5, 17}, {5, 21}, {5, 22},
                {6, 1},  {6, 2},  {6, 11}, {6, 15}, {6, 17}, {6, 18}, {6, 23}, {6, 25},
                {7, 11}, {7, 17}, {7, 25},
                {8, 12}, {8, 16},
                {9, 13}, {9, 14}
        };

        for (int[] coord : gliderGun) {
            int x = coord[0];
            int y = coord[1];
            grid[x][y] = true;
        }
    }

    public boolean willLive(int row, int col) {
        boolean alive = grid[row][col];
        int neighbours = countNeighbours(row, col);

        if(alive) {
            if(neighbours < MIN_NEIGHBOURS_STAY_ALIVE)
                return false;
            else
                return neighbours <= MAX_NEIGHBOURS_STAY_ALIVE;
        } else {
            return neighbours == NEIGHBOURS_TO_REVIVE;
        }

//        if (alive && neighbours < MAX_UNDERPOPULATION) return false;
//
//        else if (alive && MIN_NEIGHBOURS_STAY_ALIVE <= neighbours && neighbours <= MAX_NEIGHBOURS_STAY_ALIVE) return true;
//
//        else if (alive && neighbours > MIN_OVERPOPULATION) return false;
//
//        else if (!alive && neighbours == NEIGHBOURS_TO_REVIVE) return true;
//
//        else return false;
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
