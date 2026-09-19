class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        for (int pile : piles) {
            right = Math.max(pile, right);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int days = helper(piles, mid);
            if (days > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    private int helper(int[] piles, int k) {
        int days = 0;
        for (int pile : piles) {
            days += ((pile - 1) / k + 1);
        }
        return days;
    }
}