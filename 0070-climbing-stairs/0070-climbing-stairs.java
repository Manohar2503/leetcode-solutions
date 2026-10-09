class Solution {
    public int climbStairs(int n) {
        if(n == 1) return n;
        int secondPrev = 1;
        int firstPrev  = 1;

        for(int i=2;i<=n;i++){
            int current = firstPrev + secondPrev;
            secondPrev = firstPrev;
            firstPrev = current;
        }

        return firstPrev;
    }
}