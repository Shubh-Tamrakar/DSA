class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int pre[] = new int[nums.length];
        pre[0] = nums[0];
        for(int i =1;i<nums.length;i++) {
            pre[i] = Math.max(pre[i-1] , nums[i]);
        }

        int suf[] = new int[nums.length];
        suf[nums.length-1] = nums[nums.length-1];
        for(int i =nums.length-2;i>=0;i--) {
            suf[i] = Math.min(suf[i+1] , nums[i]);
        }

        int stableInd = Integer.MAX_VALUE;
        
        for(int i =0;i<nums.length;i++) {
            if(pre[i] - suf[i] <= k) {
                if(i < stableInd) {
                    stableInd = i;
                }
            }
        }


        if(stableInd != Integer.MAX_VALUE) {
            return stableInd;
        }
        return -1;
    }
}