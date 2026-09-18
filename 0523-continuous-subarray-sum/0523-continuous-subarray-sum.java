class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if(n == 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);

        int prefixSum =0;
        for(int i=0;i<n;i++){
            prefixSum += nums[i];
            if(map.containsKey(prefixSum % k)){
                if((i - map.get(prefixSum % k)) >= 2) return true;
            }
            else map.put((prefixSum %k),i); // 0,-1  5,0  1,1  2      
        }
        return false;
    }
}