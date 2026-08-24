class Solution {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        int n = startTime.length;

        int[][] jobs = new int[n][3];

        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        // Sort by end time
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);

        int[] dp = new int[n];

        dp[0] = jobs[0][2];

        for (int i = 1; i < n; i++) {

            // 1. Don't take current job
            int skip = dp[i - 1];

            // 2. Take current job
            int take = jobs[i][2];

            // Find previous job whose end <= current start
            int j = findPrevious(jobs, i, jobs[i][0]);

            if (j != -1) {
                take += dp[j];
            }

            dp[i] = Math.max(skip, take);
        }

        return dp[n - 1];
    }

    // Binary Search
    static int findPrevious(int[][] jobs, int i, int start) {

        int left = 0;
        int right = i - 1;
        int ans = -1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (jobs[mid][1] <= start) {
                ans = mid;
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }

        return ans;
    }
}