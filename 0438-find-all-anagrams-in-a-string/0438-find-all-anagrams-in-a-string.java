class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int plen = p.length();
        int slen = s.length();
        List<Integer> result = new ArrayList<>();

        if(plen > slen) return result;
        int[] freqs = new int[26];
        int[] freqp = new int[26];

        for(char ch: p.toCharArray()){
            freqp[ch-'a']++;
        }

        for(int i=0;i<plen;i++) {
            char c = s.charAt(i);
            freqs[c - 'a']++;
        }

        if(Arrays.equals(freqp, freqs)) result.add(0);

        for(int i=plen;i<s.length();i++){
            int prev = s.charAt(i-plen) - 'a';
            int current = s.charAt(i) - 'a';
            freqs[prev]--;
            freqs[current]++;

            if(Arrays.equals(freqp, freqs)) result.add(i - plen + 1);
        }

        return result;
    }
}