class Solution {
    public void floydWarshall(int[][] dist) {
        // Code here
        int n = dist.length;
        for(int  k =0;k<n;k++) {
             for(int  i =0;i<n;i++) {
                   for(int  j =0;j<n;j++) {
                       
                       if(dist[i][k] != 100000000 && dist[k][j] != 100000000 ) {
                           if(dist[i][j] > dist[i][k] + dist[k][j]) {
                               dist[i][j] = dist[i][k] + dist[k][j];
                           }
                       }
                       
                        }
             }
        }
    }
}