import java.util.*;

class Solution {

    int n;
    int[][] arr;

    // dp[index][count] = maximum score
    long[][] dp;

    public int[] maximumWeight(List<List<Integer>> intervals) {

        n = intervals.size();

        arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0); // start
            arr[i][1] = intervals.get(i).get(1); // end
            arr[i][2] = intervals.get(i).get(2); // weight
            arr[i][3] = i;                       // original index
        }

        // Sort according to start time
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        // dp[i][j] stores maximum weight
        dp = new long[n][5];

        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }

        // This solution calculates maximum weight.
        // For complete lexicographically smallest answer,
        // we store selected indices in DP.
        List<Integer>[][] selected = new ArrayList[n + 1][5];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= 4; j++) {
                selected[i][j] = new ArrayList<>();
            }
        }

        long[][] score = new long[n + 1][5];

        for (int i = n - 1; i >= 0; i--) {

            for (int count = 1; count <= 4; count++) {

                // Option 1: Skip current interval
                score[i][count] = score[i + 1][count];

                selected[i][count] =
                        new ArrayList<>(selected[i + 1][count]);

                // Find next non-overlapping interval
                int next = findNext(i);

                // Option 2: Take current interval
                long takeScore =
                        arr[i][2] + score[next][count - 1];

                List<Integer> takeList =
                        new ArrayList<>(selected[next][count - 1]);

                takeList.add(arr[i][3]);

                Collections.sort(takeList);

                if (takeScore > score[i][count]) {

                    score[i][count] = takeScore;
                    selected[i][count] = takeList;

                } else if (takeScore == score[i][count]) {

                    if (isSmaller(takeList,
                            selected[i][count])) {

                        selected[i][count] = takeList;
                    }
                }
            }
        }

        List<Integer> ans = selected[0][4];

        int[] result = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }


    // Find first interval whose start > current end
    int findNext(int index) {

        int low = index + 1;
        int high = n - 1;

        int ans = n;

        int end = arr[index][1];

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid][0] > end) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }


    // Lexicographical comparison
    boolean isSmaller(List<Integer> a,
                      List<Integer> b) {

        for (int i = 0;
             i < Math.min(a.size(), b.size());
             i++) {

            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        return a.size() < b.size();
    }
}