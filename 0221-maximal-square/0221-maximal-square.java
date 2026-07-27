class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int result =0;

        int[] dp = new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j] == '1') dp[j] +=1;
                else dp[j] = 0; 
            }
            result = Math.max(result, helper(dp));
        }

        return result;
    }

    static int helper(int[] dp){
        int n = dp.length;
        Stack<Integer> st = new Stack<>();
        int result =0;
        for(int i =0;i<n;i++){
            int currentHeight = dp[i];
            while(!st.isEmpty() && currentHeight < dp[st.peek()]){
                int height = dp[st.pop()];
                int leftBound = (st.isEmpty()?-1:st.peek());
                int rightBound = i;

                int weight = rightBound - leftBound -1;
                int side = Math.min(weight, height);
                result = Math.max(result, side * side);
            }
            st.push(i); 
        }
        while (!st.isEmpty()) {
    int height = dp[st.pop()];
    int leftBound = st.isEmpty() ? -1 : st.peek();
    int rightBound = n;

    int width = rightBound - leftBound - 1;
    int side = Math.min(width, height);

    result = Math.max(result, side * side);
}

        return result;
    }
}