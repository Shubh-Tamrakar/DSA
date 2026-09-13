class Solution {
    public int[] shortestToChar(String s, char c) {

        int[] ans = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {

            int min = Integer.MAX_VALUE;

            for (int j = 0; j < s.length(); j++) {

                if (s.charAt(j) == c) {
                    min = Math.min(min, Math.abs(i - j));
                }
            }

            ans[i] = min;
        }

        return ans;
    }
}