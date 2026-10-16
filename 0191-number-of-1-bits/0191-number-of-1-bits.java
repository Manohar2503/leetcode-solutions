class Solution {
    public int hammingWeight(int n) {
        int count =0;
        while(n >0){
            count++;
            n = n & n-1;
        }
        return count;
    }
}
/**


    11 - 1 0 1 1
    10 - 1 0 1 0

    1 0 1 1 
          1
    1 0 1 0
        1 0
    1 0 0 0 
 */