class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n==0) return -1;

        int left =0;
        int right = n-1;

        while(left < right){
            int mid = left + (right - left)/2;
            if(mid+1 < n && nums[mid] < nums[mid+1]){
                left = mid +1;
            }
            else{
                right = mid;
            }
        }

        return left;
    }
}

/*

1. if the array - > null  return -1
2. the array contains duplicates 
3. i need to return the index 


approach:
1. brute force : TC -> O(N), SC - > O(1)
    i used to check each element , for each ele i check their neighbours if it is a peek ele i return immediately

2. optimal solution :
            0 1 2 3 4 5 6 - Indexs
            1 2 1 3 5 6 4
                      LR

            mid = 5
        1-> mid val is less then its right val -> right side
        2-> left side

        0 1 2 3
        1 2 3 1
        L     R

        mid = 1
        2 < 3 

*/