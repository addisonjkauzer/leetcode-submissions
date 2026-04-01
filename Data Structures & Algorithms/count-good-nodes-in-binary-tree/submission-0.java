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
    public int goodNodes(TreeNode root) {
        return dfsGoodNodes(root, root.val);
        
    }

    public Integer dfsGoodNodes(TreeNode node, Integer currentMax) {
        if (node == null) {
            return 0;
        }
        else {
            Integer newMax = Math.max(currentMax, node.val);
            return dfsGoodNodes(node.left, newMax) + dfsGoodNodes(node.right, newMax) + (node.val >= currentMax ? 1 : 0);
            
        }
    }
}
