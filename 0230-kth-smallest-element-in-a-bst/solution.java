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
        ArrayList<Integer> allNodes = getSortedTreeElements(root, new ArrayList<>(), k);
        return allNodes.get(k-1);
        
    }

    private ArrayList<Integer> getSortedTreeElements(TreeNode root, ArrayList<Integer> currentList, int k) {
        if(root == null) {
            return currentList;
        } else {
            currentList.addAll(getSortedTreeElements(root.left, new ArrayList(), k));
            currentList.add(root.val);
            if (currentList.size() >= k) {
                return currentList;
            }
            currentList.addAll(getSortedTreeElements(root.right, new ArrayList(), k));
            return currentList;
        }
    }
}