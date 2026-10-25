class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
         Map<String, List<String>> map = new HashMap<>();
        for(int i =0;i<strs.length;i++) {
           // List<String> ans = new ArrayList<>();
            char s[] = strs[i].toCharArray();
            Arrays.sort(s);
            String news = new String(s);
           if (!map.containsKey(news)) {
                map.put(news, new ArrayList<>());
            }
            map.get(news).add(strs[i]);
        }
        res.addAll(map.values());
        return res;
    }
}