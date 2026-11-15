class Solution {
    public int numOfSubarrays(int[] arr) {
        long MOD = 1_000_000_007;
        long oddCount = 0;
        long evenCount = 1; // Base case: prefix sum 0 (even)
        long currentPrefixSum = 0;
        long result = 0;
        
        for (int num : arr) {
            currentPrefixSum += num;
            
            // If current prefix sum is odd, add previous even prefix counts
            if (currentPrefixSum % 2 != 0) {
                result = (result + evenCount) % MOD;
                oddCount++;
            } 
            // If current prefix sum is even, add previous odd prefix counts
            else {
                result = (result + oddCount) % MOD;
                evenCount++;
            }
        }
        
        return (int) result;
    }
}