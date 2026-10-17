class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        if(len == 0) return 0;
        int[] dp = new int[len+1];
        dp[0] = 1;
        dp[1] = (s.charAt(0) == '0')?0:1;

        for(int i=2;i<=len;i++){
            if(s.charAt(i-1)!='0'){
                dp[i] = dp[i-1];
            }

            int prev = s.charAt(i-2) - '0';
            int val = prev*10 + (s.charAt(i-1)-'0');

            System.out.print(val + " ");
            if(val>=10 && val <=26){
                dp[i] += dp[i-2];
            }
        }

        return dp[len];
    }
}

/**
  0  1  2
     1  2      ->>> (1 2 3), (12 3), (1 23)
  1  1   

*/