import java.util.*;

class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    HashMap<Integer, Node> map;

    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        map = new HashMap<>();

        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void addFirst(Node node) {
        node.next = head.next;
        head.next.prev = node;

        head.next = node;
        node.prev = head;
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        // Make it most recently used
        remove(node);
        addFirst(node);

        return node.value;
    }

    public void put(int key, int value) {

        // Key already exists
        if (map.containsKey(key)) {

            Node node = map.get(key);

            node.value = value;

            // Make it most recently used
            remove(node);
            addFirst(node);

            return;
        }

        // Cache is full
        if (map.size() == capacity) {

            Node lru = tail.prev;

            remove(lru);
            map.remove(lru.key);
        }

        // Add new node
        Node node = new Node(key, value);

        map.put(key, node);
        addFirst(node);
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */