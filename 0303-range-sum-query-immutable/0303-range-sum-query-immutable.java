class NumArray {
    Map<Integer, Integer> map;
    int[] arr;
    public NumArray(int[] nums) {
        arr = nums;
        map = new HashMap<>();
        int prefixSum =0;
        for(int i=0;i<nums.length;i++){
            prefixSum += nums[i];
            map.put(i, prefixSum);
        }
    }
    
    public int sumRange(int left, int right) {
        return map.get(right) - map.get(left) + arr[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
 /*
     0 1 2  3 4  5
    -2 0 3 -5 2 -1
    
map ->{
        0 : -2
        1 : -2
        2 :  1
        3 : -4
        4 : -2
        5 : -3
    }
 */