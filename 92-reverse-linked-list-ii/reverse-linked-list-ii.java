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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode curr, nextNode, reversedHead;

        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        curr = prev.next;
        int count = right - left + 1;
        reversedHead = null;

        while (count >0){
            nextNode = curr.next;
            curr.next = reversedHead;
            reversedHead = curr;
            curr = nextNode;
            count --;
        }

        prev.next.next = curr;
        prev.next = reversedHead;



        return dummy.next;
    }
}