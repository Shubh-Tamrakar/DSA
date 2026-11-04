
import java.util.*;

class Solution {

    TreeMap<Integer, Integer> left = new TreeMap<>();
    TreeMap<Integer, Integer> right = new TreeMap<>();

    int leftSize = 0, rightSize = 0;
    long leftSum = 0, rightSum = 0;

    void add(TreeMap<Integer, Integer> map, int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
    }

    void remove(TreeMap<Integer, Integer> map, int val) {
        int count = map.get(val);

        if (count == 1) {
            map.remove(val);
        } else {
            map.put(val, count - 1);
        }
    }

    void insert(int val) {

        if (leftSize == 0 || val <= left.lastKey()) {
            add(left, val);
            leftSize++;
            leftSum += val;
        } else {
            add(right, val);
            rightSize++;
            rightSum += val;
        }

        balance();
    }

    void erase(int val) {

        if (left.containsKey(val)) {
            remove(left, val);
            leftSize--;
            leftSum -= val;
        } else {
            remove(right, val);
            rightSize--;
            rightSum -= val;
        }

        balance();
    }

    void balance() {

        int required = (leftSize + rightSize + 1) / 2;

        while (leftSize > required) {
            int val = left.lastKey();

            remove(left, val);
            leftSize--;
            leftSum -= val;

            add(right, val);
            rightSize++;
            rightSum += val;
        }

        while (leftSize < required) {
            int val = right.firstKey();

            remove(right, val);
            rightSize--;
            rightSum -= val;

            add(left, val);
            leftSize++;
            leftSum += val;
        }
    }

    long getCost() {

        long median = left.lastKey();

        long leftCost = median * leftSize - leftSum;
        long rightCost = rightSum - median * rightSize;

        return leftCost + rightCost;
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;
        int m = n - x + 1;

        long[] cost = new long[m];

        // First window
        for (int i = 0; i < x; i++) {
            insert(nums[i]);
        }

        cost[0] = getCost();

        // Sliding window
        for (int i = x; i < n; i++) {

            erase(nums[i - x]);
            insert(nums[i]);

            cost[i - x + 1] = getCost();
        }

        // DP
        long INF = Long.MAX_VALUE / 4;

        long[][] dp = new long[k + 1][n + 1];

        for (int i = 0; i <= k; i++) {
            Arrays.fill(dp[i], INF);
        }

        dp[0][0] = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j <= k; j++) {

                if (dp[j][i] == INF) {
                    continue;
                }

                // Skip current index
                dp[j][i + 1] = Math.min(
                    dp[j][i + 1],
                    dp[j][i]
                );

                // Select window of size x
                if (j < k && i + x <= n) {

                    dp[j + 1][i + x] = Math.min(
                        dp[j + 1][i + x],
                        dp[j][i] + cost[i]
                    );
                }
            }
        }

        return dp[k][n];
    }
}
