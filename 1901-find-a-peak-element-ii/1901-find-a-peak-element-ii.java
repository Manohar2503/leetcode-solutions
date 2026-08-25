class Solution {
    public int[] findPeakGrid(int[][] mat) {
       int row = mat.length;
       int col = mat[0].length-1;
       int left =0;
       int right = col;
       while (left <=right){
        int mid= left + (right-left)/2;
        int max_row=0;
        for(int i=0;i<row;i++){
            if(mat[i][mid] > mat[max_row][mid]){
                max_row = i;
            }
        }
        int left_ele = mid-1>=0 ? mat[max_row][mid-1] : -1;
        int right_ele  = mid+1<=col? mat[max_row][mid+1]:-1;
        
        if(mat[max_row][mid] > left_ele && mat[max_row][mid] > right_ele){
            return new int[]{max_row,mid};
        }
        else if(mat[max_row][mid]< left_ele){
            right = mid-1;
        }
        else{
            left = mid+1;
        }
       }
       return new int[]{-1,-1};
   
    }
}