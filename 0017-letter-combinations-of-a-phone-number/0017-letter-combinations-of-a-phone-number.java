class Solution {
    public List<String> letterCombinations(String digits) {
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
        combinations(0, digits, result, new StringBuilder(), map);
        return result;
    }

    static void combinations(int index, String digit, List<String> result, StringBuilder sb, Map<Character, String> map){
        if(index == digit.length()){
            result.add(sb.toString());
            return;
        }
        
        for(char ch : map.get(digit.charAt(index)).toCharArray()){
            sb.append(ch);
            combinations(index+1, digit, result, sb, map);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}