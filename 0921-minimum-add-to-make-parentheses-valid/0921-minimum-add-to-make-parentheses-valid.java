class Solution {
    public int minAddToMakeValid(String s) {
        int openBrackets = 0;
        int minAddsRequired = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                openBrackets++;
            } else {
                // If we encounter a closing bracket, check if we have an unmatched open bracket available
                if (openBrackets > 0) {
                    openBrackets--;
                } else {
                    // No matching open bracket, so we need to add an opening parenthesis
                    minAddsRequired++;
                }
            }
        }
        
        // Add any remaining unmatched open brackets that need closing brackets
        return minAddsRequired + openBrackets;
    }
}