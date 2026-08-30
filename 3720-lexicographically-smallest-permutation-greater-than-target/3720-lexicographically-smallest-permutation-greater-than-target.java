class Solution {
        
    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();

        int[] freq = new int[26];

       
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for (char ch : target.toCharArray()) {
            freq[ch - 'a']--;
        }
        
        for (int i = n - 1; i >= 0; i--) {

       
            int ch = target.charAt(i) - 'a';
            freq[ch]++;

           
            boolean possible = true;

            for (int j = 0; j < 26; j++) {
                if (freq[j] < 0) {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                continue;
            }

           
            for (int j = ch + 1; j < 26; j++) {

                if (freq[j] > 0) {

                    freq[j]--;

                    StringBuilder ans = new StringBuilder();

                 
                    ans.append(target.substring(0, i));

                  
                    ans.append((char) ('a' + j));

              
                    for (int k = 0; k < 26; k++) {
                        while (freq[k] > 0) {
                            ans.append((char) ('a' + k));
                            freq[k]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }
}