class Trie {
    static class Node{
        Node[] arr;
        String str;
        Node(){
            arr = new Node[26];
            str = null;
        }
    }

    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for(char ch: word.toCharArray()){
            int index = (int) (ch - 'a');
            if(node.arr[index]==null){
                node.arr[index] = new Node();
            }
            node = node.arr[index];
        }
        node.str = word;
    }
    
    public boolean search(String word) {
        Node node = root;
        for(char ch: word.toCharArray()){
            int index = (int) (ch - 'a');
            if(node.arr[index]==null){
                return false;
            }
            node = node.arr[index];
        }
        return node.str!=null;
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        for(char ch: prefix.toCharArray()){
            int index = (int) (ch - 'a');
            if(node.arr[index]==null){
                return false;
            }
            node = node.arr[index];
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