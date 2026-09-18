class Solution {
    public int mySqrt(int x) {
        if(x==0 || x==1) return x; 
        long left =1;
        long right = x;
        long result = 0;
        while(left<=right){
            long mid = left + (right - left)/2;
            long val = mid * mid;
            if(val <= x){
                result = mid;
                left = mid+1;
            }
            else right = mid-1;
        }   
        return (int) result;
    }
}