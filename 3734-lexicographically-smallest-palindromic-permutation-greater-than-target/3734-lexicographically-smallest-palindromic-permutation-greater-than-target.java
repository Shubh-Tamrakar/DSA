class Solution {

    public String lexPalindromicPermutation(String s, String target) {

        int n = s.length();

        int[] count = new int[26];

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        // Check whether palindrome is possible
        int odd = 0;
        char middle = 0;

        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1) {
                odd++;
                middle = (char) ('a' + i);
            }
        }

        if (odd > 1) {
            return "";
        }

        // count[i] now represents how many of this character
        // we need in the LEFT HALF
        for (int i = 0; i < 26; i++) {
            count[i] /= 2;
        }

        StringBuilder left = new StringBuilder();

        int halfLength = n / 2;

        for (int pos = 0; pos < halfLength; pos++) {

            boolean found = false;

            // Try smallest possible character
            for (int ch = 0; ch < 26; ch++) {

                if (count[ch] == 0) {
                    continue;
                }

                // Choose this character temporarily
                count[ch]--;
                left.append((char) ('a' + ch));

                // Check maximum possible completion
                if (canMakeGreater(left, count, middle, target, n)) {
                    found = true;
                    break;
                }

                // Undo choice
                left.deleteCharAt(left.length() - 1);
                count[ch]++;
            }

            if (!found) {
                return "";
            }
        }

        String leftHalf = left.toString();

        StringBuilder answer = new StringBuilder();

        answer.append(leftHalf);

        if (n % 2 == 1) {
            answer.append(middle);
        }

        answer.append(new StringBuilder(leftHalf).reverse());

        String result = answer.toString();

        return result.compareTo(target) > 0 ? result : "";
    }


    private boolean canMakeGreater(
            StringBuilder prefix,
            int[] count,
            char middle,
            String target,
            int n
    ) {

        StringBuilder left = new StringBuilder(prefix);

        // Make remaining LEFT HALF as large as possible
        for (int i = 25; i >= 0; i--) {
            while (count[i] > 0) {
                left.append((char) ('a' + i));
                count[i]--;
            }
        }

        // Restore counts
        for (int i = 0; i < 26; i++) {
            int used = 0;

            for (int j = prefix.length(); j < left.length(); j++) {
                if (left.charAt(j) == (char) ('a' + i)) {
                    used++;
                }
            }

            count[i] += used;
        }

        StringBuilder palindrome = new StringBuilder(left);

        if (n % 2 == 1) {
            palindrome.append(middle);
        }

        palindrome.append(left.reverse());

        return palindrome.toString().compareTo(target) > 0;
    }
}