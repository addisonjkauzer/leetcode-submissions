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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
    }

    public boolean isValidBST(TreeNode root, Integer minimum, Integer maximum) {
        if (root == null) {
            return true;
        }

        if (root.val > minimum && root.val < maximum) {
            return isValidBST(root.left, minimum, root.val) && isValidBST(root.right, root.val, maximum);
        }
        return false;
    }
}
