class Solution {
    /*
    [1, 5,  9]
    [10,11,13]      k = 8
    [12,13,15]
    */
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length-1;

        int min = matrix[0][0];
        int max = matrix[m][m];

        while(min < max){
            int mid = min + (max - min)/2;
            int count = helper(matrix, mid);
            if (count < k){
                min = mid + 1;
            }
            else{
                max = mid;
            }
        }

        return min;
    }

    static int helper(int[][] matrix, int num){
        int n = matrix.length-1;
        int m = matrix[0].length-1;

        int i = n;
        int j = 0;
        int count =0;
        while(i>=0 && j<=m){
            if(matrix[i][j]>num){
                i--;
            }
            else{
                count +=(i+1);
                j++; 
            }
        } 
        return count;
    }
}