class Solution {
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> result = new ArrayList<>();

        combinations(0, digits, map, result, new StringBuilder());
        return result;
    }

    static void combinations(int index, String digits, Map<Character, String> map, List<String> result, StringBuilder sb){
        if(index >= digits.length()) {
            result.add(sb.toString());
            return;
        }
        
            char c = digits.charAt(index);
            for(char ch: map.get(c).toCharArray()){
                sb.append(ch);
                combinations(index+1, digits, map, result, sb);
                sb.deleteCharAt(sb.length()-1);
            }
    }
}
/*

    digits =  2  3
            2 ->  a b c
            3 ->  d e f
            4 ->  
            ab , ae, af, bd, be, bf, cd, ce, cf
*/