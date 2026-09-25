class AllOne {

    // Each node represents one frequency.
    // Example:
    // count = 2, keys = {"apple", "banana"}
    static class Node {
        int count;
        Set<String> keys;

        Node prev;
        Node next;

        Node(int count) {
            this.count = count;
            keys = new HashSet<>();
        }
    }

    // key -> the frequency node containing that key
    Map<String, Node> map;

    Node head;
    Node tail;

    public AllOne() {
        map = new HashMap<>();

        // Dummy nodes
        head = new Node(0);
        tail = new Node(0);

        head.next = tail;
        tail.prev = head;
    }

    public void inc(String key) {

        // Key does not exist
        if (!map.containsKey(key)) {

            // Need frequency 1
            Node first = head.next;

            if (first == tail || first.count != 1) {
                Node newNode = new Node(1);
                addAfter(head, newNode);
                first = newNode;
            }

            first.keys.add(key);
            map.put(key, first);

        } else {

            // Current frequency node
            Node current = map.get(key);

            int newCount = current.count + 1;

            Node next = current.next;

            // Need to create a bucket for new frequency
            if (next == tail || next.count != newCount) {
                Node newNode = new Node(newCount);
                addAfter(current, newNode);
                next = newNode;
            }

            // Move key from current bucket to next bucket
            current.keys.remove(key);
            next.keys.add(key);

            map.put(key, next);

            // Remove empty frequency bucket
            if (current.keys.isEmpty()) {
                removeNode(current);
            }
        }
    }

    public void dec(String key) {

        Node current = map.get(key);

        int newCount = current.count - 1;

        // Remove key from current bucket
        current.keys.remove(key);

        if (newCount == 0) {

            // Key completely disappears
            map.remove(key);

        } else {

            Node prev = current.prev;

            // Need frequency newCount bucket
            if (prev == head || prev.count != newCount) {
                Node newNode = new Node(newCount);
                addAfter(prev, newNode);
                prev = newNode;
            }

            // Move key to previous frequency bucket
            prev.keys.add(key);
            map.put(key, prev);
        }

        // Remove empty bucket
        if (current.keys.isEmpty()) {
            removeNode(current);
        }
    }

    public String getMaxKey() {

        if (tail.prev == head) {
            return "";
        }

        // Any key from the highest-frequency bucket
        return tail.prev.keys.iterator().next();
    }

    public String getMinKey() {

        if (head.next == tail) {
            return "";
        }

        // Any key from the lowest-frequency bucket
        return head.next.keys.iterator().next();
    }

    // Insert newNode immediately after prev
    private void addAfter(Node prev, Node newNode) {

        newNode.next = prev.next;
        newNode.prev = prev;

        prev.next.prev = newNode;
        prev.next = newNode;
    }

    // Remove a frequency bucket
    private void removeNode(Node node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}