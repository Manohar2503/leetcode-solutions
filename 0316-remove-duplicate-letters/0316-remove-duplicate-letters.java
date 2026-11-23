class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        boolean[] visited = new boolean[26];

        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']--;

            if (visited[ch - 'a']) continue;

            while (!st.isEmpty() &&
                   st.peek() > ch &&
                   freq[st.peek() - 'a'] > 0) {

                char removed = st.pop();
                visited[removed - 'a'] = false;
            }

            st.push(ch);
            visited[ch - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}