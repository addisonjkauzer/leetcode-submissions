public class Node {
    Integer key;
    Integer value;
    Node previous;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.previous = null;
        this.next = null;
    }
}

class LRUCache {

    Integer capacity;
    Node left;
    Node right;
    HashMap<Integer, Node> keyToNode;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        left = new Node(-1, -1);
        right = new Node(-1, -1);
        left.next = right;
        right.previous = left;
        keyToNode = new HashMap<>();
        
    }
    
    public int get(int key) {
        if (!keyToNode.keySet().contains(key)) {
            return -1;
        }
        //Remove from linkedList
        final Node keyNode = keyToNode.get(key);
        final Node leftOfKey = keyNode.previous;
        final Node rightOfKey = keyNode.next;

        leftOfKey.next = rightOfKey;
        rightOfKey.previous = leftOfKey;

        //Add to end of linkedList
        final Node mostRecentNode = this.right.previous;

        mostRecentNode.next = keyNode;
        this.right.previous = keyNode;
        keyNode.previous = mostRecentNode;
        keyNode.next = this.right;

        return keyNode.value;
    }
    
    public void put(int key, int value) {

        if (keyToNode.containsKey(key)) {
            final Node oldKeyNode = keyToNode.get(key);
            //Remove from linkedList
            final Node leftOfKey = oldKeyNode.previous;
            final Node rightOfKey = oldKeyNode.next;

            leftOfKey.next = rightOfKey;
            rightOfKey.previous = leftOfKey;
        }

        final Node keyNode = new Node(key, value);

        //Add to end of linkedList
        final Node mostRecentNode = right.previous;
        mostRecentNode.next = keyNode;
        right.previous = keyNode;
        keyNode.previous = mostRecentNode;
        keyNode.next = right;

        //Add to map
        keyToNode.put(key, keyNode);

        //Remove LRU if over capacity
        if (keyToNode.keySet().size() > capacity) {
            final Node leastRecentNode = left.next;
            final Node rightOfLRU = leastRecentNode.next;
            left.next = leastRecentNode.next;
            rightOfLRU.previous = left;
            keyToNode.remove(leastRecentNode.key);
        }
    }
}
