import java.util.*;

class Solution {

    Map<Integer, Boolean> dp;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {

        int sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;

        if (desiredTotal <= 0) return true;

        if (sum < desiredTotal) return false;
        dp = new HashMap<>();
        return game(0,maxChoosableInteger, desiredTotal, dp);
    }

    static boolean game(int mask, int max, int total,
                        Map<Integer, Boolean> dp) {

        if (dp.containsKey(mask)) {
            return dp.get(mask);
        }

        for (int i = 1; i <= max; i++) {

            int bit = 1 << (i - 1);

            // Number already chosen
            if ((mask & bit) != 0) {
                continue;
            }

            // Current player can win immediately
            if (i >= total) {
                dp.put(mask, true);
                return true;
            }

            // If opponent cannot win, current player wins
            if (!game(mask | bit, max, total - i, dp)) {
                dp.put(mask, true);
                return true;
            }
        }

        dp.put(mask, false);
        return false;
    }
}