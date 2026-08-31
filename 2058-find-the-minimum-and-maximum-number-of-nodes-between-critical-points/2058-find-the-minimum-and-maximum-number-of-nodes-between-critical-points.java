/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        ListNode prev = head;
        ListNode curr = head.next;

        int index = 1;

        int first = -1;
        int last = -1;

        int minDistance = Integer.MAX_VALUE;

        while (curr != null && curr.next != null) {

            boolean isCritical = false;

            // Local Maximum
            if (curr.val > prev.val && curr.val > curr.next.val) {
                isCritical = true;
            }

            // Local Minimum
            if (curr.val < prev.val && curr.val < curr.next.val) {
                isCritical = true;
            }

            if (isCritical) {

                // First critical point
                if (first == -1) {
                    first = index;
                }

                // Agar pehle bhi critical point mila hai
                if (last != -1) {
                    minDistance = Math.min(
                        minDistance,
                        index - last
                    );
                }

                // Current critical point ko last bana do
                last = index;
            }

            prev = curr;
            curr = curr.next;
            index++;
        }

        // 2 critical points nahi mile
        if (first == -1 || first == last) {
            return new int[]{-1, -1};
        }

        return new int[]{
            minDistance,
            last - first
        };
    }
}