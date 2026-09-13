class Solution {
    public int superEggDrop(int k, int n) {

        // dp[e] = maximum floors we can check
        // with e eggs and current number of moves
        int[] dp = new int[k + 1];

        int moves = 0;

        while (dp[k] < n) {

            moves++;

            // Important: right to left
            for (int e = k; e >= 1; e--) {
                dp[e] = dp[e] + dp[e - 1] + 1;
            }
        }

        return moves;
    }
}