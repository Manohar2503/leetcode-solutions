class Solution {
    // static{
    //     Solution o = new Solution();
    //     for(int i = 0; i < 250; ++i){
    //         o.canReach("011010", 2, 3);
    //     }
    // }

    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();

        if(s.charAt(n-1) == '1'){
            return false;
        }

        boolean[] dp = new boolean[n];
        dp[0] = true;

        int farthest = 0;

        for(int i = 0; i < n-1; ++i){
            if(!dp[i] || s.charAt(i) == '1' || i + minJump >= n){
                continue;
            }

            if(i + maxJump >= n - 1){
                return true;
            }

            for(int j = Math.max(i + minJump, farthest); j <= i + maxJump; ++j){
                dp[j] = true;
            }
            farthest = i + maxJump + 1;
        }

        return dp[n-1];
    }
}




// class Solution {
//     public boolean canReach(String s, int minJump, int maxJump) {
//         int n = s.length();
      
//         int[] prefixSum = new int[n + 1];
//         prefixSum[1] = 1;
//         boolean[] isReachable = new boolean[n];
//         isReachable[0] = true; 
//         for (int i = 1; i < n; i++) {

//             if (s.charAt(i) == '0') {
//                 int leftBound = Math.max(0, i - maxJump);
//                 int rightBound = i - minJump;

//                 isReachable[i] = leftBound <= rightBound && 
//                                 prefixSum[rightBound + 1] - prefixSum[leftBound] > 0;
//             }
          
//             prefixSum[i + 1] = prefixSum[i] + (isReachable[i] ? 1 : 0);
//         }
//         return isReachable[n - 1];
//     }
// }