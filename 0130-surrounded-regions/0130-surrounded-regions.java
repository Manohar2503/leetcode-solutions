class Solution {
    int[] drow ={-1,0,1,0};
    int[] dcol = {0,1,0,-1};
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || i==m-1 || j==0 || j==n-1){
                    if(board[i][j]=='O'){
                        // vis[i][j]=true;
                        dfs(i,j,board,vis);
                    }
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j]){
                    board[i][j]='X';
                }
            }
        }
    }
    void dfs(int r,int c,char[][] board,boolean[][] vis){
        if(vis[r][c]){
            return;
        }
        vis[r][c]=true;
        for(int i=0;i<4;i++){
            int row = r+ drow[i];
            int col = c+dcol[i];
            if(row>0 && row<board.length && col>0 && col<board[0].length && !vis[row][col] && board[row][col]=='O'){
                dfs(row,col,board,vis);
            }
        }
    }
}