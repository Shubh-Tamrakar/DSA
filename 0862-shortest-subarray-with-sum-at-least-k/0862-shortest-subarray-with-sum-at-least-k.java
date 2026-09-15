class Solution {
    public int shortestSubarray(int[] nums, int k) {

        int n = nums.length;

        long[] prefix = new long[n + 1];

        // Step 1: Prefix Sum
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        Deque<Integer> dq = new ArrayDeque<>();

        int ans = n + 1;

        for (int i = 0; i <= n; i++) {

            // Step 2: Check valid subarray
            while (!dq.isEmpty() &&
                   prefix[i] - prefix[dq.peekFirst()] >= k) {

                ans = Math.min(ans, i - dq.pollFirst());
            }

            // Step 3: Remove useless elements
            while (!dq.isEmpty() &&
                   prefix[i] <= prefix[dq.peekLast()]) {

                dq.pollLast();
            }

            // Step 4: Current index add
            dq.addLast(i);
        }

        return ans == n + 1 ? -1 : ans;
    }
}