class Solution {
    public int distinctSubseqII(String s) {

        int MOD = 1000000007;

        long total = 0;

        // dp[c] = number of distinct subsequences
        // ending with character c
        long[] dp = new long[26];

        for (char ch : s.toCharArray()) {

            int index = ch - 'a';

            long newSubsequences = (total + 1) % MOD;

            // Remove old subsequences ending with same character
            total = (total + newSubsequences - dp[index] + MOD) % MOD;

            dp[index] = newSubsequences;
        }

        return (int) total;
    }
}