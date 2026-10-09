class Solution {
    public int minInsertions(String s) {
        int res = 0;
        int openNeeded = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                openNeeded++;
            } else {
                // Check if we have a consecutive pair '))'
                if (i + 1 < n && s.charAt(i + 1) == ')') {
                    i++; // Consume the second ')'
                } else {
                    // Single ')' found, insert one ')' to make it '))'
                    res++;
                }
                
                // Match with an open bracket '(' if available
                if (openNeeded > 0) {
                    openNeeded--;
                } else {
                    // No '(' to match, insert one '('
                    res++;
                }
            }
        }
        
        // Each remaining '(' needs two ')'s
        res += openNeeded * 2;
        
        return res;
    }
}