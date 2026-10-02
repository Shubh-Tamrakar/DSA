import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }
    
    private void backtrack(List<String> result, StringBuilder current, int open, int close, int max) {
        // If the current string reaches the length of 2 * n, it's a valid combination
        if (current.length() == max * 2) {
            result.add(current.toString());
            return;
        }
        
        // We can add an opening parenthesis if we haven't used up all n opening brackets
        if (open < max) {
            current.append('(');
            backtrack(result, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1); // backtrack
        }
        
        // We can add a closing parenthesis if the number of closing brackets is less than opening brackets
        if (close < open) {
            current.append(')');
            backtrack(result, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1); // backtrack
        }
    }
}