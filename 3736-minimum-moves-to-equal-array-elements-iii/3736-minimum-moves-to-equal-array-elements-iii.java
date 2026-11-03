class Solution {
    public int minMoves(int[] nums) {
        // Find the maximum element in the array
        int maxVal = nums[0];
        for (int num : nums) {
            if (num > maxVal) {
                maxVal = num;
            }
        }
        
        // Calculate the total moves needed to bring all elements to maxVal
        int totalMoves = 0;
        for (int num : nums) {
            totalMoves += (maxVal - num);
        }
        
        return totalMoves;
    }
}