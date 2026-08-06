class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int temp=image[sr][sc];
        image[sr][sc]=color;
        int m=image.length;
        int n=image[0].length;
        if (temp == color) return image; 
        // Check right
        if(sc+1<n && image[sr][sc+1]==temp){
           floodFill(image,sr,sc+1,color);
        }
        // Check left
        if(sc-1>=0 && image[sr][sc-1]==temp){
           floodFill(image,sr,sc-1,color);
        }
        // Check up
        if(sr-1>=0 && image[sr-1][sc]==temp){
           floodFill(image,sr-1,sc,color);
        }
        // Check down
        if(sr+1<m && image[sr+1][sc]==temp){
           floodFill(image,sr+1,sc,color);
        }

        return image;
    }
}