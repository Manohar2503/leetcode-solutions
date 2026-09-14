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
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        Stack<Node> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        stack.push(root); 
        result.add(root.val);// 1, 3, 5, 6, 

        while(!stack.isEmpty()){ // 1
            Node currentNode = stack.peek();
            if(currentNode.children.size()==0) {
                stack.pop();
                continue;
            }

            Node childNode = currentNode.children.get(0); // 2
            currentNode.children.remove(0);
            result.add(childNode.val);
            stack.push(childNode);
        }

        return result;
    }
}
/*
stack - >
list -[1, 3, 5, 6, 2, 4]

1 - > 
*/