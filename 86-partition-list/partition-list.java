/**
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
    public ListNode partition(ListNode head, int x) {
        ListNode headDummy = head;
        ListNode less = new ListNode(0, null);
        ListNode greater = new ListNode(0, null);
        ListNode greaterdummy = greater;
        ListNode lessdummy = less;
        /**using two new linked lists and joining them */
        // while (headDummy != null) {
        //     if (headDummy.val < x) {
        //         less.next = new ListNode(headDummy.val, null);
        //         less = less.next;    
        //     }
        //     if (headDummy.val >= x) {
        //         greater.next = new ListNode(headDummy.val, null);
        //         greater = greater.next;
        //     }
        //     headDummy = headDummy.next;
        // }
        /**using head linked lists seperating the less and grearter then x and joining them */
        while (headDummy != null) {
            ListNode nextNode = headDummy.next;

            if (headDummy.val < x) {
                less.next = headDummy;
                less = less.next;
                less.next = null;
            }
            if (headDummy.val >= x) {
                greater.next = headDummy;
                greater = greater.next;
                greater.next = null;
            }
            headDummy = nextNode;
        }

        less.next = greaterdummy.next;

        return lessdummy.next;
    }
}