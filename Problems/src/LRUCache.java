import java.util.HashMap;
import java.util.Map;

// #146
public class LRUCache {

    static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static Map<Integer,Node> cache = new HashMap<>();
    private static int capacity;
    private static Node head;
    private static Node tail;

    public LRUCache(int capacity) {
        LRUCache.capacity = capacity;
        cache = new HashMap<>();

        head = new Node(0,0);
        tail = new Node(0,0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }

        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);

        if (node != null) {
            node.value = value;
            moveToHead(node);
        }else {
            Node newNode = new Node(key, value);
            cache.put(key,newNode);
            addNode(newNode);

            if (cache.size() > capacity) {
                Node lru = tail.prev;
                removeNode(lru);
                cache.remove(key);
            }
        }
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void addNode(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public void printCache() {
        System.out.print("Cache Content (MRU -> LRU): ");

        Node current = head.next;

        while (current != tail) {
            System.out.print("[" + current.key + "=" + current.value + "] ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);

        System.out.println("put(1, 1)");
        lruCache.put(1, 1);
        lruCache.printCache();

        System.out.println("put(2, 2)");
        lruCache.put(2, 2);
        lruCache.printCache();

        System.out.println("get(1)");
        lruCache.get(1);
        lruCache.printCache();

        System.out.println("put(3, 3)");
        lruCache.put(3, 3);
        lruCache.printCache();
    }


}
