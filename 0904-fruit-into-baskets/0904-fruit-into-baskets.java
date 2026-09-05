class Solution {
    public int totalFruit(int[] fruits) {
        int start = -1;
        int end = 0;
        int a = -1;
        int b = -1;
        int ans = 0;
        for(int i=0; i<fruits.length; i++){
            if(a == -1 || fruits[i] == fruits[a]){
                a = i;
            } else if(b == -1 || fruits[i] == fruits[b]){
                b = i;
            }
            else {
                if(a < b){
                    start = a;
                    a = i;
                } else {
                    start = b;
                    b = i;
                }
            }
            ans = Math.max(ans, i-start);
        }
        return ans;
    }
}