class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        List<Integer>[] adjList = new ArrayList[n];
        for(int i=0;i<n;i++) adjList[i] = new ArrayList<>();
        int[] indegree = new int[n];
        Queue<Integer> qu = new LinkedList<>();

        for(int i=0; i<n; i++){
            int len = graph[i].length;
            if(len == 0) qu.offer(i);
            indegree[i] = len;

            for(int v : graph[i]){
                adjList[v].add(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!qu.isEmpty()){
            int node = qu.poll();
            result.add(node);

            for(int nextNode: adjList[node]){
                indegree[nextNode]--;
                if(indegree[nextNode] == 0) qu.offer(nextNode);
            }
        }

        Collections.sort(result);
        return result;
    }
}
/**

    0 - > [1,2]
    1 - > [2,3]
    2 - > [5]
    3 - > [0]
    4 - > [5]
    5 - > []
    6 - > []

    0 -> 3
    1 -> 0
    2 -> 0, 1
    3 -> 1
    4 -> 
    5 -> 2, 4
    6 -> 

    5 , 6


*/