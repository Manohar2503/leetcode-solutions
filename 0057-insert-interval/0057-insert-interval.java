class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[] merge = newInterval;
        List<int[]> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            int[] cur = intervals[i];
            if(cur[1] < merge[0]) list.add(cur);
            else if(cur[0] > merge[1]){
                list.add(merge);
                merge = cur;
            } 
            else{
                merge[0] = Math.min(cur[0], merge[0]);
                merge[1] = Math.max(cur[1], merge[1]);
            }
        }
        list.add(merge);
        return list.toArray(new int[list.size()][]);
    }
}
/*

    intervals :  [1,2]  [3,5]  [6,7]  [8,10]  [12,16]     newInterval: [4,8]
                                                 i              

    // merge - [3, 10]

    result[][] = [[1,2], ]

        if(cur[1] < merge[0])  // add cur
        else if(cur[0] > merge[1]) add merge
        else {
            merge [0] = min(cur[0], new[0]);
            merge[1] = max(cur[1], new[1]);

        }
*/