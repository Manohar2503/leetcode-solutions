class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        int t_count =0;
        int f_count =0;
        int left =0;
        int result = 0;

        for(int right=0; right<n; right++){
            char ch = answerKey.charAt(right);
            if(ch == 'T') t_count++;
            else f_count++;

            int max_val = Math.max(t_count, f_count);
            while((right - left + 1) - max_val > k){
                if(answerKey.charAt(left) == 'F') f_count--;
                else t_count--;
                left++;
            }

            result = Math.max(result, right - left +1);
        }

        return result;
    }
}