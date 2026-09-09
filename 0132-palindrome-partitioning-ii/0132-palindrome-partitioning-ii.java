class Solution {

    public int minCut(String s) {

        int n = s.length();
        Integer[] dp = new Integer[n];

        return solve(0, s, dp) - 1;
    }

    public static int solve(int i, String s, Integer[] dp) {

        int n = s.length();

      
        if (i == n) {
            return 0;
        }

        if (dp[i] != null) {
            return dp[i];
        }

        int min = Integer.MAX_VALUE;

        for (int j = i; j < n; j++) {

            if (isPalindrome(s, i, j)) {

                int cuts = 1 + solve(j + 1, s, dp);

                min = Math.min(min, cuts);
            }
        }

        return dp[i] = min;
    }


    public static boolean isPalindrome(String s, int i, int j) {

        while (i < j) {

            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}