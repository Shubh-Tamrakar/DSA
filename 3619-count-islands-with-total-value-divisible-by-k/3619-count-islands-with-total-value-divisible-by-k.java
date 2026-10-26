import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] > 0) {
                    long currentIslandSum = 0;
                    Queue<int[]> queue = new LinkedList<>();
                    
                    queue.offer(new int[]{r, c});
                    currentIslandSum += grid[r][c];
                    grid[r][c] = 0; // Mark as visited
                    
                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        int currR = cell[0];
                        int currC = cell[1];
                        
                        for (int i = 0; i < 4; i++) {
                            int nextR = currR + dr[i];
                            int nextC = currC + dc[i];
                            
                            if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && grid[nextR][nextC] > 0) {
                                currentIslandSum += grid[nextR][nextC];
                                grid[nextR][nextC] = 0; // Mark as visited
                                queue.offer(new int[]{nextR, nextC});
                            }
                        }
                    }
                    
                    if (currentIslandSum % k == 0) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}