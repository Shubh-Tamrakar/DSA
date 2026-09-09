class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    void solve(int idx, int[] nums, List<Integer> curr) {

        ans.add(new ArrayList<>(curr));

        if(idx == nums.length) return;

        for (int i = idx; i < nums.length; i++) {

            if (i > idx && nums[i] == nums[i - 1])
                continue;

            curr.add(nums[i]);

            solve(i + 1, nums, curr);

            curr.remove(curr.size() - 1);
        }
        return;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        solve(0, nums, new ArrayList<>());

        return ans;
    }
}