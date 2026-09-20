class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] result = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] arr: prerequisites){
            adj.get(arr[1]).add(arr[0]);
        }

        int[] inorder = new int[numCourses];
        for(List<Integer> li: adj){
            for(int val: li){
                inorder[val]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inorder[i]==0) q.offer(i);
        }
        int index=0;
        while(!q.isEmpty()){
            int node = q.poll();
            result[index++]=node;
            for(int val: adj.get(node)){
                inorder[val]--;
                if(inorder[val]==0) q.offer(val);
            }
        }
        if(index!=numCourses) return new int[]{};
        return result; 
    }
}