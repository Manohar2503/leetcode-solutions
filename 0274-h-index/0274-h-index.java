class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        
        for(int i=0;i<n;i++){
            int val = citations[i];
            int distance = n - i;
            if(val >= distance) return distance;
        }
        return 0;
    }
}
/**

    1. h -index means i need to return max-value
    2. the researcher's at least the papers should contain cited at least h times
    

    3 0 6 1 5

    0 1 2 3
    0
    0 1 2 3 4 5 6
    0 1 2 3 4 5

    0 1 3 5 6
    0   2   4
 
 */