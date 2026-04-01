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
    public int rob(TreeNode root) {
        return rob(root, false, new HashMap<>());
    }

    public int rob(final TreeNode root, final boolean mustSkip, final HashMap<TreeNode, Integer> cache) {
        if (root == null) {
            return 0;
        }
        if (mustSkip) {
            return rob(root.left, false, cache) + rob(root.right, false, cache);
        }
        if (cache.containsKey(root)) {
            return cache.get(root);
        }

        //Skip Current
        final Integer skipCurrent = rob(root.left, false, cache) + rob(root.right, false, cache);

        //Rob current
        final Integer takeCurrent = root.val + rob(root.left, true, cache) + rob(root.right, true, cache);

        //Take max
        final Integer maxRob = Math.max(skipCurrent, takeCurrent);

        cache.put(root, maxRob);
        return maxRob;
    }
}