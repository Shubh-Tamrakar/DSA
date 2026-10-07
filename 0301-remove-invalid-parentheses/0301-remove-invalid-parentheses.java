import java.util.*;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) return result;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (isValid(current)) {
                result.add(current);
                found = true; // Found valid string at current level of removals
            }

            // If a valid string has already been found at this level, 
            // skip generating further child strings (deeper levels)
            if (found) continue;

            // Generate all possible states by removing one parenthesis
            for (int i = 0; i < current.length(); i++) {
                char ch = current.charAt(i);
                if (ch != '(' && ch != ')') continue;

                String next = current.substring(0, i) + current.substring(i + 1);

                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.offer(next);
                }
            }
        }

        return result;
    }

    // Helper method to check if a parentheses string is valid
    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            else if (c == ')') {
                count--;
                if (count < 0) return false;
            }
        }
        return count == 0;
    }
}