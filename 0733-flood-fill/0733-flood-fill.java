class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;

        if(image[sr][sc] == color) return image;
        int originalColor = image[sr][sc];

        Queue<int[]> qu = new LinkedList<>();
        qu.offer(new int[]{sr,sc});
        int[][] adj = {{0,1},{1,0},{-1,0},{0,-1}};
        image[sr][sc] = color;

        while(!qu.isEmpty()){
            int[] current = qu.poll();
            int r = current[0];
            int c = current[1];

            for(int[] node: adj){
                int nr = r + node[0];
                int nc = c + node[1];

                if(nr>=0 && nr<m && nc>=0 && nc<n && image[nr][nc]==originalColor){
                    qu.offer(new int[]{nr,nc});
                    image[nr][nc]=color;
                }
            }
        }


        return image; 
    }
}