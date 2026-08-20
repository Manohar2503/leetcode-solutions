import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if (n < 4) return res;

        Arrays.sort(nums);

        for (int a = 0; a < n - 3; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) continue; // skip duplicate a

            for (int b = a + 1; b < n - 2; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) continue; // skip duplicate b

                int c = b + 1;
                int d = n - 1;

                while (c < d) {
                    long sum = (long) nums[a] + nums[b] + nums[c] + nums[d]; 
                    if (sum == target) {
                        res.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                        
                        // Skip duplicate c
                        while (c < d && nums[c] == nums[c + 1]) c++;
                        // Skip duplicate d
                        while (c < d && nums[d] == nums[d - 1]) d--;

                        c++;
                        d--;
                    } 
                    else if (sum < target) {
                        c++;
                    } 
                    else {
                        d--;
                    }
                }
            }
        }
        return res;
    }
}