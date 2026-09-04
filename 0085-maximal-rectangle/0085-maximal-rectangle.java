class Solution {
    // static{
    //     for(int i=0;i<500;i++){
    //         char[][] matrix = {{'1','0'},{'0','1'}};
    //             maximalRectangle(matrix);
    //     }
    // }
    public static  int maximalRectangle(char[][] matrix) {
       
        int n = matrix.length;
        int m = matrix[0].length;
        if(n==0 || m==0) return 0;
      
        int[] arr = new int[m];
        int val=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1'){
                    arr[j] += 1;
                }
                else arr[j]=0;
            }
            val = Math.max(val,histogram(arr));
        }
        return val;

    }
    private static int histogram(int[] arr){
        
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int max_area = 0;
        for(int right=0;right <=n;right++){
            int val = (right == n) ? 0 : arr[right];
            while(!st.isEmpty() && arr[st.peek()] > val){
                int height = arr[st.pop()];
                int rightboundary = right;
                int leftboundary = (st.isEmpty())?-1:st.peek();
                int width = rightboundary - leftboundary -1;
                int area = height * width;
                max_area = Math.max(max_area, area);
            }
            st.push(right);
        }
        return max_area;
        
    }
}
