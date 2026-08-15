class Solution {
    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();
       HashSet<Character> used = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {

            char a = s.charAt(i);
            char b = t.charAt(i);

            // a already mapped
            if (map.containsKey(a)) {
                if (map.get(a) != b) {
                    return false;
                }
            }
            // a is new
            else {
                // b is already mapped to some other character
               if(used.contains(b)) {
                return false;
               }

                map.put(a, b);
                used.add(b);
            }
        }

        return true;
    }
}