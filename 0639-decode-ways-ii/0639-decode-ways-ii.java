
class Solution {
    private static final int MOD = 1_000_000_007;

    public int numDecodings(String s) {
        int n = s.length();

        if (n == 0) return 0;

        long prev2 = 1;
        long prev1 = waysOne(s.charAt(0));

        for (int i = 1; i < n; i++) {
            char p = s.charAt(i - 1);
            char c = s.charAt(i);

            long oneDigit = waysOne(c);
            long twoDigits = waysTwo(p, c);

            long current = (oneDigit * prev1
                          + twoDigits * prev2) % MOD;

            prev2 = prev1;
            prev1 = current;
        }

        return (int) prev1;
    }

    private long waysOne(char c) {
        if (c == '*') return 9;
        if (c == '0') return 0;
        return 1;
    }

    private long waysTwo(char p, char c) {
        if (p == '*' && c == '*') {
            return 15;
        }

        if (p == '*') {
            return (c >= '0' && c <= '6') ? 2 : 1;
        }

        if (c == '*') {
            if (p == '1') return 9;
            if (p == '2') return 6;
            return 0;
        }

        int value = (p - '0') * 10 + (c - '0');

        return (value >= 10 && value <= 26) ? 1 : 0;
    }
}
