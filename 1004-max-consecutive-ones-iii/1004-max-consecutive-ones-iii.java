class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        if(n == k) return n;

        int left =0;
        int right =0;
        int result =0;
        int count = 0;
        
        while (right < n) {

    if (nums[right] == 0) {
        count++;
    }

    right++;

    while (count > k) {
        if (nums[left] == 0) {
            count--;
        }
        left++;
    }

    result = Math.max(result, right - left);
}
        return result;
    }
}

/*
    k = 2
                         j
    1 1 1 0 0 0 1 1 1 1 0
              i
    0 1 2 3 4 5 6 7 8 9 10

    ans = 5
*/