class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean vis[][] = new boolean[image.length][image[0].length];
        int orgCol = image[sr][sc];

        if (orgCol == color) {
            return image;
        }

        helper(image, sr, sc, color, orgCol, vis);

        return image;
    }
     public static void helper(int image[][], int sr, int sc,
                              int color, int orgCol, boolean vis[][]) {

        // boundary check
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length) {
            return;
        }

        // already visited or different color
        if (vis[sr][sc] || image[sr][sc] != orgCol) {
            return;
        }

        // mark visited
        vis[sr][sc] = true;

        // fill new color
        image[sr][sc] = color;

        // left
        helper(image, sr, sc - 1, color, orgCol, vis);

        // right
        helper(image, sr, sc + 1, color, orgCol, vis);

        // up
        helper(image, sr - 1, sc, color, orgCol, vis);

        // down
        helper(image, sr + 1, sc, color, orgCol, vis);
    }
}