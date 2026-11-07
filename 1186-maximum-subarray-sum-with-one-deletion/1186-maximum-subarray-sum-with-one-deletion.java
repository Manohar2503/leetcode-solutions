class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;

        int keep = arr[0];
        int delete = arr[0];

        int maxKeep = arr[0];
        int maxDelete = arr[0];
        for(int i=1;i<n;i++){
            int prevKeep = keep;
            keep = Math.max(prevKeep + arr[i], arr[i]);
            maxKeep = Math.max(keep, maxKeep);

            delete = Math.max(prevKeep, delete + arr[i]);
            maxDelete = Math.max(maxDelete, delete);
        }

        return Math.max(maxKeep, maxDelete);
    }
}