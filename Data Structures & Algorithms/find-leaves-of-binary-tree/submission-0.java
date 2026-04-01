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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        getHeight(root, result);
        return result;
    }

    public Integer getHeight(TreeNode root, List<List<Integer>> result) {
        if (root == null) {
            return -1;
        }
        Integer leftHeight = getHeight(root.left, result);
        Integer rightHeight = getHeight(root.right, result);

        Integer currentHeight = Math.max(leftHeight, rightHeight) + 1;

        if (result.size() == currentHeight) {
            result.add(new ArrayList<>());
        }
        result.get(currentHeight).add(root.val);

        return currentHeight;

    }
}
