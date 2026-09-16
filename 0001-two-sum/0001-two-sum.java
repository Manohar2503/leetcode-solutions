class Solution {
    public int[] twoSum(int[] nums, int target) {
        int arraySize = nums.length;
        // if(arraySize == 0) return new int[]{-1,-1};

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
           int val = nums[i];
           if(map.containsKey(target - val)){
            return new int[]{map.get(target - val), i};
           } 

           map.put(val, i);
        }
        return new int[]{-1,-1};
    }
}