class Solution {
    public int matrixSum(int[][] nums) {
        int score = 0;
        for(int i =0;i<nums.length;i++) {

        
        Arrays.sort(nums[i]);
        }

        for(int i =0;i<nums[0].length;i++) {
            int max = Integer.MIN_VALUE;
            for(int j =0;j<nums.length;j++) {
              max = Math.max(max ,nums[j][i]);
            }
            score += max;
        }

        return score;
    }
}