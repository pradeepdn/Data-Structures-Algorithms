/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

/** First solutino using Map to set Random in two runs*/

// class Solution {
//     public Node copyRandomList(Node head) {
//         if (head == null)
//             return null;

//         Map<Node, Node> track = new HashMap<>();
//         Node dummy = head;
//         Node copy = new Node(dummy.val);
//         Node copyDummy = copy;

//         track.put(dummy, copy);
//         dummy = dummy.next;
//         while (dummy != null) {
//             Node newCopy = new Node(dummy.val);
//             copyDummy.next = newCopy;
//             copyDummy = newCopy;
//             track.put(dummy, copyDummy);
//             dummy = dummy.next;
//         }
//         dummy = head;
//         copyDummy = copy;

//         while (dummy != null) {
//             if (dummy.random != null) {
//                 copyDummy.random = track.get(dummy.random);
//             }
//             dummy = dummy.next;
//             copyDummy = copyDummy.next;
//         }

//         return copy;
//     }
// }

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node dummy = head;

        while (dummy != null) {
            Node newDummy = new Node(dummy.val);
            newDummy.next = dummy.next;
            dummy.next = newDummy;
            dummy = newDummy.next;
        }
        dummy = head;
        while (dummy != null) {
            if (dummy.random != null) {
                dummy.next.random = dummy.random.next;
            }
            dummy = dummy.next.next;
        }
        dummy = head;
        Node copyHead = head.next;

        while (dummy != null) {
            Node copy = dummy.next;
            dummy.next = copy.next;
            if (copy.next != null) {
                copy.next = copy.next.next;
            }
            dummy = dummy.next;
        }
        return copyHead;
    }
}