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
    Integer preOrderTracker = 0;
    HashMap<Integer, Integer> indices = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indices.put(inorder[i], i);
        }
        return buildTreeDFS(preorder, inorder);
    }

    public TreeNode buildTreeDFS(int[] preorder, int[] inorder) {
        final TreeNode root = new TreeNode(preorder[preOrderTracker]);
        Integer indexOfRootInOrder = indices.get(preorder[preOrderTracker]);
        final int[] leftTreeInOrder = Arrays.copyOfRange(inorder, 0, indexOfRootInOrder);
        final int[] rightTreeInOrder = Arrays.copyOfRange(inorder, indexOfRootInOrder + 1, inorder.length);
        if (leftTreeInOrder.length > 0) {
            preOrderTracker++;
            root.left = buildTree(preorder, leftTreeInOrder);
        }
        if (rightTreeInOrder.length > 0) {
            preOrderTracker++;
            root.right = buildTree(preorder, rightTreeInOrder);
        }
        return root;
    }
}
