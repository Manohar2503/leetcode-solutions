class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        path(0, graph, result, new ArrayList<>());
        return result;
    }

    static void path(int index, int[][] graph, List<List<Integer>> result, List<Integer> list){
         list.add(index);
        if(index==graph.length-1) {
            result.add(new ArrayList<>(list));
            return;
        }
       
        for(int i=0;i<graph[index].length;i++){
            path(graph[index][i], graph, result, list);
            list.remove(list.size()-1);
        }
    
    }
}
