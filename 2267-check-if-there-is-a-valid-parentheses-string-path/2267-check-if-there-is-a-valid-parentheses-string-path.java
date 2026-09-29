class Solution {

    HashSet<String> set = new HashSet<>();

    public boolean hasValidPath(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // Valid parentheses string ki length even honi chahiye
        if ((m + n - 1) % 2 != 0)
            return false;

        // Starting with ')' is invalid
        if (grid[0][0] == ')')
            return false;

        return solve(grid, 0, 0, 1);
    }

    public boolean solve(char[][] grid, int i, int j, int open) {

        int m = grid.length;
        int n = grid[0].length;

        // Balance negative => invalid
        if (open < 0)
            return false;

        // Remaining cells enough nahi hain balance ko zero karne ke liye
        int remaining = (m - 1 - i) + (n - 1 - j);

        if (open > remaining)
            return false;

        // Destination
        if (i == m - 1 && j == n - 1) {
            return open == 0;
        }

        String key = i + "," + j + "," + open;

        if (set.contains(key))
            return false;

        set.add(key);

        // Down
        if (i + 1 < m) {

            int newOpen = open;

            if (grid[i + 1][j] == '(')
                newOpen++;
            else
                newOpen--;

            if (solve(grid, i + 1, j, newOpen))
                return true;
        }

        // Right
        if (j + 1 < n) {

            int newOpen = open;

            if (grid[i][j + 1] == '(')
                newOpen++;
            else
                newOpen--;

            if (solve(grid, i, j + 1, newOpen))
                return true;
        }

        return false;
    }
}