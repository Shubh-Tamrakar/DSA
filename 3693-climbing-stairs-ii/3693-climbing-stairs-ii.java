import java.util.Arrays;

class Solution {
    public int climbStairs(int n, int[] costs) {

        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);

        return helper(n, costs, dp);
    }

    public int helper(int n, int costs[], int dp[]) {

        // Base case
        if(n == 0) {
            return 0;
        }

        // Already calculated
        if(dp[n] != -1) {
            return dp[n];
        }

        int ans = Integer.MAX_VALUE;

        // Jump 1 step
        ans = Math.min(ans,
                helper(n-1, costs, dp) + costs[n-1] + 1);

        // Jump 2 steps
        if(n >= 2) {
            ans = Math.min(ans,
                    helper(n-2, costs, dp) + costs[n-1] + 4);
        }

        // Jump 3 steps
        if(n >= 3) {
            ans = Math.min(ans,
                    helper(n-3, costs, dp) + costs[n-1] + 9);
        }

        return dp[n] = ans;
    }
}