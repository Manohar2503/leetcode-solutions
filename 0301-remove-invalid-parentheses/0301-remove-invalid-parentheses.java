class Solution {

    static int maxLen;

    public List<String> removeInvalidParentheses(String s) {

        Set<String> set = new HashSet<>();

        maxLen = 0;

        paranthesis(0, 0, s, set, new StringBuilder());

        if (set.isEmpty()) {
            set.add("");
        }

        return new ArrayList<>(set);
    }

    static void paranthesis(
            int index,
            int count,
            String s,
            Set<String> set,
            StringBuilder sb) {

        // Reached the end
        if (index == s.length()) {

            if (count == 0) {

                // Found a valid string longer than previous ones
                if (sb.length() > maxLen) {
                    maxLen = sb.length();

                    set.clear();

                    set.add(sb.toString());
                }

                // Another valid string with the same maximum length
                else if (sb.length() == maxLen) {
                    set.add(sb.toString());
                }
            }

            return;
        }

        char ch = s.charAt(index);

        // Normal character
        if (ch != '(' && ch != ')') {

            sb.append(ch);

            paranthesis(index + 1, count, s, set, sb);

            // Backtrack
            sb.deleteCharAt(sb.length() - 1);

            return;
        }

        // -------------------------
        // Take current parenthesis
        // -------------------------

        if (ch == '(') {

            sb.append(ch);

            paranthesis(
                index + 1,
                count + 1,
                s,
                set,
                sb
            );

            // Backtrack
            sb.deleteCharAt(sb.length() - 1);
        }

        else { // ')'

            // We can keep ')' only if
            // there is an unmatched '('
            if (count > 0) {

                sb.append(ch);

                paranthesis(
                    index + 1,
                    count - 1,
                    s,
                    set,
                    sb
                );

                // Backtrack
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        // -------------------------
        // Don't take parenthesis
        // -------------------------

        paranthesis(
            index + 1,
            count,
            s,
            set,
            sb
        );
    }
}