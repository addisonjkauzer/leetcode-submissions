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
        if (root == null) {
            return new ArrayList();
        }
        ArrayList<List<TreeNode>> list = new ArrayList();


        ArrayList<TreeNode> level = new ArrayList();
        level.add(root);
        list.add(level);

        while (level.size() > 0) {
            level = new ArrayList();
            for(TreeNode node : list.get(list.size()-1)) {
                if (node.left != null) {
                    level.add(node.left);
                }
                if (node.right != null) {
                    level.add(node.right);
                }
            }
            if (level.size() > 0) {
                list.add(level);
            }
        }

        ArrayList<List<Integer>> solution = new ArrayList();
        for (List<TreeNode> nodes : list) {
            ArrayList<Integer> temp = new ArrayList();
            for (TreeNode node : nodes) {
                temp.add(node.val);
            }
            solution.add(temp);
        }
        return solution;
        
        
    }
}