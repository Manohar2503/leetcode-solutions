class Solution {
    public int climbStairs(int n) {
        if(n<=2) return n;
        int second = 1;
        int first = 2;

        for(int i=3;i<=n;i++){
            int cur = first + second;
            second = first;
            first = cur;
        }

        return first;
    }
}