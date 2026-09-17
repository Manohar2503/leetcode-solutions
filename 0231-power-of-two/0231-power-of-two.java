class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==0 || n<0) return false;
        int val = n & (-n);
        return val == n;
    }
}