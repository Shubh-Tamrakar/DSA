class Solution {
    public boolean isPossible(int[] arr, int s, int x) {

        boolean[] dp = new boolean[x + 1];
        dp[0] = true;

        long sum = s;

     
        if (s <= x) {
            dp[s] = true;
        }

        for (int num : arr) {

            long next = sum + num;

         
            if (next > x) {
                break;
            }

            int val = (int) next;

            // 0/1 subset sum
            for (int j = x; j >= val; j--) {
                if (dp[j - val]) {
                    dp[j] = true;
                }
            }

            sum += next;

            if (dp[x]) {
                return true;
            }
        }

        return dp[x];
    }
}