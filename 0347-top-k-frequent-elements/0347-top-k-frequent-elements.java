class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        List<Integer>[] list = new ArrayList[n+1];
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int val: nums){
            map.put(val, map.getOrDefault(val, 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            
            if(list[val] == null) list[val] = new ArrayList<>();
            list[val].add(key);
        }

        List<Integer> result = new ArrayList<>();
        for(int i=n;i>=0;i--){
            if(list[i]!=null){
                for(int key: list[i]){
                    if(--k>=0) result.add(key);
                    else break;
                } 
            }
        }

        int[] arr = new int[result.size()];
        for(int i=0;i<result.size();i++) arr[i] = result.get(i);

        return arr; 
    }
}