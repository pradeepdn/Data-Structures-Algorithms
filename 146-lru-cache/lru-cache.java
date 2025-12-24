public class ListNode {
    int key;
    int val;
    ListNode next;
    ListNode prev;

    ListNode() {
    }

    ListNode(int val, int key) {
        this.key = key;
        this.val = val;
    }

    ListNode(int val, ListNode next, ListNode prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

class LRUCache {

    private Map<Integer, ListNode> cache;
    private int capacity;
    private ListNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new ListNode(0, 0);
        tail = new ListNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            ListNode node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));

        } else if (cache.size() == capacity) {
            ListNode lruNode = tail.prev;
            remove(lruNode);
            cache.remove(lruNode.key);
        }
        ListNode newNode = new ListNode(value, key);
        insert(newNode);
        cache.put(key, newNode);
    }

    private void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

    }

    private void insert(ListNode node) {
        ListNode currentFirst = head.next;
        node.next = currentFirst;
        node.prev = head;

        head.next = node;
        currentFirst.prev = node;

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */