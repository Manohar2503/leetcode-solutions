class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Boolean[] visited = new Boolean[s.length()];
        return segmentation(0, s, wordSet, visited);
    }
    static boolean segmentation(int index, String s, Set<String> wordSet, Boolean[] visited){
        if(s == null || s.length() == 0) return true;
        if(index >= s.length()) return true;

        if(visited[index] != null) return visited[index];
        visited[index] = false;
        for(int i = index; i<s.length();i++){
            String left = s.substring(index, i+1);

            if(wordSet.contains(left)){
                visited[index] |= segmentation(i+1, s, wordSet,visited);
                if(visited[index]) break;
            }
        }

        return visited[index];
    }
}