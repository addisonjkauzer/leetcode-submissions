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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSide = new ArrayList<>();
        bfsGetRightMostVisible(root, rightSide);

        return rightSide;
        
    }

    public void bfsGetRightMostVisible(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> level = new ArrayDeque<>();
        level.offer(root);

        while (!level.isEmpty()) {
            list.add(level.peekLast().val);

            final Deque<TreeNode> newLevel = new ArrayDeque<>();
            for (TreeNode node : level) {
                if (node.left != null) {
                    newLevel.offer(node.left);
                }
                if (node.right != null) {
                    newLevel.offer(node.right);
                }
            }
            level = newLevel;
        }
    }
}
