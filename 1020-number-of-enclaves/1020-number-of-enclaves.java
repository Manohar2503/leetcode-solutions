class Solution {
    int[] drow ={-1,0,1,0};
    int[] dcol  = {0,1,0,-1};
    int count=0;
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n= grid[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || i==m-1 || j==0 || j==n-1){
                    if(grid[i][j]==1){
                        dfs(i,j,grid,vis);
                    }
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                    if(vis[i][j]==false && grid[i][j]==1){
                        count++;
                    }
            }
        }
        return count;
    }

    void dfs(int row,int col,int[][] grid,boolean[][] vis){
        if(vis[row][col]){
            return ;
        }
        vis[row][col]=true;
        for(int i=0;i<4;i++){
            int r= row + drow[i];
            int c = col + dcol[i];
            if(r>0 && r<grid.length && c>0 && c<grid[0].length && grid[r][c]==1 && !vis[r][c]){
                dfs(r,c,grid,vis);
            }
        }
    }
}

