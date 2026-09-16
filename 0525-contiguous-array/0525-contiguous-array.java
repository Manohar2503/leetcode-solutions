class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int result =0;
        int prefixSum =0;
        for(int i=0;i<n;i++){
            int val = nums[i];
            prefixSum +=(val ==0)?1:-1;
            if(map.containsKey(prefixSum)){
                result = Math.max(result, i - map.get(prefixSum));
            }
            else{
                map.put(prefixSum, i);
            }
        }

        return result;
    }
}
/*
        0 1 2 3 4 5 6 7 8
        0 1 0 1
            i
        prefix = 0
        result = 2
        0 -> -1
        1 -> 0
        
    */