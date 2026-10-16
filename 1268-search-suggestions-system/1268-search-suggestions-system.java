
import java.util.*;

class Solution {
    static class Trie {
        Trie[] tree;
        List<String> words;

        Trie() {
            tree = new Trie[26];
            words = new ArrayList<>();
        }
    }

    Trie root;

    public List<List<String>> suggestedProducts(
            String[] products, String searchWord) {

        root = new Trie();

        Arrays.sort(products);

        for (String str : products) {
            construct(str, root);
        }

        List<List<String>> similarWords = new ArrayList<>();
        products(searchWord, similarWords, root);

        return similarWords;
    }

    static void construct(String word, Trie root) {
        Trie node = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (node.tree[index] == null) {
                node.tree[index] = new Trie();
            }

            node = node.tree[index];

            if (node.words.size() < 3) {
                node.words.add(word);
            }
        }
    }

    static void products(
            String searchWord,
            List<List<String>> similarWords,
            Trie root) {

        Trie node = root;
        boolean found = true;

        for (char ch : searchWord.toCharArray()) {
            int index = ch - 'a';

            if (found && node.tree[index] != null) {
                node = node.tree[index];
                similarWords.add(new ArrayList<>(node.words));
            } else {
                found = false;
                similarWords.add(new ArrayList<>());
            }
        }
    }
}
