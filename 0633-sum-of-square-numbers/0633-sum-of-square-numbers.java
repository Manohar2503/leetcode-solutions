class Solution {
    public boolean judgeSquareSum(int c) {
        if(c==0) return true;
        long right = (int) Math.sqrt(c);
        long left =0;
        while(left <= right){
            long num =  (left * left) + (right * right);
            if(num == c) return true;
            if(num < c) left++;
            else right--;
        }

        return false;
    }
}


/* 
 c = 5 

 sqrt(5) = 2

                0  1  2  
                a     b


*/