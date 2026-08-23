class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<Integer> set1 = new HashSet<>();
        List<Integer> list1 = new ArrayList<>();
        for(int ele : nums2) {
            set1.add(ele);
        }
        for(int ele : nums1) {
            if(!set1.contains(ele)) {
                if(!list1.contains(ele)) {
                  list1.add(ele);
                }
            }
        }

        HashSet<Integer> set2 = new HashSet<>();
        List<Integer> list2 = new ArrayList<>();
        for(int ele : nums1) {
            set2.add(ele);
        }
        for(int ele : nums2) {
            if(!set2.contains(ele)) {
                if(!list2.contains(ele)) {
                 list2.add(ele);
                }
            }
        }

        ans.add(list1);
        ans.add(list2);

        return ans;
    }
}