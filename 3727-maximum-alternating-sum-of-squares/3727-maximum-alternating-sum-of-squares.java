import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] squares = new long[n];
        
        for (int i = 0; i < n; i++) {
            squares[i] = (long) nums[i] * nums[i];
        }
        
        Arrays.sort(squares);
        
        long totalSum = 0;
        // The first n / 2 smallest squares are subtracted
        for (int i = 0; i < n / 2; i++) {
            totalSum -= squares[i];
        }
        // The remaining larger squares are added
        for (int i = n / 2; i < n; i++) {
            totalSum += squares[i];
        }
        
        return totalSum;
    }
}