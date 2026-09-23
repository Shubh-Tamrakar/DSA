class Solution {
    public boolean canPartition(int[] nums) {

        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        // Total sum odd hai to equal partition possible nahi
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        boolean[][] dp = new boolean[nums.length + 1][target + 1];

        // 0 sum hamesha possible hai
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= nums.length; i++) {

            for (int j = 1; j <= target; j++) {

                if (nums[i - 1] <= j) {

                    // Take OR Not Take
                    dp[i][j] = dp[i - 1][j]
                             || dp[i - 1][j - nums[i - 1]];

                } else {

                    // Cannot take
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[nums.length][target];
    }
}