class Solution {
    static int count;

    public int countArrangement(int n) {
        count =0;
        permutation(1, n, new HashSet<>());
        return count;    
    }
    static void permutation(int index, int n, Set<Integer> set){
        if(index > n){
            count++;
            return;
        }

        for(int i=1;i<=n;i++){
            if(((i % index) ==0 || (index % i) == 0) && !set.contains(i)){
                set.add(i);
                permutation(index+1, n, set);
                set.remove(i);
            }
        }
    }

}