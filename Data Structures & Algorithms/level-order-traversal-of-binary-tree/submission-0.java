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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();

        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.offer(root);
        while (!bfsQueue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            Queue<TreeNode> newQueue = new LinkedList<>();
            for (TreeNode node : bfsQueue) {
                if (node == null) {
                    continue;
                }
                level.add(node.val);
                newQueue.offer(node.left);
                newQueue.offer(node.right);
            }
            bfsQueue = newQueue;
            levelOrder.add(level);
        }
        levelOrder.remove(levelOrder.size() - 1);
        return levelOrder;
    }
}
