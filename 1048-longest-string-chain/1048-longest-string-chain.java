class Solution {
    int[] dp;
    
    boolean check(String small,String large){
        int i=0,j=0;
        boolean skip = false;
        while(i<small.length() &&  j<large.length()){
            if(small.charAt(i)==large.charAt(j)){
                i++;
                j++;
            }
            else{
                if(skip){
                    return false;
                }
                skip = true;
                j++;
            }
        }
        return true;
    }

    int f(int i,String[] words){
        if(dp[i]!=-1) return dp[i];
        dp[i] = 1;
        for(int p=0;p<i;p++){
            if(words[i].length() == words[p].length()+1 && check(words[p],words[i])){
                dp[i] = Math.max(dp[i],f(p,words)+1);
            }
        }
        return dp[i];
    }
    
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words,(a,b) -> a.length() - b.length());
        dp = new int[n];
        Arrays.fill(dp,-1);
        int ans = 1;
        for(int i=0;i<n;i++){
            ans = Math.max(ans,f(i,words));
        }
        return ans;
    }
}