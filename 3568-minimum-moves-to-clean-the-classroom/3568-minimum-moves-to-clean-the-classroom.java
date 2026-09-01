import java.util.*;

class Solution {

    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        int sr = 0, sc = 0;
        int totalL = 0;

        // Assign every L an index for bitmask
        int[][] lIndex = new int[m][n];
        for (int[] row : lIndex) {
            Arrays.fill(row, -1);
        }

        int idx = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    sr = i;
                    sc = j;
                }

                if (ch == 'L') {
                    lIndex[i][j] = idx++;
                    totalL++;
                }
            }
        }

        int fullMask = (1 << totalL) - 1;

        // row, col, remainingEnergy, collectedMask
        Queue<int[]> queue = new LinkedList<>();

        // position + mask + energy
        boolean[][][][] visited =
                new boolean[m][n][energy + 1][1 << totalL];

        queue.offer(new int[]{sr, sc, energy, 0, 0});

        visited[sr][sc][energy][0] = true;

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();

            int r = curr[0];
            int c = curr[1];
            int power = curr[2];
            int mask = curr[3];
            int moves = curr[4];

            // All L collected
            if (mask == fullMask) {
                return moves;
            }

            for (int d = 0; d < 4; d++) {

                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= m ||
                    nc < 0 || nc >= n) {
                    continue;
                }

                char ch = classroom[nr].charAt(nc);

                if (ch == 'X') {
                    continue;
                }

                // Need 1 energy for movement
                if (power == 0) {
                    continue;
                }

                int newPower = power - 1;
                int newMask = mask;

                // Recharge
                if (ch == 'R') {
                    newPower = energy;
                }

                // Collect L
                if (ch == 'L') {
                    newMask |= (1 << lIndex[nr][nc]);
                }

                if (!visited[nr][nc][newPower][newMask]) {

                    visited[nr][nc][newPower][newMask] = true;

                    queue.offer(new int[]{
                        nr,
                        nc,
                        newPower,
                        newMask,
                        moves + 1
                    });
                }
            }
        }

        return -1;
    }
}