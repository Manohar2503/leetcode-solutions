class Solution {

    static class Trie {
        Trie[] arr = new Trie[26];
        int count;
        String str;
    }

    static Trie root;

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        root = new Trie();

    for(String str : strs)
        construct(str);

    Trie node = root;
    String result = "";

    for(char ch : strs[0].toCharArray()){
        int value = ch - 'a';

        if(node.arr[value] != null &&
           node.arr[value].count == strs.length) {

            node = node.arr[value];
            result += ch;

        } else {
            break;
        }
    }

    return result;
    }

    static void construct(String str) {
        Trie node = root;
        StringBuilder sb = new StringBuilder();

        for (char ch : str.toCharArray()) {
            sb.append(ch);

            int value = ch - 'a';

            if (node.arr[value] == null) {
                node.arr[value] = new Trie();
            }

            node = node.arr[value];
            node.count++;

            node.str = sb.toString();
        }
    }
}