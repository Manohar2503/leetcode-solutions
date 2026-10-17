class Solution {
    public int tribonacci(int n) {
        if(n==0) return 0;
        if(n<=2) return 1;
        
        int third = 0;
        int second = 1;
        int first = 1;
        for(int i=3;i<=n;i++){
            int current = first + second + third;
            third = second;
            second = first;
            first = current;
        }

        return first;
    }
}