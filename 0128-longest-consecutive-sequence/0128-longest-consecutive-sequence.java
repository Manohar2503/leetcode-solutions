class Solution {
    public int longestConsecutive(int[] nums) {
      int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
        }
        if (max < 100000) {
            boolean[] arr = new boolean[max - min + 1];
            for (int i : nums) {
                arr[i - min] = true;
            }
            int maxlen = 0;
            int currmaxlen = 0;
            boolean state = false;
            for (boolean b : arr) {
                if (b == false) {
                    if (currmaxlen > maxlen)
                        maxlen = currmaxlen;
                    currmaxlen = 0;
                } else {
                    currmaxlen++;
                }
            }
            if (currmaxlen > maxlen)
                maxlen = currmaxlen;
            return maxlen;
        } else {
            Set<Integer> set = new HashSet<>();
            for (int i : nums) {
                set.add(i);
            }
            int longest = 0;
            int current;
            for (int i : set) {
                if (!set.contains(i - 1)) {
                    int now = i;
                    current = 1;
                    while (set.contains(now + 1)) {
                        current++;
                        now++;
                    }
                    longest = Math.max(longest, current);
                }
            }
            return longest;
        }  
    }
}