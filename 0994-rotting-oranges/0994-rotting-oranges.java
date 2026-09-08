class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean flag = false;
        Queue<int[]> qu = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    qu.offer(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    flag = true;
                }
            }
        }

        if(qu.size()==0 && !flag) return 0;
        if(qu.size() ==0 && flag) return -1;
        int[][] adj = {{-1,0},{1,0},{0,-1},{0,1}};
        int count =0;

        while(!qu.isEmpty()){
            int len = qu.size();
            count++;
            for(int i=0;i<len;i++){
                  int[] cur = qu.poll();
                  for(int[] arr: adj){
                      int nr = cur[0] + arr[0];
                      int nc = cur[1] + arr[1];
                      if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==1){
                          grid[nr][nc] = 2;
                          qu.offer(new int[]{nr,nc});
                      }
                  }
            }
            
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return count-1;
    }
}