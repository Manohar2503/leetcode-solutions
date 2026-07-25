class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> list = new ArrayList<>();

        int n = nums.length;
        if (n == 0) return list;

        Arrays.sort(nums);

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] hash = new int[n];

        for (int i = 0; i < n; i++) {
            hash[i] = i;
        }

        int maxVal = 1;
        int maxIndex = 0;

        for (int i = 1; i < n; i++) {

            for (int j = 0; j < i; j++) {

                if (nums[i] % nums[j] == 0 &&
                    dp[j] + 1 > dp[i]) {

                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }
            }

            if (dp[i] > maxVal) {
                maxVal = dp[i];
                maxIndex = i;
            }
        }

        list.add(nums[maxIndex]);

        while (hash[maxIndex] != maxIndex) {
            maxIndex = hash[maxIndex];
            list.add(nums[maxIndex]);
        }

        Collections.reverse(list);
        return list;
    }
}