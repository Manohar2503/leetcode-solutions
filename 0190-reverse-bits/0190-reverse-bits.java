class Solution {
    public int reverseBits(int n) {
        int result =0;
        int number=32;
        while(number-- >0){
            result = result <<1;
            result |= n&1;
            n = n>>1;
        }
        return result;
    }
}