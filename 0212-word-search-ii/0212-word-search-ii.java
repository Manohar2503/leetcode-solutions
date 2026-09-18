class Solution {
    static class Node{
        Node[] arr = new Node[26];
        String isWord = null;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        Node root = new Node();
        int n = board.length;
        int m = board[0].length;

        for(String word: words){
            Node node = root;
            for(char ch: word.toCharArray()){
                if(node.arr[ch - 'a']== null) node.arr[ch - 'a'] = new Node();
                node = node.arr[ch - 'a'];
            }
            node.isWord = word;
        }    

        List<String> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dfs(board, i , j, root, list);
            }
        }

        return list;
    }

    static void dfs(char[][] board, int i, int j, Node node, List<String> list){
        if(i >= board.length || i<0 || j >= board[0].length || j<0) return;
        char ch = board[i][j];
        if(board[i][j]=='#' || node.arr[ch - 'a']== null) return;
        
        node = node.arr[ch - 'a'];
        if(node.isWord!=null){
            list.add(node.isWord);
            node.isWord = null;
        }

        board[i][j] = '#';
        dfs(board, i+1, j, node, list);
        dfs(board, i-1, j, node, list);
        dfs(board, i, j+1, node, list);
        dfs(board, i, j-1, node, list);
        board[i][j] = ch;
    }
}