class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int max_i_can_go =0;
        int count =0;
        if(n == 0 || n==1) return 0;

        int i=0;
        while(i<n){
            int maxIndex = max_i_can_go;
            while(i<= maxIndex){
                max_i_can_go = Math.max(max_i_can_go, i + nums[i]);
                i++;
            }
            count++;
            if(max_i_can_go >= n-1) return count;
        }
        return 0;
    }
}
/*
    0 1 2 3 4 5 6 7 8 9 10 11 12 13 14
    7 0 9 6 9 6 1 7 9 0 1  2  9  0  3
            i
    max_i_can_go = 11
    count = 2
*/