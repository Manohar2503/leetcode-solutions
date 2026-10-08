class Solution {

    public List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<>();
        int removeOpen = 0;
        int removeClose = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                removeOpen++;
            }
            else if (ch == ')') {

                if (removeOpen > 0) {
                    removeOpen--;
                }
                else {
                    removeClose++;
                }
            }
        }
        paranthesis(
            0,
            0,
            removeOpen,
            removeClose,
            s,
            set,
            new StringBuilder()
        );

        return new ArrayList<>(set);
    }

    static void paranthesis(int index,int open,int removeOpen,int removeClose,String s,Set<String> set,
            StringBuilder sb) {

        if (index == s.length()) {

            if (open == 0 &&
                removeOpen == 0 &&
                removeClose == 0) {

                set.add(sb.toString());
            }

            return;
        }

        char ch = s.charAt(index);
        if (ch != '(' && ch != ')') {

            sb.append(ch);
            paranthesis(index + 1,open,removeOpen,removeClose,s,set,sb);
            sb.deleteCharAt(sb.length() - 1);

            return;
        }

        if (ch == '(') {

            if (removeOpen > 0) {
                paranthesis(index + 1,open,removeOpen-1,removeClose,s,set,sb);
            }

            sb.append('(');
            paranthesis(index + 1,open+1,removeOpen,removeClose,s,set,sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        else {

            if (removeClose > 0) {
                paranthesis(index + 1,open,removeOpen,removeClose - 1,s,set,sb);
            }

            if (open > 0) {
                sb.append(')');
                paranthesis(index + 1,open-1,removeOpen,removeClose,s,set,sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}