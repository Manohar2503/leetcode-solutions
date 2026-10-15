import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord,
                            List<String> wordList) {

        if (beginWord.equals(endWord)) return 1;

        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) return 0;

        Map<String, List<String>> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer(beginWord);
        wordSet.remove(beginWord);

        boolean found = false;

        while (!queue.isEmpty() && !found) {
            int size = queue.size();
            Set<String> visitedThisLevel = new HashSet<>();

            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                char[] chars = current.toCharArray();

                for (int j = 0; j < chars.length; j++) {
                    char original = chars[j];

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == original) continue;

                        chars[j] = ch;
                        String next = new String(chars);

                        if (next.equals(endWord)) {
                            map.computeIfAbsent(next,
                                    k -> new ArrayList<>()).add(current);
                            found = true;
                        } else if (wordSet.contains(next)) {
                            map.computeIfAbsent(next,
                                    k -> new ArrayList<>()).add(current);

                            if (visitedThisLevel.add(next)) {
                                queue.offer(next);
                            }
                        }
                    }

                    chars[j] = original;
                }
            }

            // Remove words only after processing the entire level.
            wordSet.removeAll(visitedThisLevel);
        }

        if (!found) return 0;

        int[] result = {Integer.MAX_VALUE};
        dfs(endWord, 1, beginWord, map, result);

        return result[0] == Integer.MAX_VALUE ? 0 : result[0];
    }

    private void dfs(String current, int count, String beginWord,
                     Map<String, List<String>> map, int[] result) {

        if (current.equals(beginWord)) {
            result[0] = Math.min(result[0], count);
            return;
        }

        for (String previous : map.getOrDefault(
                current, Collections.emptyList())) {
            dfs(previous, count + 1, beginWord, map, result);
        }
    }
}