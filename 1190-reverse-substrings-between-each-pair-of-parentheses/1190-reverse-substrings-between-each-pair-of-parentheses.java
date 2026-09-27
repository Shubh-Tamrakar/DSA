class Solution {
    public String reverseParentheses(String s) {

        Stack<String> st = new Stack<>();
        String curr = "";

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                st.push(curr);
                curr = "";
            }

            else if (ch == ')') {
                curr = reverse(curr);

                curr = st.pop() + curr;
            }

            else {
                curr += ch;
            }
        }

        return curr;
    }

    public String reverse(String s) {

        String rev = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            rev += s.charAt(i);
        }

        return rev;
    }
}