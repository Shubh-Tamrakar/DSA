
class Solution {

    public int uniquePaths(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
            }
        }

        return helper(grid, 0, 0, 0, dp);
    }

    public int helper(int[][] grid, int i, int j,
                      int dir, int[][][] dp) {

        int m = grid.length;
        int n = grid[0].length;

        if (i >= m || j >= n) {
            return 0;
        }

        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (dp[i][j][dir] != -1) {
            return dp[i][j][dir];
        }

        int ans = 0;

        if (grid[i][j] == 0) {

            int down = helper(grid, i + 1, j, 1, dp);

            int right = helper(grid, i, j + 1, 0, dp);

            ans = (down + right) % 1000000007;

        } else {

            if (dir == 0) {
                ans = helper(grid, i + 1, j, 1, dp);
            } else {
                ans = helper(grid, i, j + 1, 0, dp);
            }
        }

        return dp[i][j][dir] = ans;
    }
}
