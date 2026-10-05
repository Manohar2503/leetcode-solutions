class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
     List<Integer> list = new ArrayList<>();
     int wordLength = words[0].length();
     int totalWords = words.length;

     Map<String,Integer> map = new HashMap<>();
     for(String word:words){
        map.put(word,map.getOrDefault(word,0)+1);
     }

     for(int i=0;i<wordLength;i++){
        int left=i;
        int right=i;
        int count=0;
        Map<String,Integer> visitedMap = new HashMap<>();

        while(right+wordLength <= s.length()){
            String word = s.substring(right,right+wordLength);
            right += wordLength;
            
            if(map.containsKey(word)){
                visitedMap.put(word,visitedMap.getOrDefault(word,0)+1);
                count++;
                while(visitedMap.get(word) > map.get(word)){
                    String leftword = s.substring(left,left+wordLength);
                    visitedMap.put(leftword, visitedMap.get(leftword)-1);
                    count--;
                    left += wordLength;
                }
                if(count==totalWords){
                    list.add(left);
                }
            }
            else{
                visitedMap.clear();
                count=0;
                left= right;
            }
        }
     }
        return list;
    }
}
