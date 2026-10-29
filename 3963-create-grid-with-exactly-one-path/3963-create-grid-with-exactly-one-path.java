import java.util.Arrays;

class Solution {
    public String[] createGrid(int m, int n) {
        char[][] grid = new char[m][n];
        
        // Fill the entire grid with obstacles ('#')
        for (int i = 0; i < m; i++) {
            Arrays.fill(grid[i], '#');
        }
        
        // Carve the path: Go right along the first row
        for (int j = 0; j < n; j++) {
            grid[0][j] = '.';
        }
        
        // Carve the path: Go down along the last column
        for (int i = 0; i < m; i++) {
            grid[i][n - 1] = '.';
        }
        
        // Convert char[][] to String[]
        String[] result = new String[m];
        for (int i = 0; i < m; i++) {
            result[i] = new String(grid[i]);
        }
        
        return result;
    }
}