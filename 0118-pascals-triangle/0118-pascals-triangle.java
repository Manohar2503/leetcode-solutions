class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        result.add(prev);
        for(int i=1;i<numRows;i++){
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            int j =0;
            while(j < prev.size()-1){
                int num1 = prev.get(j);
                int num2 = prev.get(j+1);
                cur.add(num1+num2);
                j++;
            }
            cur.add(1);
            prev = cur;
            result.add(cur);
        }
        return result;
    }
}


/*

    num = 1
         [1]
       [1 , 1]
      [1, 2, 1]
     [1, 3, 3, 1]
    [1, 4, 6, 4, 1]
    

*/