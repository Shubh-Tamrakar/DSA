class Solution {

    public int minAreaRect(int[][] points) {

        HashSet<String> set = new HashSet<>();

        // saare points set mein daal do
        for (int[] p : points) {
            set.add(p[0] + "," + p[1]);
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < points.length; i++) {

            int x1 = points[i][0];
            int y1 = points[i][1];

            for (int j = i + 1; j < points.length; j++) {

                int x2 = points[j][0];
                int y2 = points[j][1];

                // same x ya same y hua to rectangle nahi banega
                if (x1 == x2 || y1 == y2) {
                    continue;
                }

                // remaining 2 corners check karo
                if (set.contains(x1 + "," + y2) &&
                    set.contains(x2 + "," + y1)) {

                    int area = Math.abs(x2 - x1) *
                               Math.abs(y2 - y1);

                    ans = Math.min(ans, area);
                }
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}