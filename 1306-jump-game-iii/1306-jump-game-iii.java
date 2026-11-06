class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        if(arr[start] ==0) return true;
        boolean[] visited = new boolean[n];
        visited[start]= true;

        Queue<Integer> qu = new LinkedList<>();
        qu.offer(start);
        
        while(!qu.isEmpty()){
            int current = qu.poll();
            if(arr[current] ==0) return true;

            int right = current + arr[current];
            int left = current - arr[current];
            
            if(left >=0 && !visited[left]) {
                visited[left] = true;
                qu.offer(left);
            }

            if(right < n && !visited[right]) {
                visited[right] = true;
                qu.offer(right);
            }
        }

        return false;
    }
}