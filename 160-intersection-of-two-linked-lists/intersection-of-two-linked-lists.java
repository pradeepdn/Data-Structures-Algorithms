/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA == null || headB == null){
            return null;
        }  

        ListNode dummyA = headA;
        ListNode dummyB = headB;

        while(dummyA != dummyB){
            if(dummyA == null){
                dummyA = headB;
            }else{
                dummyA = dummyA.next;
            }
            if(dummyB == null){
                dummyB = headA;
            }else{
            dummyB = dummyB.next;
            }
        }
        return dummyB;
    }
}