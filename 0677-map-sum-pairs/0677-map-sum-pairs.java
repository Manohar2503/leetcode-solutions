
 class MapSum {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int sum = 0;
    }

    private TrieNode root;
    private HashMap<String, Integer> map;

    public MapSum() {
        root = new TrieNode();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {

        int oldValue = map.getOrDefault(key, 0);
        int difference = val - oldValue;
        map.put(key, val);
        TrieNode current = root;

        for (char ch : key.toCharArray()) {
            int index = ch - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
            current.sum += difference;
        }
    }

    public int sum(String prefix) {

        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';

            if (current.children[index] == null) {
                return 0;
            }

            current = current.children[index];
        }

        return current.sum;
    }
}