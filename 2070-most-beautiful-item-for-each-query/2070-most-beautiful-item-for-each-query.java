class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a,b)-> a[0] - b[0]);
        int n = queries.length;
        int[] result = new int[n];
        int[] max_beauty = new int[items.length];

        int max =0;
        for(int i=0;i<items.length;i++){
            int[] item = items[i];
            int beauty = item[1];
            max = Math.max(max, beauty);
            max_beauty[i] = max;
        }

        for(int i=0;i<n;i++){
            int querie = queries[i];
            int value = binarySearch(querie, items, max_beauty);
            result[i] = value;
        }

        return result;
    }

    static int binarySearch(int target, int[][] items, int[] max_beauty){
        int n = items.length;
        int left =0;
        int right = n-1;

        int ans = -1;
        while(left <= right){
            int mid = left + (right - left)/2;

            if(items[mid][0] <= target){
                ans = max_beauty[mid];
                left = mid+1;
            }
            else right = mid -1;
        }

        return (ans==-1)?0:ans;
    }
}
/**

    1,2
    2,4
    3,5 
    3,2
    5,6
 */