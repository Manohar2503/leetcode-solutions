class Solution {
    public int[][] generateMatrix(int n) {
        int left =0;
        int right = n-1;
        int top = 0;
        int down = n-1;
        int[][] result = new int[n][n];
        int count =1;
        while(left<=right && top <= down){
            // left to right 
            for(int i=left; i<=right;i++){
                result[top][i] = count++;
            }
            top++;
            // top to down 
            for(int i=top;i<=down;i++){
                result[i][right] = count++;
            }
            right--;
            //right to left

            if(top<=down){
                for(int i=right; i>=left;i--){
                result[down][i] = count++;
            }
            }
            down--;

            // down to top 
           if(left <=right){
              for(int i=down;i>=top;i--){
                result[i][left] = count++;
            }
           }
               
            left++;
        }
        return result;
    }
}