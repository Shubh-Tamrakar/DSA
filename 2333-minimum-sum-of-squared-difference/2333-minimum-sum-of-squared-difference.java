import java.util.TreeMap;

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long totalK = (long) k1 + k2;
        
        // Count frequencies of each absolute difference
        TreeMap<Integer, Long> countMap = new TreeMap<>();
        long totalDiffSum = 0;
        
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            if (diff > 0) {
                countMap.put(diff, countMap.getOrDefault(diff, 0L) + 1L);
                totalDiffSum += diff;
            }
        }
        
        // If total allowed operations can reduce all differences to 0
        if (totalDiffSum <= totalK) {
            return 0;
        }
        
        // Greedily reduce the largest differences from the back of the TreeMap
        while (totalK > 0 && !countMap.isEmpty()) {
            int maxDiff = countMap.lastKey();
            long count = countMap.get(maxDiff);
            
            // Fixed: pass maxDiff to lowerKey(maxDiff)
            Integer lowerKey = countMap.lowerKey(maxDiff);
            int nextDiff = (lowerKey == null) ? 0 : lowerKey;
            
            long diffDrop = maxDiff - nextDiff;
            long totalCanReduce = diffDrop * count;
            
            if (totalK >= totalCanReduce) {
                // We can bring all occurrences of maxDiff down to nextDiff
                countMap.remove(maxDiff);
                if (nextDiff > 0) {
                    countMap.put(nextDiff, countMap.getOrDefault(nextDiff, 0L) + count);
                }
                totalK -= totalCanReduce;
            } else {
                // We cannot bring all down, distribute totalK as evenly as possible
                long canReduceCount = totalK / count;
                long remainder = totalK % count;
                
                countMap.remove(maxDiff);
                
                int newDiff = maxDiff - (int) canReduceCount;
                countMap.put(newDiff, countMap.getOrDefault(newDiff, 0L) + (count - remainder));
                
                if (remainder > 0) {
                    countMap.put(newDiff - 1, countMap.getOrDefault(newDiff - 1, 0L) + remainder);
                }
                
                totalK = 0;
            }
        }
        
        // Calculate the final minimum sum of squared differences
        long minSumSquares = 0;
        for (var entry : countMap.entrySet()) {
            long diff = entry.getKey();
            long count = entry.getValue();
            minSumSquares += count * diff * diff;
        }
        
        return minSumSquares;
    }
}