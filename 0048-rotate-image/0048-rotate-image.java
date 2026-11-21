class Solution {
    public void rotate(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        int[][] result = new int[r][c];
        int index =0;

        for(int i=r-1;i>=0;i--){
            for(int j=0;j<c;j++){
                result[j][index] =  matrix[i][j];
            }
            index++;
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                matrix[i][j] = result[i][j];
            }
        }

    }
}
/**

        1  2  3      
        4  5  6     
        7  8  9

        7  
        8  
        9  

 */