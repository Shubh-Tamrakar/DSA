class Solution {

    public boolean isMatch(String s, String p) {

        int n = s.length();
        int m = p.length();

        Boolean[][] dp = new Boolean[n + 1][m + 1];

        return solve(n, m, s, p, dp);
    }

    static boolean solve(int i, int j,
                         String s, String p,
                         Boolean[][] dp) {

        // Both string and pattern are finished
        if (i == 0 && j == 0) {
            return true;
        }

        // Pattern finished but string is still remaining
        if (j == 0) {
            return false;
        }

        // String finished
        if (i == 0) {

            // Remaining pattern must contain only '*'
            for (int k = 0; k < j; k++) {
                if (p.charAt(k) != '*') {
                    return false;
                }
            }

            return true;
        }

        // Already calculated
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        char sc = s.charAt(i - 1);
        char pc = p.charAt(j - 1);

        // Same character OR '?'
        if (sc == pc || pc == '?') {

            return dp[i][j] =
                    solve(i - 1, j - 1, s, p, dp);
        }

        // '*'
        if (pc == '*') {

            // '*' matches zero characters
            boolean zero = solve(i, j - 1, s, p, dp);

            // '*' matches current character
            boolean oneOrMore = solve(i - 1, j, s, p, dp);

            return dp[i][j] = zero || oneOrMore;
        }

        // Characters don't match
        return dp[i][j] = false;
    }
}