class Solution {
    public int combinationSum4(int[] nums, int target) {
        // dp[i] will store the number of combinations that add up to i
        int[] dp = new int[target + 1];
        
        // Base case: There is 1 way to get a sum of 0 (by choosing nothing)
        dp[0] = 1;
        
        // Iterate through every sum from 1 up to the target
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                // If the current number can fit into the current sum
                if (i - num >= 0) {
                    dp[i] += dp[i - num];
                }
            }
        }
        
        return dp[target];
    }
}