class FreqStack {
    int max_freq;
    Map<Integer, Integer> freqMap;
    Map<Integer, List<Integer>> mapList;
    public FreqStack() {
        max_freq = 0;
        freqMap = new HashMap<>();
        mapList = new HashMap<>();
    }
    
    public void push(int val) {
        freqMap.put(val, freqMap.getOrDefault(val, 0)+1);
        int freq = freqMap.get(val);
        max_freq = Math.max(max_freq, freq);
        mapList.computeIfAbsent(freq, k -> new ArrayList<>()).add(val);
    }
    
    public int pop() {
        List<Integer> list = mapList.get(max_freq);
        int size = list.size();
        //if(size == 0) return 0;
        if(size == 1) max_freq--;
        int val = list.get(size-1);
        freqMap.put(val, freqMap.get(val)-1);
        list.remove(size-1); 
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */