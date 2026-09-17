class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}

/*
        a = 0 0 1
        b = 1 0 0
            1 0 1
            

*/