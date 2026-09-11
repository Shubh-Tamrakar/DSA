class Solution {
    public int minSwaps(String s) {
        int unmatched = 0;
        int swaps = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                unmatched++;
            } else {
                if (unmatched > 0) {
                    unmatched--;
                } else {
                    swaps++;
                    unmatched++; // After swapping, this becomes an opening bracket
                }
            }
        }
        return swaps;
    }
}