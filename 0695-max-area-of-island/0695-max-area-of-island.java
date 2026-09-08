class Solution {
    int n,m;
    public int maxAreaOfIsland(int[][] grid) {
        int count=0;
        n=grid.length;
        m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]>0) count =Math.max(count,DFS(i,j,grid));
            }
        }
        return count;
    }
    public int DFS(int i,int j,int[][] grid){
        if(i<0||j<0||i>=n||j>=m||grid[i][j]<1){
            return 0;
        }
        grid[i][j]=0;
        return 1+DFS(i-1,j,grid)+DFS(i,j-1,grid)+DFS(i+1,j,grid)+DFS(i,j+1,grid);
    }
}