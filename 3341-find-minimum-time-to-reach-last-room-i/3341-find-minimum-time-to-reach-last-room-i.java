class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        int[][] arrivalTime = new int[n][m];
        for(int[] edge: arrivalTime){
            Arrays.fill(edge, Integer.MAX_VALUE);
        }

        arrivalTime[0][0] = 0;
        int[][] edgeNodes = {{1,0},{0,1},{-1,0},{0,-1}};

        PriorityQueue<int[]> qu = new PriorityQueue<>((a,b)->Integer.compare(a[2], b[2]));
        qu.offer(new int[]{0,0,0});

        while(!qu.isEmpty()){
            int[] current = qu.poll();
            int currentRow = current[0];
            int currentCol = current[1];
            int time = current[2];

            if(time > arrivalTime[currentRow][currentCol]) continue;
            if(currentRow== n-1 && currentCol == m-1) return time;

            for(int[] edge: edgeNodes){
                int nr = currentRow + edge[0];
                int nc = currentCol + edge[1];
            
                if(nr >=0 && nr < n && nc>=0 && nc < m){
                    int newTime = Math.max(time, moveTime[nr][nc]) +1;
                    if(newTime < arrivalTime[nr][nc]){
                        arrivalTime[nr][nc] = newTime;
                        qu.offer(new int[]{nr, nc, newTime});
                    }
                }
            }
        }

        return -1;
    }
}
/**


        0  4 
        4  4

 */