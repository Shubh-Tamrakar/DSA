class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {

        String res = "";
        int start = -1;
        int end = -1;

        HashMap<String, String> map = new HashMap<>();

        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                start = i;
            }

            if (start != -1) {

                if (s.charAt(i) == ')') {
                    end = i;
                }

                if (start != -1 && end != -1) {

                    String key = s.substring(start + 1, end);

                    if (map.containsKey(key)) {
                        res += map.get(key);
                    } else {
                        res += "?";
                    }

                    start = -1;
                    end = -1;
                }

            } else {
                res += s.charAt(i);
            }
        }

        return res;
    }
}