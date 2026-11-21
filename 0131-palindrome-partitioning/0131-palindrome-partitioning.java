class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        solve(0, s, result, new ArrayList<>());
        return result;
    }

    static void solve(int index, String s,  List<List<String>> result, List<String> list){
        if(index == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i=index;i<s.length();i++){
            if(isPalindrome(s, index, i)){
                list.add(s.substring(index,i+1));
                solve(i+1, s, result, list);
                list.remove(list.size()-1);
            }
        }
    }

    static boolean isPalindrome(String s, int left, int right){
        while(left < right){
            if(s.charAt(left)!=s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }
}