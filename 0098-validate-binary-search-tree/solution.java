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
    Integer min = Integer.MIN_VALUE;
    Integer max = Integer.MAX_VALUE;
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, Integer shouldBeGreaterThan, Integer shouldBeLessThan) {
        if (root == null) {
            return true;
        }
        if (shouldBeLessThan != null && root.val >= shouldBeLessThan) {
            return false;
        }
        if (shouldBeGreaterThan != null && root.val <= shouldBeGreaterThan) {
            return false;
        }
        if (root.left != null && root.left.val >= root.val) {
            return false;
        }
        if (root.right != null && root.right.val <= root.val) {
            return false;
        }
        if (isValidBST(root.left, shouldBeGreaterThan, root.val) && isValidBST(root.right, root.val, shouldBeLessThan)) {
            return true;
        }
        return false;
    }
}