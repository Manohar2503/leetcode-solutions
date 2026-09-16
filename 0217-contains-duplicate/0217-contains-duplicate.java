class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n  = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int val: nums) set.add(val);
        if(set.size() == n) return false;
        return true;
    }
}