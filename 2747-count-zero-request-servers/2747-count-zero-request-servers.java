import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = queries.length;
        
        // Step 1: Pair each query with its original index
        int[][] sortedQueries = new int[m][2];
        for (int i = 0; i < m; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        
        // Sort queries by their time values
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Sort logs by their time values
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
        
        int[] result = new int[m];
        Map<Integer, Integer> serverCount = new HashMap<>();
        
        int left = 0;
        int right = 0;
        int numLogs = logs.length;
        
        // Step 2: Process each query using a two-pointer sliding window
        for (int i = 0; i < m; i++) {
            int queryTime = sortedQueries[i][0];
            int originalIndex = sortedQueries[i][1];
            
            int windowStart = queryTime - x;
            int windowEnd = queryTime;
            
            // Expand the right boundary of the window
            while (right < numLogs && logs[right][1] <= windowEnd) {
                int serverId = logs[right][0];
                serverCount.put(serverId, serverCount.getOrDefault(serverId, 0) + 1);
                right++;
            }
            
            // Shrink the left boundary of the window
            while (left < numLogs && logs[left][1] < windowStart) {
                int serverId = logs[left][0];
                serverCount.put(serverId, serverCount.get(serverId) - 1);
                if (serverCount.get(serverId) == 0) {
                    serverCount.remove(serverId);
                }
                left++;
            }
            
            // Servers with zero requests = Total servers - Servers with at least 1 request
            result[originalIndex] = n - serverCount.size();
        }
        
        return result;
    }
}