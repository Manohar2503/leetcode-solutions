class StockSpanner {
    Stack<int[]> st;
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        int count =1;
        while(!st.isEmpty() && st.peek()[0] <= price){
            int[] peek = st.pop();
            count += peek[1];
        }
        st.push(new int[]{price, count});
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */


/*

    1   6
    100 85
    1 1 1 2 1 4 6

*/