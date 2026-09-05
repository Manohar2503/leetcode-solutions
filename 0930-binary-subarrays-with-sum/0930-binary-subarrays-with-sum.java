class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int len=nums.length,sum=0,res=0;
        int[] arr=new int[len+1];
        arr[0]++;
        for(int i=0;i<len;i++){
            sum+=nums[i];
            if(sum-goal>=0)res+=arr[sum-goal];
            arr[sum]++;
        }
        return res;
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