class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> tmap = new HashMap<>();
        Map<Character, Integer> smap = new HashMap<>();

        for (char ch : t.toCharArray()) {
            tmap.put(ch, tmap.getOrDefault(ch, 0) + 1);
        }

        int i = 0, j = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (j < s.length()) {
            char ch = s.charAt(j);
            smap.put(ch, smap.getOrDefault(ch, 0) + 1);

            if (tmap.containsKey(ch) && smap.get(ch).intValue() == tmap.get(ch).intValue()) {
                count++;
            }

            // shrink window
            while (count == tmap.size()) {
                if (j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    start = i;
                }

                char left = s.charAt(i);
                smap.put(left, smap.get(left) - 1);

                if (tmap.containsKey(left) && smap.get(left) < tmap.get(left)) {
                    count--;
                }
                i++;
            
            }
            j++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
