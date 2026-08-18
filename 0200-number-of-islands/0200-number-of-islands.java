class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dir = {{-1,0}, {1,0}, {0,-1},{0,1}};
        int count=0;
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!='0'){
                    count++;
                    dfs(i,j,grid,dir);
                }
            }
        }
        return count;
    }

    static void dfs(int r, int c, char[][] grid, int[][] dir){
        if(grid[r][c]=='0') return;
        grid[r][c]='0';

        for(int[] newdir:dir){
            int nr = r + newdir[0];
            int nc = c + newdir[1];

            if(nr >=0 && nr < grid.length && nc>=0 && nc < grid[0].length && grid[nr][nc]=='1'){
                dfs(nr,nc,grid,dir);
            }
        }
    }
}