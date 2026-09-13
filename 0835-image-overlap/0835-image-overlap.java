class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;

        Map<String, Integer> map = new HashMap<>();

        int ans = 0;

        for (int i1 = 0; i1 < n; i1++) {
            for (int j1 = 0; j1 < n; j1++) {

                if (img1[i1][j1] == 1) {

                    for (int i2 = 0; i2 < n; i2++) {
                        for (int j2 = 0; j2 < n; j2++) {

                            if (img2[i2][j2] == 1) {

                                int dx = i2 - i1;
                                int dy = j2 - j1;

                                String key = dx + "," + dy;

                                int count = map.getOrDefault(key, 0) + 1;
                                map.put(key, count);

                                ans = Math.max(ans, count);
                            }
                        }
                    }
                }
            }
        }

        return ans;
    }
}