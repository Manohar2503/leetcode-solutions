class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        List<Integer>[] list = new ArrayList[n+1];
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            if(list[val]==null) list[val]=new ArrayList<>();
            list[val].add(key);
        }

        int[] result = new int[k];
        int newk=0;
        for(int i=n;i>0;i--){
            if(list[i]!=null){
                for(int li:list[i]){
                    if(newk<k){
                        result[newk++]= li;
                    }
                    else{
                        break;
                    }
                }
            }
        }

        return result;
    }
}