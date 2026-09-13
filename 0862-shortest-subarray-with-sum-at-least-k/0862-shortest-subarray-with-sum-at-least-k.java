class Solution {
    public int shortestSubarray(int[] nums, int k) {

        int n = nums.length;

        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int[] deque = new int[n + 1];

        int front = 0;
        int back = 0;

        int ans = n + 1;

        for (int i = 0; i <= n; i++) {

            // 1. Check if valid subarray
            while (front < back &&
                   prefix[i] - prefix[deque[front]] >= k) {

                ans = Math.min(ans, i - deque[front]);
                front++;
            }

            // 2. Remove useless previous prefix sums
            while (front < back &&
                   prefix[i] <= prefix[deque[back - 1]]) {

                back--;
            }

            // 3. Add current index
            deque[back++] = i;
        }

        return ans == n + 1 ? -1 : ans;
    }
}