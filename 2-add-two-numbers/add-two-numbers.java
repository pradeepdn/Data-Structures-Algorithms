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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode nextNode = l3;
        int carry = 0;
        while (l1 != null || l2 != null) {

            int x = (l1 != null ? l1.val : 0);
            int y = (l2 != null ? l2.val : 0);
            int val = x + y + carry;

            if (val > 9) {
                val = val % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            nextNode.next = new ListNode(val);
            nextNode = nextNode.next;

            if(l1 != null) l1= l1.next;
            if(l2 != null) l2= l2.next;
            
        }
        if(carry == 1){
           nextNode.next = new ListNode(carry); 
        }
        return l3.next;
    }
}