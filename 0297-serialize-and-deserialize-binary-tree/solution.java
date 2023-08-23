/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        String returned = "";
        ArrayList<TreeNode> pastLevel = new ArrayList();
        pastLevel.add(root);

        while(pastLevel.size() > 0) {
            TreeNode current = pastLevel.get(0);
            pastLevel.remove(0);
            if (current == null) {
                returned += "null,";
            } else {
                returned += current.val + ",";
                pastLevel.add(current.left);
                pastLevel.add(current.right);
            }
        }
        return returned;
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("null")) {
            return null;
        }
        ArrayList<TreeNode> queue = new ArrayList();
        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.add(root);

        for(int i = 1; i < nodes.length-1; i = i+2) {
            TreeNode parent = queue.get(0);
            queue.remove(0);
            if (nodes[i].equals("null")) {
                parent.left = null;
            } else {
                TreeNode leftChild = new TreeNode(Integer.parseInt(nodes[i]));
                parent.left = leftChild;
                queue.add(leftChild);
            }

            if (nodes[i+1].equals("null")) {
                parent.right = null;
            } else {
                TreeNode rightChild = new TreeNode(Integer.parseInt(nodes[i+1]));
                parent.right = rightChild;
                queue.add(rightChild);
            }
        }

        for (TreeNode node : queue) {
            node.left = null;
            node.right = null;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));