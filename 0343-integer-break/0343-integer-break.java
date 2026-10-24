class Solution {
    public int integerBreak(int n) {
        if(n<=1) return 0;
        if(n == 2) return 1;
        if(n == 3) return 2;
        
        int result = 1;
        while(n > 4){
            result *= 3;
            n -= 3;
        }

        return result * n;

    }
}
/*

     n  = 5

        1 1 1 1 1= 1
        1 2 2 = 4
        3 2 = 6

    n = 6

        2 2 2 = 8
        3 2 1 = 6
        3 3 = 9 
        4 2 = 8
        5 1 = 5
    n = 7

        2 2 2 1 = 8
        2 2 3 = 12
        3 3 1 = 9
        3 4 = 12
        4 2 1 = 8
        5 2 = 10
        6 1 = 6

*/