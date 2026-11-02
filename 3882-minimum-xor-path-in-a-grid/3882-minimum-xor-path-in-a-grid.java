import java.util.BitSet;

class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // dp[i][j] will be a BitSet representing all possible XOR values reachable at cell (i, j)
        BitSet[][] dp = new BitSet[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new BitSet(1024);
            }
        }
        
        // Base case: top-left cell
        dp[0][0].set(grid[0][0]);
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j].isEmpty()) continue;
                
                // Move down
                if (i + 1 < m) {
                    for (int x = dp[i][j].nextSetBit(0); x >= 0; x = dp[i][j].nextSetBit(x + 1)) {
                        dp[i + 1][j].set(x ^ grid[i + 1][j]);
                    }
                }
                
                // Move right
                if (j + 1 < n) {
                    for (int x = dp[i][j].nextSetBit(0); x >= 0; x = dp[i][j].nextSetBit(x + 1)) {
                        dp[i][j + 1].set(x ^ grid[i][j + 1]);
                    }
                }
            }
        }
        
        // Find the minimum XOR value at the bottom-right cell (m - 1, n - 1)
        return dp[m - 1][n - 1].nextSetBit(0);
    }
}