class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int top = 0;
        int left = 0;
        int right = m-1;
        int bottom = n-1;

        List<Integer> result = new ArrayList<>();

        while(left <= right && top <= bottom){
            // left to right
            for(int i=left;i<=right;i++){
                result.add(matrix[top][i]);
            }
            top++;

            // top to bottom
            for(int i=top;i<=bottom;i++){
                result.add(matrix[i][right]);
            }
            right--;

            // right to left
            if(top <= bottom){
                for(int i= right;i>=left;i--){
                result.add(matrix[bottom][i]);
            }
            }
            bottom--;

            //bottom to up
            if(left <= right){
                for(int i = bottom; i>=top; i--){
                result.add(matrix[i][left]);
            }
            }
            left++;
        }    

        return result;  
    }
}