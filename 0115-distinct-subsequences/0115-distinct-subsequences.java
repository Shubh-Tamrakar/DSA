class Solution {

    public int numDistinct(String s, String t) {

        int n = s.length();
        int m = t.length();

        long[][] dp = new long[n + 1][m + 1];

        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }

        return (int) memo(n, m, s, t, dp);
    }

    public long memo(int i, int j, String s, String t, long[][] dp) {

        // t is empty
        if (j == 0) return 1;

        // s is empty but t is not
        if (i == 0) return 0;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s.charAt(i - 1) == t.charAt(j - 1)) {

            return dp[i][j] =
                    memo(i - 1, j - 1, s, t, dp)
                    + memo(i - 1, j, s, t, dp);

        } else {

            return dp[i][j] =
                    memo(i - 1, j, s, t, dp);
        }
    }
}