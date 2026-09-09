class Solution {

    public int uniquePathsIII(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int startI = 0;
        int startJ = 0;

        int run = 0;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    startI = i;
                    startJ = j;
                }

                // Count all cells that need to be visited
                if (grid[i][j] != -1) {
                    run++;
                }
            }
        }

        return solve(startI, startJ, m, n, grid, run);
    }


    public static int solve(int i, int j,
                            int m, int n,
                            int[][] grid,
                            int run) {

        // Out of bounds
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return 0;
        }

        // Obstacle or already visited
        if (grid[i][j] == -1) {
            return 0;
        }


        // Destination
        if (grid[i][j] == 2) {

            if (run == 1) {
                return 1;
            }

            return 0;
        }


        // Mark visited
        int temp = grid[i][j];
        grid[i][j] = -1;


        int left = solve(i, j - 1, m, n, grid, run - 1);

        int right = solve(i, j + 1, m, n, grid, run - 1);

        int up = solve(i - 1, j, m, n, grid, run - 1);

        int down = solve(i + 1, j, m, n, grid, run - 1);


        // Backtrack
        grid[i][j] = temp;


        return left + right + up + down;
    }
}