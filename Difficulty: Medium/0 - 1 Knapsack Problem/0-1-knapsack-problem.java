import java.util.*;

class Solution {
    public int knapsack(int W, int val[], int wt[]) {

        int n = val.length;

        int[][] dp = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(n, W, val, wt, dp);
    }

    static int solve(int i, int W, int val[], int wt[], int[][] dp) {

        // Base case
        if (i == 0 || W == 0) {
            return 0;
        }

        // Already calculated
        if (dp[i][W] != -1) {
            return dp[i][W];
        }

        // Current item cannot be included
        if (wt[i - 1] > W) {
            return dp[i][W] = solve(i - 1, W, val, wt, dp);
        }

        // Include current item
        int include = val[i - 1]
                + solve(i - 1, W - wt[i - 1], val, wt, dp);

        // Exclude current item
        int exclude = solve(i - 1, W, val, wt, dp);

        return dp[i][W] = Math.max(include, exclude);
    }
}