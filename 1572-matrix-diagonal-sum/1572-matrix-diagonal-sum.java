class Solution {
    public int diagonalSum(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        if(rows==1 && cols ==1) return mat[0][0];
        int result =0;

        int leftCol =0, rightCol = cols-1;
        for(int i=0;i<rows;i++){
            if(leftCol == rightCol) result += mat[i][rightCol];
            else{
                result += mat[i][leftCol] + mat[i][rightCol];
            }
            leftCol++;
            rightCol--;

        }

        return result;
    }
}