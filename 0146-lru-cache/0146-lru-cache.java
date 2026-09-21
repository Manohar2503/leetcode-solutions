class LRUCache {
    static class Node{
        int key, val;
        Node prev, next;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;
    private Node head , tail;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;    
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        addFirst(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            remove(node);
            addFirst(node);
        }
        else{
            if(capacity==0){
                Node removedNode = removeLast();
                map.remove(removedNode.key);
                capacity++;
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addFirst(newNode);
            capacity--;
        }
    }

    public Node removeLast(){
        Node lastNode = tail.prev;
        lastNode.prev.next = tail;
        tail.prev = lastNode.prev;
        return lastNode;       
    }
    public void addFirst(Node node){
        Node nextNode = head.next;
        head.next = node;
        node.next = nextNode;
        node.prev = head;
        nextNode.prev = node;
    }

    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */