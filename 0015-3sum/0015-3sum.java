class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>  list = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            int j=i+1;
            int k=n-1;
            while(j<k){
                int val = nums[i]+nums[j]+nums[k];
                if(val>0){
                    k--;
                }
                else if(val<0){
                    j++;
                }
                else{
                    list.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    while(j<n && nums[j]==nums[j-1]){
                        j++;
                    }
                }
            }
        }
        return list;
    }
}
