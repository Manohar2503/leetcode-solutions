class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int val = nums[i];
            if(map.containsKey(val)){
                if(i - map.get(val) <= k) return true;
            }
            map.put(val, i);
        }
        return false;
    }
}
/**

        1, 2, 3, 1, 2, 3
        0  1  2  3  4  5 


        1 : 0 
        2 : 1
        3 : 2

*/