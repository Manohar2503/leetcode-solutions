class WordDictionary {
    static class TrieNode{
        TrieNode[] array;
        boolean isWord;
        TrieNode(){
            array = new TrieNode[26];
            isWord = false;
        }
    }
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode cur = root;
        for(char ch: word.toCharArray()){
            if(cur.array[ch - 'a'] == null) cur.array[ch - 'a'] = new TrieNode();
            cur = cur.array[ch - 'a'];
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        return searchWord(0, word, root);
    }
    public boolean searchWord(int index, String word, TrieNode root){
        if(index == word.length()) return root.isWord;
        char ch = word.charAt(index);
        if(ch == '.'){
                for(int j=0;j<26;j++){
                    if(root.array[j]!=null && searchWord(index+1, word, root.array[j])) return true; 
                }
            }
        else if(root.array[ch - 'a']!= null && searchWord(index+1, word, root.array[ch-'a'])) return true;
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */