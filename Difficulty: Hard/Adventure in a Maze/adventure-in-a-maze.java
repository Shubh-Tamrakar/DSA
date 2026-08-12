class Solution {
    public ArrayList<Integer> findWays(int[][] grid) {

        int n = grid.length;
        int MOD = 1000000007;

        long[][] ways = new long[n][n];
        int[][] maxSum = new int[n][n];

        // -1 means this cell is unreachable
        for (int i = 0; i < n; i++) {
            Arrays.fill(maxSum[i], -1);
        }

        // Starting cell
        ways[0][0] = 1;
        maxSum[0][0] = grid[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (maxSum[i][j] == -1) {
                    continue;
                }

                // Move RIGHT
                if ((grid[i][j] == 1 || grid[i][j] == 3)
                        && j + 1 < n) {

                    ways[i][j + 1] =
                        (ways[i][j + 1] + ways[i][j]) % MOD;

                    maxSum[i][j + 1] = Math.max(
                        maxSum[i][j + 1],
                        maxSum[i][j] + grid[i][j + 1]
                    );
                }

                // Move DOWN
                if ((grid[i][j] == 2 || grid[i][j] == 3)
                        && i + 1 < n) {

                    ways[i + 1][j] =
                        (ways[i + 1][j] + ways[i][j]) % MOD;

                    maxSum[i + 1][j] = Math.max(
                        maxSum[i + 1][j],
                        maxSum[i][j] + grid[i + 1][j]
                    );
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        ans.add((int) ways[n - 1][n - 1]);
        ans.add(Math.max(0, maxSum[n - 1][n - 1]));

        return ans;
    }
}