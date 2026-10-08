class Solution {
    public int findCenter(int[][] edges) {
        int max = 0;
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            max = Math.max(max, Math.max(u,v));
        } 

        List<List<Integer>> adjNodes = new ArrayList<>();
        for(int i=0;i<=max;i++) adjNodes.add(new ArrayList<>());

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            adjNodes.get(u).add(v);
            adjNodes.get(v).add(u);
        } 

        int size =0;
        int result =0;

        for(int i=1;i<=max;i++){
            if(adjNodes.get(i).size() > size){
                size = adjNodes.get(i).size();
                result = i;
            }
        }
        return result;
    }
}
/*

        1 - 2 - 4
            |
            3

             4
             |
         5 - 1 - 2
             |
             3


*/