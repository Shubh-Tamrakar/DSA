import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        // Initialize an array to store the minimum coins needed for each amount from 0 to 'amount'.
        // Fill it with amount + 1, which acts as a placeholder for infinity.
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        
        // Base case: 0 coins are needed to make an amount of 0.
        dp[0] = 0;
        
        // Iterate through all amounts from 1 up to the target amount.
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                // Check if the coin can be used for the current amount
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        
        // If dp[amount] is still amount + 1, it means the amount cannot be made up by any combination of coins.
        return dp[amount] > amount ? -1 : dp[amount];
    }
}