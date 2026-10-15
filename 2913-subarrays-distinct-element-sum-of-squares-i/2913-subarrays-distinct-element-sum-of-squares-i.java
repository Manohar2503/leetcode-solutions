class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int result =0;

        for(int i=0;i<n;i++){
            Set<Integer> set = new HashSet<>();
            for(int j=i;j<n;j++){
                set.add(nums.get(j));
                result += set.size() * set.size();
            }
        }

        return result;
    }
}
/*

    1 , 2, 1, 1 2, 2 1, 1 2 1
    1 , 1, 1, 2, 2, 2
    1 + 1 + 1 + 4 + 4 + 4

      0 1 2
    [ 1 2 1 ]


*/