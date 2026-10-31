class Solution {
    public int minExtraChar(String s, String[] dictionary) {

        Map<Character, Boolean> map = new HashMap<>();

        for (String str : dictionary) {
            map.put(str.charAt(0), true);
        }

        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);

        Set<String> wordSet = new HashSet<>(Arrays.asList(dictionary));
        return extraChars(0, s, map, wordSet, dp);
    }

    static int extraChars(int index, String s,
                          Map<Character, Boolean> map,
                          Set<String> wordSet, int[] dp) {

        if (index >= s.length()) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        // Not Take
        int notTake = 1 + extraChars(index + 1, s, map, wordSet, dp);

        // Take
        int take = Integer.MAX_VALUE;

        if (map.containsKey(s.charAt(index))) {
            for (int i = index; i < s.length(); i++) {

                String prefix = s.substring(index, i + 1);

                if (wordSet.contains(prefix)) {
                    take = Math.min(take,
                        extraChars(i + 1, s, map, wordSet, dp));
                }
            }
        }

        return dp[index] = Math.min(take, notTake);
    }
}