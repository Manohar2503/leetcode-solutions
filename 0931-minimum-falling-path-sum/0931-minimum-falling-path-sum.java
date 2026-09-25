class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        int result = Integer.MAX_VALUE;

        for(int col=0;col<n;col++){
            result = Math.min(result, path(0, col, matrix, dp));
        }
        return result;
    }

    static int path(int r, int c, int[][] matrix, int[][] dp){
        if(r<0 || r>=matrix.length || c<0 || c>=matrix.length) return Integer.MAX_VALUE;
        if(dp[r][c]!=Integer.MAX_VALUE) return dp[r][c];
        if(r==matrix.length-1) return matrix[r][c];

        int leftDown = path(r+1, c-1, matrix, dp);
        int down = path(r+1, c, matrix, dp);
        int rightDown = path(r+1, c+1, matrix, dp);

        int minVal = Math.min(leftDown, Math.min(rightDown, down));
        return dp[r][c] = (minVal == Integer.MAX_VALUE)?0:minVal+ matrix[r][c];
    }
}