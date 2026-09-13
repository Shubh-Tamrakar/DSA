class Solution {
    int[][] memo;

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        memo = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }

        return solve(grid, 0, 0);
    }

    int solve(int[][] grid, int i, int j) {

        int m = grid.length;
        int n = grid[0].length;

        // Destination
        if (i == m - 1 && j == n - 1) {
            return grid[i][j];
        }

        // Already calculated
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int down = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;

        // Down
        if (i + 1 < m) {
            down = solve(grid, i + 1, j);
        }

        // Right
        if (j + 1 < n) {
            right = solve(grid, i, j + 1);
        }

        memo[i][j] = grid[i][j] + Math.min(down, right);

        return memo[i][j];
    }
}