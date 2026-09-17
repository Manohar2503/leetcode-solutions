class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        combinations(1, 0, n, k, result, new ArrayList<>());
        return result;
    }

    static void combinations(int index, int count, int n , int k, List<List<Integer>> result, List<Integer> list){
        if(count == k){
            result.add(new ArrayList<>(list));
            return;
        }
        if(index>n) return;
        for(int i=index;i<=n;i++){
            list.add(i); // 1 2
            combinations(i+1,count+1, n, k, result, list);
            list.remove(list.size()-1);
        }
    }
}