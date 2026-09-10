class Solution {

    public int equalPairs(int[][] grid) {

        int count = 0;
        int n = grid.length;

        int[][] trans = new int[n][n];

        // Transpose
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                trans[i][j] = grid[j][i];
            }
        }

        // Compare every row with every column
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                boolean same = true;

                for (int k = 0; k < n; k++) {

                    if (grid[i][k] != trans[j][k]) {
                        same = false;
                        break;
                    }
                }

                if (same) {
                    count++;
                }
            }
        }

        return count;
    }
}