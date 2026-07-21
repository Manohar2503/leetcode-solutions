class MyHashMap {
    private class Node {
        int _key, _val;
        Node _next;

        Node(int key, int val) {
            this(key, val, null);
        }

        Node(int key, int val, Node next) {
            this._key = key;
            this._val = val;
            this._next = next;
        }
    }

    private final int _BUCKET_SIZE = 10000;
    private Node[] _buckets;
    public MyHashMap() {
        this._buckets = new Node[_BUCKET_SIZE];
    }
    
    public void put(int key, int value) {
        var index = hash(key);
        if (this._buckets[index] == null) {
            this._buckets[index] = new Node(key, value);
        } else {
            var node = this._buckets[index];
            while (node != null) {
                if (node._key == key) {
                    node._val = value;
                    return;
                }

                if (node._next == null) break;
                node = node._next;
            }

            node._next = new Node(key, value);
        }
    }

    private int hash(int key) {
        return key % this._BUCKET_SIZE;
    }
    
    public int get(int key) {
        var index = hash(key);
        var curr = this._buckets[index];
        if (curr != null) {
            while (curr != null) {
                if (curr._key == key) {
                    return curr._val;
                }

                curr = curr._next;
            }
        }

        return -1;
    }
    
    public void remove(int key) {
        var bucket = this._buckets[hash(key)];
        if (bucket == null) {
            return;
        }

        var prev = new Node(-1, -1, bucket);
        var curr = prev._next;
        while (curr != null) {
            if (curr._key == key) {
                prev._next = curr._next;
                this._buckets[hash(key)] = prev;
                return;
            }

            prev = curr;
            curr = curr._next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */