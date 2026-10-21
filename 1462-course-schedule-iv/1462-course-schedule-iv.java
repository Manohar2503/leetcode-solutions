
import java.util.*;

class Solution {
    public List<Boolean> checkIfPrerequisite(
            int numCourses,
            int[][] prerequisites,
            int[][] queries) {

        boolean[][] reachable = new boolean[numCourses][numCourses];

        // Step 1: Initialize direct prerequisites
        for (int[] p : prerequisites) {
            reachable[p[0]][p[1]] = true;
        }

        // Step 2: Compute indirect prerequisites
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    if (reachable[i][k] && reachable[k][j]) {
                        reachable[i][j] = true;
                    }
                }
            }
        }

        // Step 3: Answer queries
        List<Boolean> answer = new ArrayList<>();

        for (int[] q : queries) {
            answer.add(reachable[q[0]][q[1]]);
        }

        return answer;
    }
}
