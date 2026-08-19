import java.util.*;

class Solution {

    public long countTriplets(int[] arr, int l, int r) {

        Arrays.sort(arr);

        return countLessEqual(arr, r)
             - countLessEqual(arr, l - 1);
    }

    public long countLessEqual(int[] arr, int target) {

        long count = 0;
        int n = arr.length;

        for (int i = 0; i < n - 2; i++) {

            int left = i + 1;
            int right = n - 1;

            while (left < right) {

                int sum = arr[i] + arr[left] + arr[right];

                if (sum <= target) {

                    // left ke saath left+1 ... right
                    // sab valid honge
                    count += right - left;

                    left++;

                } else {
                    right--;
                }
            }
        }

        return count;
    }
}