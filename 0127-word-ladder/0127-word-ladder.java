class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        int res=0; 
        Set<String> map = new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            map.add(wordList.get(i));
        }
        Queue<String> qu = new LinkedList<>();
        qu.offer(beginWord);
        int m = beginWord.length();
        while(!qu.isEmpty()){
            int len = qu.size();
            res++;
            for(int k=0;k<len;k++){
                String word = qu.poll();
                char[] charArr = word.toCharArray();
                for(int i=0;i<m;i++){                
                char ch = charArr[i];
                for(char j='a';j<='z';++j){
                    charArr[i]=j;
                    String newStr = new String(charArr);
                    if(!map.contains(newStr))
                    continue;
                    if(newStr.equals(endWord)) return res+1;
                    map.remove(newStr);
                    qu.offer(newStr);
                }
                charArr[i]=ch;
            }
            }
        }
        return 0;
    }
}

