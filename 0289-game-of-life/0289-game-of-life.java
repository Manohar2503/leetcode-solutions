class Solution {
    public void gameOfLife(int[][] board) {
        int nRows = board.length;
        int nCols = board[0].length;

        int[][] newBoard = new int[nRows][nCols];
        int[][] adjCells = {{-1,-1}, {-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        
        for(int i=0;i<nRows;i++){
            for(int j=0;j<nCols;j++){
                int liveCells = liveNodes(i,j,adjCells,board);
                if(board[i][j] == 1){
                    if(liveCells == 2 || liveCells == 3) newBoard[i][j] = 1;
                    else newBoard[i][j] = 0;
                }
                else{
                    if(liveCells == 3) newBoard[i][j] = 1;
                }
            }
        }

        for(int i=0;i<nRows;i++){
            for(int j=0;j<nCols;j++){
                board[i][j] = newBoard[i][j];
            }
        }
    }

    static int liveNodes(int r, int c, int[][] adjCells, int[][] board){
        int nRows = board.length;
        int nCols = board[0].length;
        int lives =0;
        for(int[] adj: adjCells){
            int nr = r + adj[0];
            int nc = c + adj[1];

            if(nr >=0 && nr<nRows && nc>=0 && nc< nCols && board[nr][nc] == 1){
                lives++;
            }
        }

        return lives;
    }
}