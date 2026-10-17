class Solution {
    public int climbStairs(int n) {
        if(n <= 2) return n;
        int second = 1;
        int first = 2;
        for(int i=3;i<=n;i++){
            int current = first + second;
            second = first;
            first = current;
        }
        return first;
    }
}
/**

    n = 1  ans = 1, [1]
    n = 2  ans = 2, [(1,1),(2)]
    n = 3  ans = 3, [(1,1,1),(1,2),(2,1)]
    n = 4  ans =  , 



 */