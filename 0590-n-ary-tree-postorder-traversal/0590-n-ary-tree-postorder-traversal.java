/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            Node currentNode = stack.peek();
            if(currentNode.children.size()==0){
                result.add(currentNode.val);
                stack.pop();
                continue;
            }
            Node childNode = currentNode.children.get(0);
            currentNode.children.remove(0);
            stack.push(childNode);
        }
        return result;
    }
}
/*
stack - > [1, 3]
list -> [5, 6, ]

1 -> 2 4

*/
