class Solution {

    public String shortestSuperstring(String[] words) {
        int n = words.length;

        // 1. Calculate maximum overlap between every pair
        int[][] overlap = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                int max = Math.min(words[i].length(), words[j].length());

                for (int k = max; k >= 1; k--) {
                    if (words[i].endsWith(words[j].substring(0, k))) {
                        overlap[i][j] = k;
                        break;
                    }
                }
            }
        }

        // 2. DP initialization
        int totalMasks = 1 << n;
        int[][] dp = new int[totalMasks][n];
        int[][] parent = new int[totalMasks][n];

        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        for (int[] row : parent) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < n; i++) {
            dp[1 << i][i] = words[i].length();
        }

        // 3. Bitmask DP
        for (int mask = 1; mask < totalMasks; mask++) {

            for (int last = 0; last < n; last++) {

                if ((mask & (1 << last)) == 0) continue;
                if (dp[mask][last] == Integer.MAX_VALUE) continue;

                for (int next = 0; next < n; next++) {

                    if ((mask & (1 << next)) != 0) continue;

                    int newMask = mask | (1 << next);

                    int newLength = dp[mask][last]
                            + words[next].length()
                            - overlap[last][next];

                    if (newLength < dp[newMask][next]) {
                        dp[newMask][next] = newLength;
                        parent[newMask][next] = last;
                    }
                }
            }
        }

        // 4. Find the best ending word
        int target = totalMasks - 1;
        int last = 0;

        for (int i = 1; i < n; i++) {
            if (dp[target][i] < dp[target][last]) {
                last = i;
            }
        }

        // 5. Reconstruct the optimal order
        List<Integer> path = new ArrayList<>();

        int mask = target;

        while (last != -1) {
            path.add(last);

            int prev = parent[mask][last];

            mask ^= (1 << last);
            last = prev;
        }

        Collections.reverse(path);

        // 6. Construct the shortest superstring
        StringBuilder result = new StringBuilder(words[path.get(0)]);

        for (int i = 1; i < path.size(); i++) {
            int prev = path.get(i - 1);
            int curr = path.get(i);

            result.append(words[curr].substring(overlap[prev][curr]));
        }

        return result.toString();
    }
}