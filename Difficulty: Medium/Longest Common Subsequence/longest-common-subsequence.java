class Solution {
    public int lcs(String s1, String s2) {
        // code here
         int dp[][] = new int[s1.length()][s2.length()];
         for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        //int ans = 0;
         return help(s1 , s2 , dp,  s1.length() - 1 , s2.length()-1);
         
    }

    private int help(String text1 , String text2 , int dp[][] ,  int i,int j) {
                if(i<0 || j<0 || i>text1.length() || j > text2.length()) {
                    return 0;
                }
               
                if(dp[i][j] != -1) {
                    return dp[i][j];
                }
        
                if(text1.charAt(i) == text2.charAt(j)) {
                   // ans +=1;
                 dp[i][j] = 1+ help(text1 ,text2,dp,i-1,j-1);
                }
                else {
                   dp[i][j] = Math.max(help(text1 , text2 , dp,i-1,j) , help(text1 , text2,dp,i,j-1));
                }

                return dp[i][j];
            
        
    
    }
}