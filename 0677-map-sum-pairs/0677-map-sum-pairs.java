class MapSum {
    static class Trie{
        Trie[] tree;
        List<String> words;

        Trie(){
            tree = new Trie[26];
            words = new ArrayList<>();
        }
    }
    
    Map<String, Integer> map;
    Trie root;
    public MapSum() {
        map = new HashMap<>();
        root = new Trie();
    }
    
    public void insert(String key, int val) {
        if(!map.containsKey(key)){
            construct(key);
        }
        map.put(key, val);
    }
    
    public void construct(String word){
        Trie node = root;
        for(char c: word.toCharArray()){
            int index = c - 'a';
            if(node.tree[index] == null) node.tree[index] = new Trie();
            node = node.tree[index];
            node.words.add(word);
        }
    }

    public int sum(String prefix) {
        Trie node = root;
        for(char c: prefix.toCharArray()){
            int index = c - 'a';
            if(node.tree[index] == null) return 0; 
            node = node.tree[index];
        }
        
        int result =0;
        List<String> list = node.words;
        for(String key: list){
            result += map.get(key);
        }

        return result;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */