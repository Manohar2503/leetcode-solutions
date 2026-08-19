class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Set<String> set = new HashSet<>();
        for(String str: wordList){
            set.add(str);
        }

        int count =0;
        Queue<String> qu = new LinkedList<>();
        qu.offer(beginWord);

        while(!qu.isEmpty()){
            int size = qu.size();
            count++;
            for(int i=0;i<size;i++){
                String cur = qu.poll();
                if(cur.equals(endWord)) return count;
                char[] curArray = cur.toCharArray();
                for(int j=0;j<curArray.length;j++){
                    char c = curArray[j];
                    for(char ch='a';ch<='z';ch++){
                        curArray[j] = ch;
                        String s = new String(curArray);
                        if(set.contains(s)) {
                            qu.offer(s);
                            set.remove(s);
                        }
                    }
                    curArray[j] = c;
                }
            }
            
        }

        return 0;
    }
}

/*
    hit =   ,  end = cog 

    list = "hot","dot","dog","lot","log","cog"
    

*/