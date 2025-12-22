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
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode tail = head;
        ListNode prev = head;
        int length = 1;
        int counter = 0;

        while (tail.next != null) {
            length++;
            tail = tail.next;
        }

        int rotations = k % length;
        tail = head;
        
        while (tail.next != null) {
            counter++;    
            if (counter > rotations) {
                prev = prev.next;
            }
            tail = tail.next;
        }

        tail.next = head;
        head = prev.next;
        prev.next = null;
   
        return head;
    }
}