class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for(char c: num.toCharArray()){
            while(!st.isEmpty() && st.peek() >c && k > 0){
                st.pop();
                k--;
            }
            st.push(c);
        }

        while(k>0){
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        String ns = sb.reverse().toString();
        ns = ns.replaceFirst("^0+","");
        return ns.isEmpty() ? "0" : ns;
    }
}
