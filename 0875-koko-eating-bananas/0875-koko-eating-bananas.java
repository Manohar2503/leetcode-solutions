class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left =1; 
        int right = 0;
        for(int i =0;i<=piles.length-1;i++){
            right = Math.max(right, piles[i]);
        }
        while(left<right){
            int mid = left + (right-left)/2;
            int hoursNeeded = 0;
            for (int pile : piles) {
                hoursNeeded += (pile + mid - 1) / mid; // ceiling division
            }
            if(hoursNeeded<=h){
               right=mid;
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }
}