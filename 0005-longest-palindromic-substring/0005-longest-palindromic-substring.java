class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        String[][] dp = new String[n][n];

        return helper(s, 0, n - 1, dp);
    }

    private String helper(String s, int left, int right, String[][] dp) {

        if (left > right) {
            return "";
        }

        if (left == right) {
            return String.valueOf(s.charAt(left));
        }

        if (dp[left][right] != null) {
            return dp[left][right];
        }

        if (isPalindrome(s, left, right)) {
            return dp[left][right] = s.substring(left, right + 1);
        }

        String s1 = helper(s, left + 1, right, dp);
        String s2 = helper(s, left, right - 1, dp);

        return dp[left][right] =
                s1.length() >= s2.length() ? s1 : s2;
    }

    private boolean isPalindrome(String s, int left, int right) {

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}