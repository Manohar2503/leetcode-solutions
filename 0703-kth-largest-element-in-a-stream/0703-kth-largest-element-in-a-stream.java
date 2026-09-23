class KthLargest {
    int k;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        
        for(int i=0;i<Math.min(nums.length, k);i++) pq.offer(nums[i]);
        for(int i=k;i<nums.length;i++){
            if(nums[i] > pq.peek()){
                pq.poll();
                pq.offer(nums[i]);
            }
        }
    }
    
    public int add(int val) {
        if(pq.size()==k && val > pq.peek()){
            pq.poll();
            pq.offer(val);
        }
        else if(pq.size()<k) pq.offer(val);
        
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */