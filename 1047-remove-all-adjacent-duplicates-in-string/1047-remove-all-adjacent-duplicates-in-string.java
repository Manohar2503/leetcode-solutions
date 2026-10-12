class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder(s);
        int right =0;

        while(right < sb.length()){
            if(right+1 < sb.length() && sb.charAt(right)==sb.charAt(right+1)){
                int[] arr = palindrome(right, right+1, sb);
                sb.delete(arr[0]+1, arr[1]);
                right=arr[0];
            }
            right++;
        }
        return sb.toString();
    }
    static int[] palindrome(int left, int right, StringBuilder sb){
        while(left>=0 && right < sb.length() && sb.charAt(left) == sb.charAt(right)){
            left--;
            right++;
        }
        return new int[]{left, right};
    }
}