class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int nrows = grid.length;
        int ncols = grid[0].length; 
        int result =0;

        for(int i=0;i<nrows;i++){
            for(int j=0;j<ncols;j++){
                if(grid[i][j] == 1){
                    result = Math.max(result, bfs(i, j, grid));
                } 
            }
        }

        return result;
    }

    static int bfs(int r, int c, int[][] grid){
        Queue<int[]> qu = new LinkedList<>();
        qu.offer(new int[]{r,c});
        grid[r][c] =0;
        int count =0;
        int[][] adj = {{0,-1},{-1,0},{0,1},{1,0}};

        while(!qu.isEmpty()){
            int[] cur = qu.poll();
            count++;
            for(int[] n:adj){
                int nr = cur[0] + n[0];
                int nc = cur[1] + n[1];

                if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc] ==1){
                    grid[nr][nc] =0;
                    qu.offer(new int[]{nr,nc});
                }
            }
        }

        return count;
    }
}