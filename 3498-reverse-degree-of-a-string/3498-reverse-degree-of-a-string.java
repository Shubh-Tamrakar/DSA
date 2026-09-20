class Solution {
    public int reverseDegree(String s) {
        int total = 0;
        for(int i =0;i<s.length();i++) {
            int ch = s.charAt(i)-'a';
            ch++;
            total += (27-ch)*(i+1);
        }
        return total;
    }
}