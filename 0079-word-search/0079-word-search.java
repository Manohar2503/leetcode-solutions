class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == word.charAt(0)){
                    
                    boolean[][] vis = new boolean[n][m];
                    if(ispossible(i,j,0,board,word,vis)) return true;
                }
            }
        }
        return false;
    }
    static boolean ispossible(int i, int j, int index, char[][] board, String word, boolean[][] vis){
        if(index==word.length()) return true;
        if(i<0 || i>= board.length || j<0 || j>= board[0].length) return false;
        if(vis[i][j]) return false;
        vis[i][j] = true;
        boolean flag = false;
        if(board[i][j] == word.charAt(index)){
            flag = ispossible(i,j-1,index+1,board,word,vis) ||
                   ispossible(i-1,j,index+1,board,word,vis) ||
                   ispossible(i+1,j,index+1,board,word,vis) ||
                   ispossible(i,j+1,index+1,board,word,vis);
        }
        vis[i][j]=false;
        return flag;
    }
}