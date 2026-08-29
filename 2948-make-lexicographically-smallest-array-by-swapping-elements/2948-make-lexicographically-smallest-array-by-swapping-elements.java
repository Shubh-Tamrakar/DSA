import java.util.*;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {

        int n = nums.length;

        int[][] arr = new int[n][2];

        // value and original index store karo
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        // values ke according sort
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int i = 0;

        while (i < n) {

            int j = i;

            // ek group find karo
            while (j + 1 < n &&
                   arr[j + 1][0] - arr[j][0] <= limit) {
                j++;
            }

            // group ke indices collect karo
            List<Integer> indices = new ArrayList<>();

            for (int k = i; k <= j; k++) {
                indices.add(arr[k][1]);
            }

            Collections.sort(indices);

            // sorted values ko sorted indices par assign karo
            for (int k = 0; k < indices.size(); k++) {
                nums[indices.get(k)] = arr[i + k][0];
            }

            i = j + 1;
        }

        return nums;
    }
}