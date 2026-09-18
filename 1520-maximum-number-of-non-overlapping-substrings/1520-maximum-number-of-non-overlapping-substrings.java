class Solution { 
    public List<String> maxNumOfSubstrings(String s) {
         int[] first = new int[26];
          int[] last = new int[26]; 
          Arrays.fill(first, -1);
           for (int i = 0; i < s.length(); i++) {
             int ch = s.charAt(i) - 'a';
              if (first[ch] == -1) { first[ch] = i; 
              }
               last[ch] = i;
                
                } 
                List<int[]> intervals = new ArrayList<>();
                 for (int ch = 0; ch < 26; ch++) { 
                    if (first[ch] == -1) {
                         continue; 
                         } 
                         int left = first[ch]; 
                         int right = last[ch];
                          boolean valid = true; 
                          for (int i = left; i <= right; i++) {
                             int curr = s.charAt(i) - 'a';  
                             if (first[curr] < left) { 
                                valid = false; break;
                                 }
                                 right = Math.max(right, last[curr]);
                                  }
                                   if (valid) {
                                     intervals.add(new int[]{left, right});
                                      }
                                       } 
                                        intervals.sort((a, b) -> a[1] - b[1]); List<String> ans = new ArrayList<>();
                                         int end = -1;
                                           for (int[] interval : intervals) {
                                             if (interval[0] > end) { 
                                                ans.add(s.substring(interval[0], interval[1] + 1));
                                                 end = interval[1]; 
                                                 }
                                                  }
                                                   return ans;
                                                    } 
                                                    }
