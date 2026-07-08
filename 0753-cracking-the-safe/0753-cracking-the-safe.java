class Solution {

    public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder();

        // Start with n zeros
        for (int i = 0; i < n; i++) {
            sb.append('0');
        }

        Set<String> visited = new HashSet<>();
        visited.add(sb.toString());

        dfs(sb, n, k, visited);

        return sb.toString();
    }

    private boolean dfs(StringBuilder sb, int n, int k, Set<String> visited) {

        if (visited.size() == (int) Math.pow(k, n)) {
            return true;
        }
        
        String prefix = sb.substring(sb.length() - (n - 1));
        for (int i = 0; i < k; i++) {
            String next = prefix + (char) ('0' + i);
            if (visited.contains(next)) {
                continue;
            }

            visited.add(next);
            sb.append((char) ('0' + i));

            if (dfs(sb, n, k, visited)) {
                return true;
            }
            visited.remove(next);
            sb.deleteCharAt(sb.length() - 1);
        }

        return false;
    }
}