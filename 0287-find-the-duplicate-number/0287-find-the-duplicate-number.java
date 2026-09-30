class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow!=fast);
        
        slow = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
/*

    here n number of interger values -> i need to find one number which occurs twice 
    constraints: 
        - i cannot alter the intergers in nums
        - i cannot use extra space

    approach 1 : using sort , but here the values will be change , TC - O(nlogn), SC - O(1)
    appriach 2 : 1 2 3 , here also i need to change the nums , TC - O(n), SC - O(1)
    approach 3 : using circle method 
                    -> TC - O(n) , SC - O(1)

*/