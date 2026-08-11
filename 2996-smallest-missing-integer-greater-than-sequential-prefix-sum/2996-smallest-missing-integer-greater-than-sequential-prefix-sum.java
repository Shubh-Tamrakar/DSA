class Solution {
    public int missingInteger(int[] nums) {

        int sum = nums[0];

        for(int i = 1; i < nums.length; i++) {

            if(nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            }
            else {
                break;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        for(int el : nums) {
            list.add(el);
        }

        for(int i = sum; ; i++) {

            if(!list.contains(i)) {
                return i;
            }
        }
    }
}