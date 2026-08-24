class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] ch  = s.toCharArray();
            Arrays.sort(ch);
            String news = new String(ch);
            map.computeIfAbsent(news, k->new ArrayList()).add(s);
        }
        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            list.add(entry.getValue());
        }
        return list;
    }
}