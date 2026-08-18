class Solution {
    public int largestInteger(int[] nums, int k) {

        int n = nums.length;
        Map<Integer, Integer> count = new HashMap<>();

        // Count in how many k-length subarrays
        // each number appears
        for (int i = 0; i <= n - k; i++) {

            Set<Integer> set = new HashSet<>();

            for (int j = i; j < i + k; j++) {
                set.add(nums[j]);
            }

            for (int x : set) {
                count.put(x, count.getOrDefault(x, 0) + 1);
            }
        }

        int ans = -1;

        for (int x : count.keySet()) {
            if (count.get(x) == 1) {
                ans = Math.max(ans, x);
            }
        }

        return ans;
    }
}