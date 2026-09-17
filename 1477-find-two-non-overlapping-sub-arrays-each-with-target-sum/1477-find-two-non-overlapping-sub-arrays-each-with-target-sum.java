
class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;
        int INF = 1000000;

        int[] best = new int[n];
        Arrays.fill(best, INF);

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int ans = INF;

        // prefix sum 0 at index -1
        map.put(0, -1);

        for (int i = 0; i < n; i++) {

            sum += arr[i];

            // Copy previous best
            if (i > 0)
                best[i] = best[i - 1];

            // Need prefix sum = sum - target
            if (map.containsKey(sum - target)) {

                int j = map.get(sum - target);

                // Current subarray length
                int len = i - j;

                // Previous non-overlapping subarray
                if (j >= 0 && best[j] != INF) {
                    ans = Math.min(ans, len + best[j]);
                }

                // Current subarray can become best
                best[i] = Math.min(best[i], len);
            }

            // Store latest index
            map.put(sum, i);
        }

        return ans == INF ? -1 : ans;
    }
}
