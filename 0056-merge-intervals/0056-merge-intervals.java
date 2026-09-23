class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(n==1) return intervals;
        Arrays.sort(intervals, (a,b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        List<int[]> list = new ArrayList<>();
        int[] merge = intervals[0];
        for(int i=1;i<n;i++){
            int[] cur = intervals[i];
            if(merge[1] >= cur[0]){
                merge[1] = Math.max(merge[1], cur[1]);
            }
            else{
                list.add(merge);
                merge = cur;
            }
        }

        list.add(merge);
        return  list.toArray(new int[list.size()][]);
    }
}