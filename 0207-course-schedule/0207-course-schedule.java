class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        if(prerequisites.length==0) return true;

        List<Integer>[] adj = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            adj[i]= new ArrayList<>();
        }
        
        for(int[] arr: prerequisites){
            adj[arr[0]].add(arr[1]);
        }

        int[] indegree = new int[numCourses];
        for(List<Integer> list: adj){
            for(int ele:list){
                indegree[ele]++;
            }
        }
        Queue<Integer> qu = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                qu.offer(i);
            }
        }
        
        int[] result = new int[numCourses];
        int index=0;
        while(!qu.isEmpty()){
            int val = qu.poll();
            result[index++] = val;
            for(int neighbour: adj[val]){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    qu.offer(neighbour);
                }
            }
        }
        if(index!=numCourses){
            return false;
        }
return true;
    }
}