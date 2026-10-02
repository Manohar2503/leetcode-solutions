class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
     TreeMap<Integer, Integer> map = new TreeMap<>();
     for(int[] item: items){
        int u = item[0];
        int v = item[1];
        int prevalue = map.getOrDefault(u,0);
        map.put(u, Math.max(prevalue, v));
     }    

     List<Integer> list = new ArrayList<>(map.keySet());
     int max =0;
     for(int n: list){
            max = Math.max(max, map.get(n));
            map.put(n, max);
     }

     int[] result = new int[queries.length];
     int index =0; 
     for(int query: queries){
        result[index++] = binarySearch(list, query, map); 
     }

     return result;
    }

    static int binarySearch(List<Integer> list, int q, TreeMap<Integer, Integer> map){
        int left =0;
        int right= list.size()-1;
        int answer =0;
        while (left <= right) {
        int mid = left + (right - left) / 2;

        if (list.get(mid) <= q) {
            answer = map.get(list.get(mid));
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

        return answer;
    }
}
/*
    [1,2],[3,2],[2,4],[5,6],[3,5]
    
    map : {
        1 : 2
        3 : 5
        2 : 4
        5 : 6
    }
    keys = 1 2 3 5
    queries = 1 2 4 5 3 6

    
*/