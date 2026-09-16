class RandomizedSet {

    private List<Integer> list;
    private Map<Integer,Integer> mapIdx;

    public RandomizedSet() {
        list = new ArrayList<>();
        mapIdx = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(mapIdx.containsKey(val)) return false;

        mapIdx.put(val,list.size());
        list.add(val);

        return true;
    }
    
    public boolean remove(int val) {
        if(!mapIdx.containsKey(val)) return false;

        int index = mapIdx.get(val);
        int arrSize = list.size();
        int lastVal = list.get(arrSize - 1);
        mapIdx.put(lastVal,index);
        mapIdx.remove(val);

        list.set(index,lastVal);
        list.remove(arrSize-1);


        return true;
    }
    
    public int getRandom() {
        int randomIdx = (int)(Math.random() * list.size());
        return list.get(randomIdx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */