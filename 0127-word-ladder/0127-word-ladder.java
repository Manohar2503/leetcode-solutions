class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        wordSet.addAll(wordList);
        if(!wordSet.contains(endWord)) return 0;

        Queue<String> qu = new LinkedList<>();
        qu.offer(beginWord);
        int result =0;

        while(!qu.isEmpty()){
            int size = qu.size();
            result++;

            for(int j=0;j<size;j++){
                String str = qu.poll();
                StringBuilder sb = new StringBuilder(str);
                if(str.equals(endWord)) return result;

                for(int i=0;i<str.length();i++){
                    char ch = str.charAt(i);
                    
                    for(char c='a';c<='z';c++){
                        sb.setCharAt(i,c);
                        if(wordSet.contains(sb.toString())){
                            qu.offer(sb.toString());
                            wordSet.remove(sb.toString());
                        }
                    }

                    sb.setCharAt(i, ch);
                }
            }
        }

        return 0;
    }
}

/*

    s = hit

    queue - [ hit ]
    size = 1

    queue -> [ hot,]


*/