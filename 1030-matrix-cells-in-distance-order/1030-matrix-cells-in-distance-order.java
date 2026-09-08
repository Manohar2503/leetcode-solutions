class Solution {
    static class Node implements Comparable<Node>{
        int r;
        int c;
        int dis;
        Node(int r, int c, int dis){
            this.r = r;
            this.c = c;
            this.dis = dis;
        }
        
        public int compareTo(Node other){
            return this.dis-other.dis;
        }

    }
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] result = new int[rows * cols][2];
        List<Node> nodes = new ArrayList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                int distance = Math.abs(i-rCenter) + Math.abs(j-cCenter);
                nodes.add(new Node(i,j,distance));
            }
        }
        int index =0;
        Collections.sort(nodes);
        for(Node n: nodes){
            result[index++] = new int[]{n.r,n.c};
        }

        return result;
    }
}