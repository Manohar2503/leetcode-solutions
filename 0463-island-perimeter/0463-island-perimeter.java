class Solution {
    public int islandPerimeter(int[][] grid) {
        int  iland = 0;
        int neigbour=0;
        for(int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    iland++;
                
                if(i>0 && grid[i-1][j] == 1){
                           neigbour++;
                }
                if(j>0 && grid[i][j-1] == 1){
                    neigbour++;
                }
                }

            }
        }
    return iland*4 - neigbour*2;
    }
}