class Solution {

    /*
            3 2 3 1 2 4 5 5 6 
            1 2 2 3 3 4 5 5 6
                          i
            [5,6]
    */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for(int i =0;i<k;i++){
            minheap.add(nums[i]);
        }

        for(int j =k;j<nums.length;j++){
            if(nums[j]> minheap.peek()){
                minheap.poll();
                minheap.add(nums[j]);
            }
        }
       return minheap.poll();
    }
}