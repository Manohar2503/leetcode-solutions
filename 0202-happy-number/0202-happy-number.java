class Solution {
    public boolean isHappy(int n) {
        if(n == 1) return true;
        long slow = (long)n;
        long fast = (long)n;

        while((int)fast!=1){
            slow = happy(slow); // 68
            fast = happy(happy(fast)); // 1
            if(fast !=1 && slow == fast) return false;
        }
        return true;
    }

    static long happy(long n){
        long sum = 0;
        while(n>0){
            long last =  n % 10;
            sum += last * last;
            n /= 10;
        }

        return sum;
    }
}