class Solution {

    public List<Integer> diffWaysToCompute(String expression) {
        return helper(expression, new HashMap<>());
    }

    private List<Integer> helper(String expression,
                                 Map<String, List<Integer>> memo) {

        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == '+' || ch == '-' || ch == '*') {

                String leftExpr = expression.substring(0, i);
                String rightExpr = expression.substring(i + 1);

                List<Integer> leftList = helper(leftExpr, memo);
                List<Integer> rightList = helper(rightExpr, memo);

                for (int left : leftList) {
                    for (int right : rightList) {

                        if (ch == '+') {
                            result.add(left + right);
                        } else if (ch == '-') {
                            result.add(left - right);
                        } else {
                            result.add(left * right);
                        }
                    }
                }
            }
        }

        // Base case: expression is just a number
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }

        memo.put(expression, result);
        return result;
    }
}