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

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Map<Node, Node> track = new HashMap<>();
        Node dummy = head;
        Node copy = new Node(dummy.val);
        Node copyDummy = copy;

        track.put(dummy, copy);
        dummy = dummy.next;
        while (dummy != null) {
            Node newCopy = new Node(dummy.val);
            copyDummy.next = newCopy;
            copyDummy = newCopy;
            track.put(dummy, copyDummy);
            dummy = dummy.next;
        }
        dummy = head;
        copyDummy = copy;

        while (dummy != null) {
            if (dummy.random != null) {
                copyDummy.random = track.get(dummy.random);
            }
            dummy = dummy.next;
            copyDummy = copyDummy.next;
        }

        return copy;
    }
}