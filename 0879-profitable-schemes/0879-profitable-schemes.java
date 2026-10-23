class Solution {
    private static final int MOD = 1_000_000_007;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int crimes = group.length;
        int[][] f = new int[n + 1][minProfit + 1];
        f[0][0] = 1;

        for (int i = 0; i < crimes; ++i) {
            int g = group[i];
            int earn = profit[i];
            for (int used = n - g; used >= 0; --used) {
                for (int p = minProfit; p >= 0; --p) {
                    if (f[used][p] == 0) continue;

                    int newUsed = used + g;
                    int newProfit = Math.min(minProfit, p + earn);
                    f[newUsed][newProfit] = (f[newUsed][newProfit] + f[used][p]) % MOD;
                }
            }
        }
        
        int ret = 0;
        for (int used = 0; used <= n; ++used) {
            ret = (ret + f[used][minProfit]) % MOD;
        }
        return ret;
    }
}