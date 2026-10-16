class Solution {
    public int singleNumber(int[] nums) {
        int single_number =0;

        for(int num : nums) single_number ^= num;
        return single_number;
    }
}