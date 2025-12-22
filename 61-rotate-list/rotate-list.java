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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0, head);
        ListNode tail = head;
        ListNode prev = dummy;

        int length = 1;

        while (tail.next != null) {
            length++;
            tail = tail.next;
            
        }
        
        int rotations = k % length;
        tail = head;
        while (rotations > 0) {

            while (tail.next != null) {
                tail = tail.next;
                prev = prev.next;
            }

            tail.next = head;
            head = tail;
            prev.next = null;
            dummy.next = tail;
            prev = dummy;
            rotations--;
        }
        return dummy.next;

    }
}