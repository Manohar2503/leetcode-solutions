class Solution {
    private int[] parent;
    public boolean equationsPossible(String[] equations) {
        int n = equations.length;
        parent = new int[26];
        for(int i=0;i<26;i++) parent[i]=i;
        List<int[]> list = new ArrayList<>();

        for(String s: equations){
            int u = (int) s.charAt(0) - 'a';
            int v = (int) s.charAt(3) - 'a';
            char ch = s.charAt(1);
            if(ch == '=' && find(u)!=find(v)){
                parent[find(v)] = find(u);
            }
            else if(ch == '!')list.add(new int[]{u,v});
        }

        for(int[] arr: list){
            int u = arr[0];
            int v = arr[1];
            if(find(u) == find(v)) return false;
        }

        return true;
    }

    private int find(int node){
        if(parent[node] == node) return node;
        parent[node] = find(parent[node]);
        return parent[node];
    }

}