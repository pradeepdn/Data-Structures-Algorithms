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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode dummy = head;

        while(dummy!=null){
            if(dummy.next!= null && dummy.next.val == dummy.val){
                dummy.next = dummy.next.next;
            }else{
                dummy = dummy.next;
            }
        }
        return head;
    }
}