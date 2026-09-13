class Solution {
    public String lastSubstring(String s) {

        int n = s.length();

        int i = 0;      // first candidate
        int j = 1;      // second candidate
        int k = 0;      // common characters

        while (j + k < n) {

            if (s.charAt(i + k) == s.charAt(j + k)) {
                k++;
                continue;
            }

            if (s.charAt(i + k) > s.charAt(j + k)) {
                // i wala substring bada hai
                j = j + k + 1;
            } else {
                // j wala substring bada hai
                i = i + k + 1;
            }

            if (i == j) {
                j++;
            }

            k = 0;
        }

        return s.substring(i);
    }
}