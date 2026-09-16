class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for(int num: nums) set.add(num);
        for(int i=1;i<=n;i++){
            if(!set.contains(i)) result.add(i);
        }

        return result;
    }
}