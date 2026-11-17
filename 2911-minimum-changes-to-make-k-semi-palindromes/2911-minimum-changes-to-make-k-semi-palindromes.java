import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Solution {
    private Integer[][] memoDP;
    private int[][] cost;
    private List<Integer>[] divisors;
    private String s;
    private int n;

    public int minimumChanges(String s, int k) {
        this.s = s;
        this.n = s.length();
        
        // Precompute divisors for each possible length from 1 to n
        divisors = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            divisors[i] = new ArrayList<>();
            for (int d = 1; d * d <= i; d++) {
                if (i % d == 0) {
                    if (d < i) divisors[i].add(d);
                    if (d != 1 && (i / d) < i) divisors[i].add(i / d);
                }
            }
        }
        
        // Precompute cost[i][j]: min changes to make s[i...j] a semi-palindrome
        cost = new int[n][n];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                cost[i][j] = calcCost(i, j);
            }
        }
        
        // DP memoization table
        memoDP = new Integer[n][k + 1];
        return solve(0, k);
    }
    
    // Calculate minimum changes to make s[i...j] a semi-palindrome
    private int calcCost(int i, int j) {
        int len = j - i + 1;
        int minChanges = Integer.MAX_VALUE;
        
        // Try all valid divisors d of len
        for (int d : divisors[len]) {
            int changes = 0;
            // Check each of the d groups
            for  (int offset = 0; offset < d; offset++) {
                int left = i + offset;
                int right = i + len - 1 - (d - 1 - offset); // corresponding end index in the same group
                while (left < right) {
                    if (s.charAt(left) != s.charAt(right)) {
                        changes++;
                    }
                    left += d;
                    right -= d;
                }
            }
            minChanges = Math.min(minChanges, changes);
        }
        
        // If no valid divisor exists (e.g. prime lengths), cost is effectively infinity
        return minChanges == Integer.MAX_VALUE ? 1000 : minChanges;
    }
    
    // DP function to partition s[i...] into remaining parts
    private int solve(int i, int partsLeft) {
        if (i == n) {
            return partsLeft == 0 ? 0 : 1000;
        }
        if (partsLeft <= 0) {
            return 1000;
        }
        if (memoDP[i][partsLeft] != null) {
            return memoDP[i][partsLeft];
        }
        
        int res = 1000;
        // Try ending the current substring at index j
        // Leave enough characters for the remaining (partsLeft - 1) parts
        for (int j = i; j <= n - partsLeft; j++) {
            int currentCost = cost[i][j];
            res = Math.min(res, currentCost + solve(j + 1, partsLeft - 1));
        }
        
        return memoDP[i][partsLeft] = res;
    }
}