class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];

        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                count = Math.max(count, dfs(i, j, matrix, dp));
            }
        }

        return count;
    }

    static int dfs(int i, int j, int[][] matrix, int[][] dp) {

        // Already calculated
        if(dp[i][j] != 0){
            return dp[i][j];
        }

        int[][] adj = {
            {0,1},
            {1,0},
            {-1,0},
            {0,-1}
        };

        int count = 1;
        int val = matrix[i][j];

        for(int[] node : adj){

            int nr = i + node[0];
            int nc = j + node[1];

            if(nr >= 0 &&
               nr < matrix.length &&
               nc >= 0 &&
               nc < matrix[0].length &&
               matrix[nr][nc] > val){

                count = Math.max(
                    count,
                    1 + dfs(nr, nc, matrix, dp)
                );
            }
        }

        dp[i][j] = count;

        return count;
    }
}