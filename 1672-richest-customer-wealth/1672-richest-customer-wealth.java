class Solution {
    public int maximumWealth(int[][] accounts) {
        int r = accounts.length;
        int c = accounts[0].length;
        int result =0;

        for(int i=0;i<r;i++){
            int count =0;
            for(int j=0;j<c;j++){
                count += accounts[i][j];
            }

            result = Math.max(result, count);
        }

        return result;
    }
}