class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int left=1;
        int right= (int) 1e9;
        if(m*k>bloomDay.length){
            return -1;
        }
        int ans=-1;
        while(left<=right){
         int mid = left + (right-left)/2;
        int consecutiveLength =0;
        int bouquets=0;
        for(int i =0;i<bloomDay.length;i++){
            if(bloomDay[i]<=mid){
                 consecutiveLength++;
                 if(consecutiveLength>=k){
                    bouquets++;
                    consecutiveLength=0;
                 }   
            }
            else{
                consecutiveLength=0;
            }
        }
        if(bouquets>=m){
            ans = mid;
            right = mid-1;
        }
        else{
            left=mid+1;
        }
    
    }
     return ans;
    }
}
/*
        0  1 2 3 4    M = 3 , k = 1
        1 10 3 10 2

        i

        min = 3  max = 4,  
            mid = 3
        [T  F  T  F  T]
         0  1  2  3  4 


*/