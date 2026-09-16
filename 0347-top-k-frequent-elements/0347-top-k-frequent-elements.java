class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int val: nums) {
            map.put(val, map.getOrDefault(val, 0)+1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1] - b[1]);
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            pq.offer(new int[]{key,val});
        }
        
        while(k< pq.size())pq.poll();

        int[] result = new int[k];
        int index =0;

        while(!pq.isEmpty()){
            result[index++] = pq.peek()[0];
            pq.poll();
        }

        return result;
    }
}