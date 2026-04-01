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
        HashMap<TreeNode, Boolean> pCache = new HashMap<>();
        HashMap<TreeNode, Boolean> qCache = new HashMap<>();
        while (containsNode(root, p, pCache) && containsNode(root, q, qCache)) {
            if (containsNode(root.left, p, pCache) && containsNode(root.left, q, qCache)) {
                root = root.left;
            } else if (containsNode(root.right, p, pCache) && containsNode(root.right, q, qCache)) {
                root = root.right;
            } else {
                return root;
            }
        }
        throw new RuntimeException("lca not found");
    }

    public boolean containsNode(TreeNode root, TreeNode p, HashMap<TreeNode, Boolean> cache) {
        if (cache.containsKey(p)) {
            return cache.get(p);
        }
        if (root == null) {
            return false;
        }
        if (root.equals(p)) {
            return true;
        }
        boolean contains = containsNode(root.left, p, cache) || containsNode(root.right, p, cache);
        cache.put(root, contains);
        return contains;

    }
}