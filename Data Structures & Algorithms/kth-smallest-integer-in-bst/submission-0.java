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
    public int kthSmallest(TreeNode root, int k) {
        final ArrayList<Integer> orderedTerms = new ArrayList<>();
        populateArrayWithBST(root, orderedTerms);
        return orderedTerms.get(k-1);
    }

    public void populateArrayWithBST(TreeNode root, List<Integer> toBePopulated) {
        if (root == null) {
            return;
        }
        populateArrayWithBST(root.left, toBePopulated);
        toBePopulated.add(root.val);
        populateArrayWithBST(root.right, toBePopulated);
    }
}
