class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Integer> map = new HashMap<>();
        for(String str: wordDict) map.put(str, map.getOrDefault(str, 0)+1);
        Boolean[] visited = new Boolean[s.length()];
        return isValid(0, s, map, visited);
    }

    static boolean isValid(int start, String s, Map<String, Integer> map, Boolean[] visited){
        if(start >= s.length()) return true;
        if(visited[start] !=null) return visited[start];

        for(int i= start; i< s.length();i++){
            String prefix = s.substring(start, i+1);
            if(map.containsKey(prefix)){
                if (isValid(i + 1, s, map, visited)) {
                    visited[start] = true;
                    return true;
                }
            }
        }
        visited[start] = false;
        return visited[start];
    }
}