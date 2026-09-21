class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        parenthesis(0,0,n,result, new StringBuilder());
        return result;
    }

    static void parenthesis(int opencount , int closedcount, int n, List<String> result, StringBuilder sb){
        if(sb.length()==2*n){
            result.add(sb.toString());
            return;
        }

        if(opencount<n){    
            sb.append('(');
            parenthesis(opencount+1, closedcount, n, result, sb);
             sb.deleteCharAt(sb.length()-1);
        }

         if(closedcount < opencount){   
            sb.append(')');
            parenthesis(opencount, closedcount+1, n, result, sb);
             sb.deleteCharAt(sb.length()-1);
        }
       
    }
}