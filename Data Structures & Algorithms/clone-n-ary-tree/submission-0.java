/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public Node cloneTree(Node root) {
        return dfsCloneTree(root);
    }

    public Node dfsCloneTree(Node root) {
        if (root == null) {
            return null;
        }
        ArrayList<Node> newChildren = new ArrayList<>();

        for (Node child : root.children) {
            newChildren.add(dfsCloneTree(child));
        }
        Node newNode = new Node(root.val, newChildren);
        return newNode;
    }
}
