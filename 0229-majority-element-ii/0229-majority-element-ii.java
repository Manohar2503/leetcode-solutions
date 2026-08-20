class Solution 
{
    // static
    // {
    //     for(int i = 0; i < 500; i++)
    //         majorityElement(new int[]{});
    // }
    public static List<Integer> majorityElement(int[] nums) 
    {
        int count1 = 0, count2 = 0;
        int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;
        int n = nums.length;
        int min = n/3;
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            if(count1 == 0 && el2 != nums[i])
            {
                count1++;
                el1 = nums[i];
            }
            else if(count2 == 0 && el1 != nums[i])
            {
                count2++;
                el2 = nums[i];
            }
            else if(nums[i] == el1) count1++;
            else if(nums[i] == el2) count2++;
            else
            {
                count1--;
                count2--;
            }
        }

        count1=0;
        count2=0;
        for(int i = 0; i < n; i++)
        {
            if(el1 == nums[i])
                count1++;
            else if(el2 == nums[i])
                count2++;
        }
        if(count1 > min) ans.add(el1);       
               
        if(count2 > min) ans.add(el2);   

        return ans;     
    }
}