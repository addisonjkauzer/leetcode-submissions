/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void recoverTree(TreeNode root) {
        ArrayList<TreeNode> inorderList = new ArrayList<>();
        inorder(root, inorderList);

        TreeNode wrongNode1 = null;
        TreeNode wrongNode2 = null;

        for (int i = 0; i < inorderList.size() - 1; i++) {
            Integer current = inorderList.get(i).val;
            Integer next = inorderList.get(i + 1).val;

            if (current > next) {
                wrongNode1 = inorderList.get(i + 1);
                if (wrongNode2 == null) {
                    wrongNode2 = inorderList.get(i);
                } else {
                    break;
                } 
            }
        }
        Integer temp  = wrongNode1.val;
        wrongNode1.val = wrongNode2.val;
        wrongNode2.val = temp;
    }

    public void inorder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }
}