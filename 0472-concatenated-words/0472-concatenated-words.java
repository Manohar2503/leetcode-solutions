
class Solution {

    static class Trie {
        Trie[] arr = new Trie[26];
        boolean isEnd;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        Trie root = new Trie();

        // Step 1: Construct Trie
        for (String word : words) {
            construct(word, root);
        }

        // Step 2: Check each word
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (isConcatenated(word, root)) {
                result.add(word);
            }
        }

        return result;
    }

    private void construct(String word, Trie root) {

        Trie cur = root;

        for (char c : word.toCharArray()) {

            int index = c - 'a';

            if (cur.arr[index] == null) {
                cur.arr[index] = new Trie();
            }

            cur = cur.arr[index];
        }

        // Mark only the terminal node
        cur.isEnd = true;
    }

    private boolean isConcatenated(String word, Trie root) {

        int n = word.length();

        int[] dp = new int[n + 1];

        Arrays.fill(dp, -1);

        dp[0] = 0;

        for (int i = 0; i < n; i++) {

            if (dp[i] == -1) continue;

            Trie cur = root;

            for (int j = i; j < n; j++) {

                int index = word.charAt(j) - 'a';

                if (cur.arr[index] == null) {
                    break;
                }

                cur = cur.arr[index];

                if (cur.isEnd) {

                    dp[j + 1] = Math.max(
                        dp[j + 1],
                        dp[i] + 1
                    );
                }
            }
        }

        return dp[n] >= 2;
    }
}
