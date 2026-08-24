class Solution {
    public int uniqueLetterString(String s) {

        int n = s.length();
        int[] last = new int[26];
        int[] prev = new int[26];

        for (int i = 0; i < 26; i++) {
            last[i] = -1;
            prev[i] = -1;
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {

            int ch = s.charAt(i) - 'A';

            int p = last[ch];

            if (p != -1) {
                ans += (long)(p - prev[ch]) * (i - p);
            }

            prev[ch] = p;
            last[ch] = i;
        }

        for (int ch = 0; ch < 26; ch++) {

            int p = last[ch];

            if (p != -1) {
                ans += (long)(p - prev[ch]) * (n - p);
            }
        }

        return (int) ans;
    }
}