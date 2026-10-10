class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if(k>n) return result;
        combinations(1, n,k, result, new ArrayList<>());
        return result;
    }

    static void combinations(int index, int n, int k, List<List<Integer>> result, List<Integer> list){
        if(list.size() == k){
            result.add(new ArrayList<>(list));
            return;
        }
        if(index>n) return;

        for(int i=index;i<=n;i++){
            list.add(i);
            combinations(i+1, n, k, result, list);
            list.remove(list.size()-1);
        }
    }
}
/**

        1 2 3 4
          i   j

        1 

    1 2
    1 3
    1 4
    2 3
 */