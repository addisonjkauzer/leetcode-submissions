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
    Boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return isBalanced;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            Integer left = maxDepth(root.left) + 1;
            Integer right = maxDepth(root.right) + 1;
            isBalanced = isBalanced && Math.abs(left - right) <= 1;
            return Math.max(left, right);
        }
    }
}
