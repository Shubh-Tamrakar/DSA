class Solution {
    public int maxPalindromes(String s, int k) {

        int n = s.length();
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {

            // Don't take a palindrome ending here
            dp[i] = dp[i - 1];

            // Minimum length k
            if (i >= k && isPalindrome(s, i - k, i - 1)) {
                dp[i] = Math.max(dp[i], dp[i - k] + 1);
            }

            // Length > k
            for (int j = i - k - 1; j >= 0; j--) {

                if (isPalindrome(s, j, i - 1)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);

                    // Important:
                    // first palindrome found is enough
                    break;
                }
            }
        }

        return dp[n];
    }

    private boolean isPalindrome(String s, int l, int r) {

        while (l < r) {

            if (s.charAt(l) != s.charAt(r))
                return false;

            l++;
            r--;
        }

        return true;
    }
}