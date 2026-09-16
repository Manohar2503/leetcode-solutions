class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int result = 0;

        for(int i=0;i<=n;i++) result ^= i;
        for(int value: nums) result ^= value;

        return result; 
    }
}
/*

            0 1 2 3   
    Array - 0 1 # 3 -> 2

        result ^ [0 1 2 3]
        result ^ [3 0 1]

        result - > 2


        1 ^ 1 - 0
        1 ^ 0 - 1
        0 ^ 1 - 1
        0 ^ 0 - 0
*/