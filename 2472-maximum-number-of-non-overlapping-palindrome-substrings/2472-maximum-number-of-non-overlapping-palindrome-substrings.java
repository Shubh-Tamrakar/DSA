class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();

        // palindrome[i][j] = s[i...j] palindrome hai ya nahi
        boolean[][] palindrome = new boolean[n][n];

        // Palindrome calculate
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {

                int j = i + len - 1;

                if (len == 1) {
                    palindrome[i][j] = true;
                }
                else if (len == 2) {
                    palindrome[i][j] = (s.charAt(i) == s.charAt(j));
                }
                else {
                    palindrome[i][j] =
                        s.charAt(i) == s.charAt(j)
                        && palindrome[i + 1][j - 1];
                }
            }
        }

        // dp[i] = first i characters se maximum palindromes
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {

            // Current character ko skip kar diya
            dp[i] = dp[i - 1];

            // Last palindrome [j ... i-1]
            for (int j = 0; j < i; j++) {

                int len = i - j;

                if (len >= k && palindrome[j][i - 1]) {
                    dp[i] = Math.max(
                        dp[i],
                        dp[j] + 1
                    );
                }
            }
        }

        return dp[n];
    }
}