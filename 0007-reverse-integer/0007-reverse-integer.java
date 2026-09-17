class Solution {
    public int reverse(int x) {
        long result = 0;
        boolean isValid = false;
        if(x<0){
            isValid = true;
            x = -x;
        }

        while(x>0){
            int lastDigit = x % 10;
            result = result * 10 + (long) lastDigit;
            x /= 10;
        }

        if(result > Integer.MAX_VALUE) return 0;
        return (isValid)?(int) -result:(int) result;
    }
}