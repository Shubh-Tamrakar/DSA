class Solution {
    public long[] resultArray(int[] nums, int k) {

        long[] ans = new long[k];

        // dp[r] = current position par end hone wale
        // subarrays ki count jinka product % k = r
        long[] dp = new long[k];

        for (int num : nums) {

            int mod = num % k;

            long[] newDp = new long[k];

            // Sirf current element ka subarray
            newDp[mod] = 1;

            // Previous subarrays ko current num ke saath extend karo
            for (int r = 0; r < k; r++) {

                int newRem = (r * mod) % k;

                newDp[newRem] += dp[r];
            }

            // Current ending wale saare subarrays ko answer mein add karo
            for (int r = 0; r < k; r++) {
                ans[r] += newDp[r];
            }

            dp = newDp;
        }

        return ans;
    }
}