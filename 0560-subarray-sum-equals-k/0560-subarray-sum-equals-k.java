class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        freqMap.put(0,1);
        int prefix_Sum =0;
        int result = 0;

        for(int num: nums){
            prefix_Sum += num;
            if(freqMap.containsKey(prefix_Sum - k)){
                result += freqMap.get(prefix_Sum - k);
            }
            freqMap.put(prefix_Sum, freqMap.getOrDefault(prefix_Sum, 0)+1);
        }

        return result;
    }
}
/*
           0 1 2
   nums =  1 1 1  , k = 2
           i
    prefix_sum = 3
   
    condition : prefix_sum - k (y) is in map  3 - 2 =1
         count += val;// 1+1 = 2

    map -> { // key : prefix_sum , val: 1
            0 : 1
            1 : 1,
        }

        return count;
    TC -> O(N)
    SC -> O(N)
*/