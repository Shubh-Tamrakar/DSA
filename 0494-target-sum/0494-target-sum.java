class Solution {

    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, 0, 0, target);
    }

    private int solve(int[] nums, int index, int currentSum, int target) {

        if (index == nums.length) {
            return currentSum == target ? 1 : 0;
        }

        // + sign
        int add = solve(
            nums,
            index + 1,
            currentSum + nums[index],
            target
        );

        // - sign
        int subtract = solve(
            nums,
            index + 1,
            currentSum - nums[index],
            target
        );

        return add + subtract;
    }
}