class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacipic = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        // checking from the pacipic ocean
        for(int i=0;i<m;i++){
            if(!pacipic[0][i]){
                dfs(0,i,heights, pacipic);
            }
        }

        for(int i=0;i<n;i++){
            if(!pacipic[i][0]){
                dfs(i,0,heights, pacipic);
            }
        }

         for(int i=0;i<m;i++){
            if(!atlantic[n-1][i]){
                dfs(n-1,i,heights, atlantic);
            }
        }

        for(int i=0;i<n;i++){
            if(!atlantic[i][m-1]){
                dfs(i,m-1,heights, atlantic);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pacipic[i][j] && atlantic[i][j]){
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    static void dfs(int r, int c, int[][] heights, boolean[][] ocean) {

    if (ocean[r][c]) return;

    ocean[r][c] = true;

    int[][] adj = {
        {0,1},
        {1,0},
        {0,-1},
        {-1,0}
    };

    for (int[] dir : adj) {

        int nr = r + dir[0];
        int nc = c + dir[1];

        if (nr >= 0 &&
            nr < heights.length &&
            nc >= 0 &&
            nc < heights[0].length &&
            !ocean[nr][nc] &&
            heights[nr][nc] >= heights[r][c]) {

            dfs(nr, nc, heights, ocean);
        }
    }
}
}