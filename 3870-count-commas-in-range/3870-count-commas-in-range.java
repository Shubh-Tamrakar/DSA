class Solution {
    public int countCommas(int n) {
        int dig = String.valueOf(n).length();
       if(dig < 4) return 0;
       else {
        return n - (int)Math.pow(10,dig-1) +1;
       }
    }
}