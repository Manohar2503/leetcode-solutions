class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int prefix =0;
        int result =0;
        
        for(int i=0;i<n;i++){
            prefix += (nums[i]==0)?1:-1;
            if(map.containsKey(prefix)) result = Math.max(result, i - map.get(prefix));
            else map.put(prefix, i);
        }
        return result; 
    }
}
/*
      0 1 2 3 4 5 6 7 8
      0 1 1 1 1 1 0 0 0  
                      j
prefix - -1
Length - (j - get()) = 6
map ->{
        0 : -1
        1 :  0
       -1 :  2
       -2 :  3
       -3 :  4
       -4 :  5
       }

*/