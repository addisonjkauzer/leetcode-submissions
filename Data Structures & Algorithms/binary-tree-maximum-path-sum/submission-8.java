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
    public int maxPathSum(TreeNode root) {
        int[] maxConnected = new int[1];
        maxConnected[0] = Integer.MIN_VALUE;
        Integer maxDepth = maxPathDFS(root, maxConnected);
        return Math.max(maxConnected[0], maxDepth);
        
    }

    public Integer maxPathDFS(TreeNode root, int[] maxConnected) {
        if (root == null) {
            return 0;
        }
        final Integer maxPathLeft = maxPathDFS(root.left, maxConnected);
        final Integer maxPathRight = maxPathDFS(root.right, maxConnected);
        final Integer maxConnectedRoot = maxPathLeft + maxPathRight + root.val;

        maxConnected[0] = Math.max(maxConnected[0], maxConnectedRoot);
        maxConnected[0] = Math.max(maxConnected[0], root.val);
        maxConnected[0] = Math.max(maxConnected[0], Math.max(maxPathLeft, maxPathRight) + root.val);

        return Math.max(Math.max(maxPathLeft, maxPathRight) + root.val, root.val);

    }
}
