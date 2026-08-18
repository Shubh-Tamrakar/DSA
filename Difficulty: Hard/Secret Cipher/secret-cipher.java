class Solution {

    public String compress(String s) {

        int n = s.length();

        // LPS array
        int[] lps = new int[n];

        for (int i = 1; i < n; i++) {

            int j = lps[i - 1];

            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = lps[j - 1];
            }

            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }

            lps[i] = j;
        }

        StringBuilder ans = new StringBuilder();

        int i = n - 1;

        while (i >= 0) {

            // prefix of length (i + 1) can be compressed
            if (i % 2 == 1) {

                int len = i + 1;
                int longestPrefixSuffix = lps[i];

                int patternLength = len - longestPrefixSuffix;

                if (longestPrefixSuffix >= len / 2
                        && len % (2 * patternLength) == 0) {

                    ans.append('*');

                    // first half already represents the repeated part
                    i = i / 2 + 1;
                } 
                else {
                    ans.append(s.charAt(i));
                }

            } 
            else {
                ans.append(s.charAt(i));
            }

            i--;
        }

        return ans.reverse().toString();
    }
}
