class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int i = 0;

        // 1) Ignore leading spaces
        while (i < n && s.charAt(i) == ' ') i++;

        // If all spaces
        if (i == n) return 0;

        // 2) Check sign
        int sign = 1;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // 3) Convert digits (stop at first non-digit)
        long num = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            num = num * 10 + (s.charAt(i) - '0');

            // 4) Clamp if overflow happens
            if (sign == 1 && num > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && -num < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        return (int) (sign * num);
    }
}
