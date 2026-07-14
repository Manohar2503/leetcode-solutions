class Solution {
    public int partitionString(String s) {
        boolean[] vis = new boolean[26];
        int ans = 1;

        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';

            if (vis[idx]) {
                ans++;
                vis = new boolean[26];
            }

            vis[idx] = true;
        }

        return ans;
    }
}