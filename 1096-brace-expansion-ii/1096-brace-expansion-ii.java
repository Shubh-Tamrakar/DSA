class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> ans = solve(expression);
        
        List<String> list = new ArrayList<>(ans);
        Collections.sort(list);
        return list;
    }

    public Set<String> solve(String s) {
        Set<String> result = new HashSet<>();
        
        // Find first '{'
        int start = -1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{') {
                start = i;
                break;
            }
        }

        // No braces -> single string
        if (start == -1) {
            result.add(s);
            return result;
        }

        // Find matching '}'
        int count = 0;
        int end = -1;

        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == '{') {
                count++;
            } else if (s.charAt(i) == '}') {
                count--;
                
                if (count == 0) {
                    end = i;
                    break;
                }
            }
        }

        // Content inside braces
        String inside = s.substring(start + 1, end);

        // Split by top-level comma
        List<String> parts = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        count = 0;

        for (int i = 0; i < inside.length(); i++) {
            char ch = inside.charAt(i);

            if (ch == '{') count++;
            else if (ch == '}') count--;

            if (ch == ',' && count == 0) {
                parts.add(curr.toString());
                curr.setLength(0);
            } else {
                curr.append(ch);
            }
        }

        parts.add(curr.toString());

        // Expand each part
        Set<String> left = new HashSet<>();

        for (String part : parts) {
            left.addAll(solve(part));
        }

        // Remaining part after '}'
        String rightPart = s.substring(end + 1);

        Set<String> right = solve(rightPart);

        // Prefix before '{'
        String prefix = s.substring(0, start);

        Set<String> prefixSet = solve(prefix);

        // Concatenate prefix + left + right
        for (String p : prefixSet) {
            for (String l : left) {
                for (String r : right) {
                    result.add(p + l + r);
                }
            }
        }

        return result;
    }
}