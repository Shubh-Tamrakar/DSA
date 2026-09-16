class Solution {
    public int numberOfSets(int n, int k) {

        int MOD = 1_000_000_007;

        // f[i][j] = ways using first i points,
        //            when we are NOT currently drawing a segment
        //
        // g[i][j] = ways using first i points,
        //            when we ARE currently drawing a segment

        long[][] f = new long[n + 1][k + 1];
        long[][] g = new long[n + 1][k + 1];

        // With 1 point, we can make 0 segments in exactly 1 way
        f[1][0] = 1;

        for (int i = 2; i <= n; i++) {

            for (int j = 0; j <= k; j++) {

                // Current point is not part of an active segment
                f[i][j] = (f[i - 1][j] + g[i - 1][j]) % MOD;

                // Continue previous active segment
                g[i][j] = g[i - 1][j];

                if (j > 0) {

                    // Start a new segment
                    g[i][j] += f[i - 1][j - 1];
                    g[i][j] %= MOD;

                    // Start/continue segment while sharing endpoint
                    g[i][j] += g[i - 1][j - 1];
                    g[i][j] %= MOD;
                }
            }
        }

        return (int)((f[n][k] + g[n][k]) % MOD);
    }
}