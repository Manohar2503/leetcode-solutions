class Solution {

    static class Trie{
        Trie[] arr;
        Trie(){
            arr = new Trie[2];
        }
    }
    static Trie root;
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        int[] result = new int[q];

        Arrays.sort(nums);
        int[][] newqueries = new int[q][3];
        for(int i=0;i<q;i++){
            int[] query = queries[i];
            newqueries[i][0] = i;
            newqueries[i][1] = query[0];
            newqueries[i][2] = query[1];
        }

        Arrays.sort(newqueries, (a,b)->Integer.compare(a[2],b[2]));
        int index =0;
        root = new Trie();

        for(int[] query: newqueries){
            int num = query[1];
            int m = query[2];
            while(index<n && nums[index]<=m){
                insert(nums[index]);
                index++;
            }
            if (index == 0) {
                result[query[0]] = -1;
            } else {
              result[query[0]] = findMaxXor(num);
            }
        }
        return result;
    }

    static void insert(int num){
        Trie cur = root;
        for(int i=31;i>=0;i--){
            int bit = (num >>i & 1);
            if(cur.arr[bit]==null){
                cur.arr[bit] = new Trie();
            }
            cur = cur.arr[bit];
        }
    }

    static int findMaxXor(int num){
        Trie cur = root;
        int result =0;
        for(int i=31;i>=0;i--){
            int bit = (num >>i & 1);
            int opposite = 1-bit;
            if(cur.arr[opposite]!=null){
                result |= (1 << i);
                cur = cur.arr[opposite];
            }
            else cur = cur.arr[bit];
        }

        return result;
    }
}