class Trie {
    static class Node{
        Node[] arr;
        boolean isComplete;
        Node(){
            arr = new Node[26];
            isComplete = false;
        }
    }
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node cur = root;
        for(char ch: word.toCharArray()){
            if(cur.arr[ch - 'a']==null) cur.arr[ch - 'a'] = new Node();
            cur = cur.arr[ch -'a'];
        }
        cur.isComplete = true;
    }
    
    public boolean search(String word) {
        Node cur = root;
        for(char ch: word.toCharArray()){
            if(cur.arr[ch - 'a']==null) return false;
            cur = cur.arr[ch -'a'];
        }
        return cur.isComplete;
    }
    
    public boolean startsWith(String prefix) {
        Node cur = root;
        for(char ch: prefix.toCharArray()){
            if(cur.arr[ch - 'a']==null) return false;
            cur = cur.arr[ch -'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */