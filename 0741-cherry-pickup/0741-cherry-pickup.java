class Solution {
    public int cherryPickup(int[][] grid) {
        int r1=0,r2=0,c1=0;
        int n=grid.length;
        int[][][] dp=new int[n][n][n];
        for(int[][] a:dp){
            for(int[] b:a){
                Arrays.fill(b,-1);
            }
        }
        int ans=find(grid,0,0,0,dp);
        return ans==Integer.MIN_VALUE?0:ans;
    }
    public int find(int[][] grid,int r1,int c1,int r2,int[][][]dp){
         int c2=(r1+c1)-r2;
         int n=grid.length;
         if(r1>=n || r2>=n|| c1>=n || c2>=n || grid[r1][c1]==-1 || grid[r2][c2]==-1)
         return Integer.MIN_VALUE;
         if(r1 == n-1 && c1 == n-1) {
            return grid[r1][c1];
        }
         if(dp[r1][c1][r2]!=-1)return dp[r1][c1][r2];
         int cherry=0;
         if(r1==r2 && c1==c2){
            cherry+=grid[r1][c1];
         }
         else{
            cherry+=grid[r1][c1]+grid[r2][c2];
         }
         int a=find(grid,r1+1,c1,r2+1,dp);
         int b=find(grid,r1+1,c1,r2,dp);
         int c=find(grid,r1,c1+1,r2,dp);
          int d=find(grid,r1,c1+1,r2+1,dp);
          int x=Math.max(Math.max(a,b),Math.max(c,d));
          if(x==Integer.MIN_VALUE)return dp[r1][c1][r2]=Integer.MIN_VALUE;
         return dp[r1][c1][r2]=cherry +x;
        
    }
}