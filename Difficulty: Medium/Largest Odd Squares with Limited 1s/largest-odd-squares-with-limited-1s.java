class Solution {
    ArrayList<Integer> largestSquare(int[][] mat, int[][] queries, int k) {

        int n = mat.length;
        int m = mat[0].length;

       
        int[][] prefix = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                prefix[i][j] = mat[i - 1][j - 1]
                        + prefix[i - 1][j]
                        + prefix[i][j - 1]
                        - prefix[i - 1][j - 1];
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int[] query : queries) {

            int i = query[0];
            int j = query[1];

            int best = -1;

            for (int r = 0; ; r++) {

                int top = i - r;
                int bottom = i + r;
                int left = j - r;
                int right = j + r;

                
                if (top < 0 || bottom >= n ||
                    left < 0 || right >= m) {
                    break;
                }

             
                int ones = prefix[bottom + 1][right + 1]
                         - prefix[top][right + 1]
                         - prefix[bottom + 1][left]
                         + prefix[top][left];

                if (ones <= k) {
                    best = 2 * r + 1;
                } else {
                    
                    break;
                }
            }

            ans.add(best);
        }

        return ans;
    }
}