class Solution {
    public int maximumLengthSubstring(String s) {

      
        int arr[] = new int[26];

        int left = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {

            if (arr[s.charAt(right) - 'a'] < 2) {

                arr[s.charAt(right) - 'a']++;

            } else {

                while (arr[s.charAt(right) - 'a'] >= 2) {

                    arr[s.charAt(left) - 'a']--;
                    left++;
                }

                arr[s.charAt(right) - 'a']++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}