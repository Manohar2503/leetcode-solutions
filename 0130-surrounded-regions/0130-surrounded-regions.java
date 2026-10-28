class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] adjNodes = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        boolean[][] dp = new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0 || j ==0 || i==n-1 || j== m-1) && board[i][j] == 'O'){
                    dfs(i,j,n,m,board,adjNodes,dp);
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!dp[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }

    static void dfs(int r, int c, int n, int m, char[][] board, int[][] adjNodes, boolean[][] dp){
        
        dp[r][c] = true;
        for(int[] nodes: adjNodes){
            int nr = r + nodes[0];
            int nc = c + nodes[1];
            if(nr>=0 && nr<n && nc>=0 && nc<m && board[nr][nc] == 'O' && !dp[nr][nc]){
                dfs(nr,nc,n,m,board,adjNodes,dp);
            }
        }
    }
}