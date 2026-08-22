class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        if(rows==0 && cols ==0) return -1;
        if(grid[0][0]==1) return -1;
        int result = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        grid[0][0]=1;
        int[][] adjIndexs = {{-1,0},{0,-1},{0,1},{1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
        
        while(!q.isEmpty()){
            result++;
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] cu = q.poll();
            int r = cu[0];
            int c = cu[1];
            if(r==rows-1 && c == cols-1) return result;
            for(int[] adj: adjIndexs){
                int nr = r + adj[0];
                int nc = c + adj[1];
                if(nr >=0 && nr < rows && nc >=0 && nc < cols && grid[nr][nc]==0){
                    grid[nr][nc]=1;
                    q.offer(new int[]{nr,nc});
                }
            }
            }
        }

        return -1;
    }
}