class Solution {
    static int result;
    public int totalNQueens(int n) {
        result =0;
        boolean[][] matrix = new boolean[n][n];
        nQueens(0, n, matrix);
        return result;
    }

    static void nQueens(int currentRow, int n, boolean[][] matrix){
        if(currentRow == n) {
            result++;
            return;
        }

        for(int col=0; col<n; col++){
            if(isPossible(currentRow, col, matrix)){
                matrix[currentRow][col] = true;
                nQueens(currentRow+1, n, matrix);
                matrix[currentRow][col] = false;
            }
        }
    }

    static boolean isPossible(int row, int col, boolean[][] matrix){
    
        // col wise checking
        for(int i = row;i>=0;i--){
            if(matrix[i][col]) return false; 
        }

        // diagonal - left
        int min_diagonal_left = Math.min(row, col);
        for(int i=0;i<=min_diagonal_left;i++){
            if(matrix[row-i][col-i]) return false;
        }

        // diagonal - right
        int min_diagonal_right = Math.min(matrix.length - col -1, row);
        for(int i=0;i<=min_diagonal_right;i++){
            if(matrix[row-i][col+i]) return false;
        }

        return true;
    }
}

/*

    1. first i need to choose the possition in a row
    2. i need to check is it satifies are not (col, diagonal)
    3. until i need to do last row 
    4. if possible count++ else backtrack

*/