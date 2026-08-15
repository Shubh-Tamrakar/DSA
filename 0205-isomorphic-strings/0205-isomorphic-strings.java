class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        int freq1[] = new int[256];
        int freq2[] = new int[256];
       

          for(int i =0;i<s.length() ;i++) {
            if( freq1[s.charAt(i)] !=  freq2[t.charAt(i)]) {
                return false;
            }
            freq1[s.charAt(i) ] = i+1;
            freq2[t.charAt(i) ] = i+1;
        }
        return true;
    }
}