class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefix =0;
        int result =0;
        map.put(0,1);

        for(int num:nums){
            prefix += num;
            if(map.containsKey(prefix - goal)) result += map.get(prefix - goal);
            map.put(prefix, map.getOrDefault(prefix, 0)+1);
        }

        return result;
    }
}

/*
            1 0 1 0 1
                    R
    cnt =  
    pre -   [1,1,2]

        ans =  3 - 2 = 1
    map - {
                0 : 1
                1 : 2
                2 : 2
                3 : 1
          }

*/