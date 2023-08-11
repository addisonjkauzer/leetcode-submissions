/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (containsNode(root.left, p) && containsNode(root.left, q)) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (containsNode(root.right, p) && containsNode(root.right, q)) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    private boolean containsNode(TreeNode root, TreeNode target) {
        if (root == target) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (root.right == target || root.left == target) {
            return true;
        }
        if (containsNode(root.right, target) || containsNode(root.left, target)) {
            return true;
        }
        return false;
    }
}