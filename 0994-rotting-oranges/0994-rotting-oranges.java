class Pair{
    int r;
    int c;
    int tm;
    Pair(int r,int c,int tm){
        this.r=r;
        this.c=c;
        this.tm=tm;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m= grid[0].length;
        boolean[][] vis= new boolean[n][m];
        Queue<Pair> qu = new LinkedList<>();
        int freshOranges = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    qu.offer(new Pair(i,j,0));
                    vis[i][j]=true;
                }
                if(grid[i][j]==1) freshOranges++;
            }
        }
        int time = 0;
        int[] drow = {-1,0,1,0};      //considering the up ,right, down, left cells
        int[] dcol = {0,1,0,-1};
        int oranges=0;
        while(!qu.isEmpty()){
            int row = qu.peek().r;
            int col = qu.peek().c;
            int tms = qu.peek().tm;
            time = Math.max(time,tms);
            qu.poll();
            for(int k=0;k<4;k++){
                int nrow= row + drow[k];
                int ncol = col + dcol[k];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol <m && !vis[nrow][ncol] && grid[nrow][ncol] ==1){
                    qu.offer(new Pair(nrow,ncol,tms+1));
                    vis[nrow][ncol] = true;
                    oranges++;
                }
            }
        }

      return (freshOranges==oranges)?time:-1;
    }

}
