class Solution {
    public String toLowerCase(String s) {
        StringBuilder ans = new StringBuilder();

        for (char ch : s.toCharArray()) {
            ans.append(Character.toLowerCase(ch));
        }

        return ans.toString();
    }
}