class Solution {

    public static int splitArray(int[] arr, int K) {
        int max = 0;
        int sum = 0;

        // find max element and total sum
        for(int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }

        int left = max;
        int right = sum;
        int ans = sum;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(canSplit(arr, K, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    // check if we can split into K subarrays
    public static boolean canSplit(int[] arr, int K, int maxSum) {
        int subarrays = 1;
        int currSum = 0;

        for(int i = 0; i < arr.length; i++) {
            currSum += arr[i];

            if(currSum > maxSum) {
                subarrays++;
                currSum = arr[i];
            }
        }

        return subarrays <= K;
    }

}