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
    Integer maxConnected = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        this.maxDepth(root);
        return this.maxConnected;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            Integer depthLeft = maxDepth(root.left);
            Integer depthRight = maxDepth(root.right);
            this.maxConnected = Math.max(this.maxConnected, depthLeft + depthRight);
            return Math.max(depthLeft, depthRight) + 1;
        }
    }
}
