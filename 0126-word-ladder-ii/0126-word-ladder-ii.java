class Solution {

    public List<List<String>> findLadders(
            String beginWord,
            String endWord,
            List<String> wordList) {

        List<List<String>> result = new ArrayList<>();

        Set<String> words = new HashSet<>(wordList);

        if (!words.contains(endWord)) {
            return result;
        }

        Map<String, List<String>> map = new HashMap<>();

        Queue<String> qu = new LinkedList<>();
        qu.offer(beginWord);

        // Words that have already been discovered
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        boolean found = false;

        while (!qu.isEmpty() && !found) {

            int size = qu.size();

            // Words discovered in this level
            Set<String> levelVisited = new HashSet<>();

            for (int i = 0; i < size; i++) {

                String value = qu.poll();

                char[] valueArr = value.toCharArray();

                for (int j = 0; j < valueArr.length; j++) {

                    char original = valueArr[j];

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        if (ch == original) {
                            continue;
                        }

                        valueArr[j] = ch;

                        String s = new String(valueArr);

                        if (words.contains(s)) {

                            // s can be reached from value
                            if (!visited.contains(s)) {

                                map.computeIfAbsent(
                                    s,
                                    k -> new ArrayList<>()
                                ).add(value);

                                levelVisited.add(s);

                                if (s.equals(endWord)) {
                                    found = true;
                                }
                            }
                            else if (levelVisited.contains(s)) {

                                // Another shortest parent
                                map.computeIfAbsent(
                                    s,
                                    k -> new ArrayList<>()
                                ).add(value);
                            }
                        }
                    }

                    valueArr[j] = original;
                }
            }

            visited.addAll(levelVisited);

            // Add newly discovered words to queue
            for (String word : levelVisited) {
                qu.offer(word);
            }
        }

        List<String> path = new ArrayList<>();

        dfs(
            endWord,
            beginWord,
            map,
            result,
            path
        );

        return result;
    }

    private void dfs(
            String src,
            String des,
            Map<String, List<String>> map,
            List<List<String>> result,
            List<String> path) {

        path.add(src);

        if (src.equals(des)) {

            List<String> temp = new ArrayList<>(path);

            Collections.reverse(temp);

            result.add(temp);

            path.remove(path.size() - 1);

            return;
        }

        if (!map.containsKey(src)) {
            path.remove(path.size() - 1);
            return;
        }

        for (String parent : map.get(src)) {

            dfs(
                parent,
                des,
                map,
                result,
                path
            );
        }

        path.remove(path.size() - 1);
    }
}