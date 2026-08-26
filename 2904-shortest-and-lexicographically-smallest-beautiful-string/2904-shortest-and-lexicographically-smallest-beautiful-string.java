class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        int left = 0;
        int ones = 0;

        String ans = "";

        for (int right = 0; right < s.length(); right++) {

            // right wala character window me add kiya
            if (s.charAt(right) == '1') {
                ones++;
            }

            // agar k se zyada 1 ho gaye
            while (ones > k) {

                if (s.charAt(left) == '1') {
                    ones--;
                }

                left++;
            }

            // extra starting zeros hatao
            while (ones == k && s.charAt(left) == '0') {
                left++;
            }

            // ab window me exactly k ones hain
            if (ones == k) {

                String current = s.substring(left, right + 1);

                if (ans.equals("")
                        || current.length() < ans.length()
                        || (current.length() == ans.length()
                            && current.compareTo(ans) < 0)) {

                    ans = current;
                }
            }
        }

        return ans;
    }
}