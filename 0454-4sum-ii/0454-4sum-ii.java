class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int result = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int val = nums1[i] + nums2[j];
                map1.put(val, map1.getOrDefault(val,0)+1);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int val = nums3[i] + nums4[j];
                map2.put(val, map2.getOrDefault(val,0)+1);
            }
        }

        for(Map.Entry<Integer, Integer> entry1 : map1.entrySet()){
            for(Map.Entry<Integer, Integer> entry2 : map2.entrySet()){
                int val1 = entry1.getKey();
                int val2 = entry2.getKey();
                if(val1 + val2 == 0) result += map1.get(val1) * map2.get(val2);
            }
        }

        return result;
    }
}