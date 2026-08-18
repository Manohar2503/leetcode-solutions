class Solution {
    int rows = 0, cols = 0, cnt = 0;
    public int numIslands(char[][] grid) {
       this.rows = grid.length;
       this.cols = grid[0].length;
       for(int row = 0; row<rows; row++){
        check(row, grid);
       }
       return cnt;
    }

    private void check(int row, char[][]grid){
        for(int col=0; col < cols; col++){
            if(grid[row][col] == '1'){
                cnt++;
                dfs(row, col, grid);
            }
        }
    }

    private void dfs(int row, int col, char[][]grid){
        grid[row][col] = '*';
        if(row-1 > -1 && grid[row - 1][col] == '1') dfs(row - 1, col, grid);
        if(row + 1 < rows && grid[row + 1][col] == '1') dfs(row + 1, col, grid);
        if(col - 1 > -1 && grid[row][col - 1] == '1') dfs(row, col - 1, grid);
        if(col + 1 < cols && grid[row][col+1] == '1') dfs(row, col + 1, grid);
    }
}