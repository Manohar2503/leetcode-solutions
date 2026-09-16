class RandomizedSet {
    Map<Integer, Integer> map;
    public RandomizedSet() {
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val, 1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        
        List<Integer> keys = new ArrayList<>(map.keySet());
        Random random = new Random();
        int randomNum = keys.get(random.nextInt(keys.size()));
        return randomNum;
    
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */