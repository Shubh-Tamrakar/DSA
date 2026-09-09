class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        Integer[][] dp = new Integer[m][n];

        return solve(0, 0, obstacleGrid, dp);
    }

    static int solve(int i, int j, int[][] obstacleGrid, Integer[][] dp) {

        // Out of bounds
        if (i >= obstacleGrid.length ||
            j >= obstacleGrid[0].length) {
            return 0;
        }

        // Obstacle
        if (obstacleGrid[i][j] == 1) {
            return 0;
        }

        // Destination
        if (i == obstacleGrid.length - 1 &&
            j == obstacleGrid[0].length - 1) {
            return 1;
        }

        // Already calculated
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int down = solve(i + 1, j, obstacleGrid, dp);
        int right = solve(i, j + 1, obstacleGrid, dp);

        dp[i][j] = down + right;

        return dp[i][j];
    }
}