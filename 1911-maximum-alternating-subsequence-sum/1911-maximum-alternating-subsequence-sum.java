
class Solution {
    public long maxAlternatingSum(int[] nums) {

        long even = 0;
        long odd = Long.MIN_VALUE / 4;

        for (int ele : nums) {

            long prevEven = even;
            long prevOdd = odd;

            even = Math.max(prevEven, prevOdd - ele);
            odd = Math.max(prevOdd, prevEven + ele);
        }

        return Math.max(even, odd);
    }
}
