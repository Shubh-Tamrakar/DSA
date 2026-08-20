class Solution {
    public int[] resultArray(int[] nums) {

        int n = nums.length;

        int[] res = new int[n];

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        list1.add(nums[0]);
        list2.add(nums[1]);

        for (int i = 2; i < n; i++) {

            if (list1.get(list1.size() - 1) >
                list2.get(list2.size() - 1)) {

                list1.add(nums[i]);

            } else {

                list2.add(nums[i]);
            }
        }

        int ind = 0;

        for (int el : list1) {
            res[ind++] = el;
        }

        for (int el : list2) {
            res[ind++] = el;
        }

        return res;
    }
}