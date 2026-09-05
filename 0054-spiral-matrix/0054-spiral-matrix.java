class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int top= 0;
        int left =0;
        int right = matrix[0].length-1;
        int down = matrix.length-1;

        while(left <= right && top <= down){
            // left to right 
            for(int i=left; i<=right;i++){
                int val = matrix[top][i];
                list.add(val);
            }
            top++;
            // top to down 
            for(int i=top;i<=down;i++){
                int val = matrix[i][right];
                list.add(val);
            }
            right--;
            //right to left

            if(top<=down){
                for(int i=right; i>=left;i--){
                int val = matrix[down][i];
                list.add(val);
            }
            }
            down--;

            // down to top 
           if(left <=right){
              for(int i=down;i>=top;i--){
                int val = matrix[i][left];
                list.add(val);
            }
           }
               
            left++;
        }

        return list;
    }
}