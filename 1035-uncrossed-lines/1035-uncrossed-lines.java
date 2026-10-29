class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[] prev = new int[m+1];
        int[] curr = new int[m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(nums1[i-1] == nums2[j-1]) curr[j] = prev[j-1]+1;
                else curr[j] = Math.max(prev[j], curr[j-1]);
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[m];
    }
}