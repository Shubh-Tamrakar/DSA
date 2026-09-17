
class Solution {
    public double knightProbability(int n, int k, int row, int column) {

        double[][] dp = new double[n][n];

        // Initially knight is here with probability 1
        dp[row][column] = 1.0;

        int[][] moves = {
            {-2, -1},
            {-2, 1},
            {-1, -2},
            {-1, 2},
            {1, -2},
            {1, 2},
            {2, -1},
            {2, 1}
        };

        for (int move = 0; move < k; move++) {

            double[][] newDp = new double[n][n];

            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {

                    if (dp[r][c] == 0) {
                        continue;
                    }

                    for (int[] m : moves) {

                        int nr = r + m[0];
                        int nc = c + m[1];

                        // Move is inside board
                        if (nr >= 0 && nr < n &&
                            nc >= 0 && nc < n) {

                            newDp[nr][nc] += dp[r][c] / 8.0;
                        }
                    }
                }
            }

            dp = newDp;
        }

        double ans = 0;

        // Add probability of all positions
        // where knight is still on board
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                ans += dp[r][c];
            }
        }

        return ans;
    }
}

