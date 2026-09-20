class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String val : tokens){
            if(isOperator(val)){
                stack.push(evaluator(val, stack));
            }
            else stack.push(Integer.parseInt(val));
        }
        return stack.pop();       
    }
    static boolean isOperator(String op){
        return (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")); 
    }

    static int evaluator(String op, Stack<Integer> st){
        int second = st.pop();
        int first = st.pop();

        if(op.equals("-")) return first - second;
        else if(op.equals("+")) return first + second;
        else if(op.equals("*")) return first * second;
        
        return first / second;
    }
}
/*


    ["2","1","+","3","*"] -> 9

    ["4","13","5","/","+"] -> 6

    ["10","6","9","3","+","-11","*","/","*","17","+","5","+"] ->

    stack - >

    

*/