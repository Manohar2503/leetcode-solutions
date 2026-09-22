class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count =0;
        int[][] adj = {{0,1},{1,0},{0,-1},{-1,0}};

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    count = Math.max(count, dfs(i, j, grid, adj));
                }
            }
        }

        return count;
    }

    static int dfs(int r, int c, int[][] grid, int[][] adj){
        grid[r][c] = 0;
        int count =1;

        for(int[] adjNode : adj){
            int nr = r + adjNode[0];
            int nc = c + adjNode[1];
            
            if(nr>=0 && nr< grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]==1){
                count += dfs(nr, nc, grid, adj);
            }
        }

        return count;
    }
}