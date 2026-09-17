class Solution {
    public String findLongestWord(String s, List<String> dictionary) {

        int n = s.length();

        // next[i][c] = index of next occurrence of character c
        int[][] next = new int[n + 1][26];

        // -1 means character is not present
        for (int c = 0; c < 26; c++) {
            next[n][c] = -1;
        }

        for (int i = n - 1; i >= 0; i--) {

            // Copy next row
            for (int c = 0; c < 26; c++) {
                next[i][c] = next[i + 1][c];
            }

            // Current character
            next[i][s.charAt(i) - 'a'] = i;
        }

        String ans = "";

        for (String word : dictionary) {

            if (isSubsequence(word, next, n)) {

                if (word.length() > ans.length()) {
                    ans = word;
                }
                else if (word.length() == ans.length()
                        && word.compareTo(ans) < 0) {
                    ans = word;
                }
            }
        }

        return ans;
    }

    private boolean isSubsequence(String word, int[][] next, int n) {

        int pos = 0;

        for (int i = 0; i < word.length(); i++) {

            int ch = word.charAt(i) - 'a';

            if (pos > n || next[pos][ch] == -1) {
                return false;
            }

            // Move to next position
            pos = next[pos][ch] + 1;
        }

        return true;
    }
}

