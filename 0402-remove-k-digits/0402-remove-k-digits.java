class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if(n == k) return "0";

        Stack<Character> st = new Stack<>();
        for(char ch: num.toCharArray()){
            while(!st.isEmpty() && k>0 && st.peek() > ch){
                st.pop();
                k--;
            }
            st.push(ch);
        }
       
        while(k>0){
            k--;
            st.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        String s = sb.reverse().toString().replaceFirst("^0+", "");
        return (s.length()==0)?"0":s;
    }
}

/*

        1 4 3 2 2 1 9
                i
    k = 3
stack - [1,2,1,9]

        9 1 2 1 -> 1 2 1 9

        1 0 2 0 0 
           i 

stack - [0, ]
*/