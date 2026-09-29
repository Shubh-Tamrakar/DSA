class Solution {

    public String lexPalindromicPermutation(String s, String target) {

        int n = s.length();

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // More than one odd frequency -> palindrome impossible
        int odd = 0;
        char middle = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                odd++;
                middle = (char) ('a' + i);
            }
        }

        if (odd > 1) {
            return "";
        }

        // We only need half of every character
        int[] half = new int[26];

        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
        }

        StringBuilder left = new StringBuilder();

        if (dfs(0, half.length, half, left, target, middle, n)) {

            StringBuilder ans = new StringBuilder();

            ans.append(left);

            if (n % 2 == 1) {
                ans.append(middle);
            }

            for (int i = left.length() - 1; i >= 0; i--) {
                ans.append(left.charAt(i));
            }

            return ans.toString();
        }

        return "";
    }

    private boolean dfs(
        int pos,
        int dummy,
        int[] half,
        StringBuilder left,
        String target,
        char middle,
        int n
    ) {

        int halfLen = n / 2;

        // Left half completely created
        if (pos == halfLen) {

            StringBuilder palindrome = new StringBuilder();

            palindrome.append(left);

            if (n % 2 == 1) {
                palindrome.append(middle);
            }

            for (int i = left.length() - 1; i >= 0; i--) {
                palindrome.append(left.charAt(i));
            }

            return palindrome.toString().compareTo(target) > 0;
        }

        // Try characters from smallest to largest
        for (int c = 0; c < 26; c++) {

            if (half[c] == 0) {
                continue;
            }

            half[c]--;
            left.append((char) ('a' + c));

            if (dfs(pos + 1, dummy, half, left, target, middle, n)) {
                return true;
            }

            left.deleteCharAt(left.length() - 1);
            half[c]++;
        }

        return false;
    }
}