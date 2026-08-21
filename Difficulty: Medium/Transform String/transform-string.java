class Solution {
    int transform(String s1, String s2) {
        // code here
        int n = s1.length();

        // length mismatch
        if (n != s2.length()) {
            return -1;
        }
        
        
        int[] freq = new int[128];

        for (int i = 0; i < n; i++) {

            freq[s1.charAt(i)]++;
            freq[s2.charAt(i)]--;
        }

        // transformation impossible
        for (int x : freq) {

            if (x != 0) {
                return -1;
            }
        }
        
        int i = n - 1;
        int j = n - 1;

        int count = 0;

        // compare from back
        while (i >= 0) {

            // matching chars
            if (s1.charAt(i) == s2.charAt(j)) {

                i--;
                j--;
            }
            else {

                // move char to front
                count++;
                i--;
            }
        }
      return count;
    }
}