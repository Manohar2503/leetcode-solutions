import java.util.*;

class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        Integer[] indices = new Integer[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> {
            if (ages[a] != ages[b]) {
                return Integer.compare(ages[a], ages[b]);
            }
            return Integer.compare(scores[a], scores[b]);
        });

        int[] dp = new int[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int score = scores[indices[i]];
            dp[i] = score;

            for (int j = 0; j < i; j++) {
                if (scores[indices[j]] <= score) {
                    dp[i] = Math.max(dp[i], dp[j] + score);
                }
            }

            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }
}