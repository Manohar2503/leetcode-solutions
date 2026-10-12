class StockSpanner {
    List<Integer> list;
    public StockSpanner() {
        list= new ArrayList<>();
    }
    
    public int next(int price) {
        
        list.add(price);
        int count=1;
        int j = list.size()-2;
        while(j>=0){
            if(list.get(j) <= price){
                count++;
                j--;
            }
            else{
                break;
            }
        }
    
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */