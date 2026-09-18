class Solution {
    static class Node {
        Node[] arr = new Node[26];
        String word;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        Node root = new Node();

        // Build Trie
        for (String word : dictionary) {
            Node node = root;

            for (char ch : word.toCharArray()) {
                if (node.arr[ch - 'a'] == null) {
                    node.arr[ch - 'a'] = new Node();
                }

                node = node.arr[ch - 'a'];
            }

            node.word = word;
        }

        StringBuilder sb = new StringBuilder();

        // Search each word
        for (String word : words) {
            Node node = root;
            String replacement = word;

            for (char ch : word.toCharArray()) {

                if (node.arr[ch - 'a'] == null) {
                    break;
                }

                node = node.arr[ch - 'a'];

                // Found a root
                if (node.word != null) {
                    replacement = node.word;
                    break;
                }
            }

            sb.append(replacement).append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}