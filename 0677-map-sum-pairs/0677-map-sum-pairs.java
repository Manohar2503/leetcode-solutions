class MapSum {
    Map<String, Integer> map;
    Set<String> set;
    public MapSum() {
        map = new HashMap<>();
        set = new HashSet<>();
    }
    
    public void insert(String key, int val) {
        map.put(key, val);
        set.add(key);
    }
    
    public int sum(String prefix) {
        int prefixLen = prefix.length();
        int sum = 0;
        for(String str:set){
            int strLen = str.length();
            boolean isValid =  true;

            if(prefixLen <= strLen) 
            for(int i=0;i<Math.min(prefixLen, strLen);i++){
                char strChar = str.charAt(i);
                char prefixChar = prefix.charAt(i);
                if(strChar != prefixChar){
                    isValid = false;
                    break;
                }
            }
            else isValid = false;
            if(isValid) sum += map.get(str);
        }
        return sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */