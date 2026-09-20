class MinStack {
    Stack<int[]> stack;
    //int minStack;
    public MinStack() {
        stack = new Stack<>();
        //minStack = Integer.MAX_VALUE;
    }
    
    public void push(int value) {
        //minStack = Math.min(minStack, value);
        int minValue = (stack.isEmpty())?value:stack.peek()[1];
        stack.push(new int[]{value, Math.min(minValue, value)});
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */