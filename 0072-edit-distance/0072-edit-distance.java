class Solution {

    public int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(n, m, word1, word2, dp);
    }

    static int solve(int i, int j,
                     String word1, String word2,
                     int[][] dp) {

        // Word1 empty
        if (i == 0) {
            return j;
        }

        // Word2 empty
        if (j == 0) {
            return i;
        }

        // Already calculated
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Characters are same
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {

            return dp[i][j] =
                    solve(i - 1, j - 1, word1, word2, dp);
        }

        // Insert
        int insert =
                1 + solve(i, j - 1, word1, word2, dp);

        // Delete
        int delete =
                1 + solve(i - 1, j, word1, word2, dp);

        // Replace
        int replace =
                1 + solve(i - 1, j - 1, word1, word2, dp);

        return dp[i][j] =
                Math.min(insert,
                Math.min(delete, replace));
    }
}