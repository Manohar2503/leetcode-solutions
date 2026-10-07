class Solution {
    int[] parent;
    
    private int find(int a){
        if(parent[a] == a) return a;
        parent[a]= find(parent[a]);
        return parent[a];
    }

    private void union(int a, int b){
        int parenta = find(a);
        int parentb = find(b);

        if(parenta != parentb){
            parent[parenta] = parentb;
        }
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        parent = new int[s.length()];
        
        for(int i=0;i<n;i++){
            parent[i] = i;
        }

        for(List<Integer> pair: pairs){
            int a = pair.get(0);
            int b = pair.get(1);

            if(find(a)!=find(b)){
                union(a, b);
            }
        }

        StringBuilder sb = new StringBuilder(s);
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0;i<n;i++){
            map.computeIfAbsent(find(i), k-> new ArrayList<>()).add(i);
        }
        
        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()){
            List<Integer> list = entry.getValue();
            char[] charArray = new char[list.size()];
            int j=0;
            for(int index: list){
                charArray[j++] = sb.charAt(index);
            }
            Arrays.sort(charArray);
            j=0;
            //Collections.sort(list);

            for(int index: list){
                sb.setCharAt(index, charArray[j++]);
            }
        }

        return sb.toString();
    }
}

/*

    1. i use union find 
    2. i use an arr which it stores all parents of indices
    3. i take the similar parents indices in a map
    4. i use char arr for all characters of that indices and i sort it and i place it in ots indeces but in lexicographically.
    5. i return that string initially i use stringbuilder

*/

