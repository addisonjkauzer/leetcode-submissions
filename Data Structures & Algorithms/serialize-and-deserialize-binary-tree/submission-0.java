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

public class Codec {

    final static String NULL_STRING = "null";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            LinkedList newQueue = new LinkedList<>();
            for (final TreeNode queueItem : queue) {
                if (queueItem == null) {
                    stringBuilder.append("," + NULL_STRING);
                } else {
                    stringBuilder.append(String.format(",%s", queueItem.val));
                    newQueue.offer(queueItem.left);
                    newQueue.offer(queueItem.right);
                }
            }
            queue = newQueue;
        }
        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }

        final String[] nodeValues = data.split(",");
        LinkedList<TreeNode> queue = new LinkedList<>();
        Integer nodeValuesIndex = 1;
        final TreeNode root = new TreeNode(Integer.parseInt(nodeValues[nodeValuesIndex]));

        queue.offer(root);
        nodeValuesIndex++;

        while (!queue.isEmpty()) {
            LinkedList newQueue = new LinkedList<>();
            for (final TreeNode queueItem : queue) {
                //left node
                final String leftNodeValue = nodeValues[nodeValuesIndex];
                if (NULL_STRING.equals(leftNodeValue)) {
                    queueItem.left = null;
                } else {
                    final TreeNode newLeft = new TreeNode(Integer.parseInt(leftNodeValue));
                    queueItem.left = newLeft;
                    newQueue.offer(newLeft);
                }
                nodeValuesIndex++;

                //Right node
                final String rightNodeValue = nodeValues[nodeValuesIndex];
                if (NULL_STRING.equals(rightNodeValue)) {
                    queueItem.right = null;
                } else {
                    final TreeNode newRight = new TreeNode(Integer.parseInt(rightNodeValue));
                    queueItem.right = newRight;
                    newQueue.offer(newRight);
                }
                nodeValuesIndex++;
            }
            queue = newQueue;
        }

        return root;
    }
}
