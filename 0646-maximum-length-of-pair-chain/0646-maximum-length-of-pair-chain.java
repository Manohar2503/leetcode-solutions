class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;

        Arrays.sort(pairs, (a,b) -> a[0] - b[0]);
        int[] len = new int[n];
        Arrays.fill(len, 1);
        int max_len = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(pairs[j][1] < pairs[i][0]){
                    if(len[j]+1 > len[i]){
                        len[i] = len[j]+1;
                    }
                }
            }
            max_len = Math.max(max_len, len[i]);
        }

        return max_len;
    }
}
/**

    [1,2]   [2,3]   [3,4]



*/