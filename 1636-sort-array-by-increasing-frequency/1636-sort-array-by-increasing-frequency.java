class Solution {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;
        if(n<=2) return nums;
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        List<Integer>[] bucket = new ArrayList[n+1];
        for(int i=0;i<=n;i++) bucket[i] = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            bucket[val].add(key);
        }

        int[] result = new int[n];
        int index =0;

        for(int i=1;i<=n;i++){
            if(bucket[i].size()!=0){
                Collections.sort(bucket[i], Collections.reverseOrder());
                for(int keys: bucket[i]) {
                    for(int j=0;j<i;j++) result[index++] = keys;
                }
            }
        }

        return result;
    }
}