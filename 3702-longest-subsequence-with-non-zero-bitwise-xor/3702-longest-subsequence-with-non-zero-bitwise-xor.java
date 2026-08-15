class Solution {
    public int longestSubsequence(int[] nums) {

        int n = nums.length;
        int xor = 0;
        boolean allZero = true;

        for (int num : nums) {
            xor ^= num;

            if (num != 0) {
                allZero = false;
            }
        }

       
        if (xor != 0) {
            return n;
        }

      
        if (allZero) {
            return 0;
        }

      
        return n - 1;
    }
}