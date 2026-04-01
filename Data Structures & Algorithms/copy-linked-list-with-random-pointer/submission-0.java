/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        final HashMap<Node, Node> oldNodeToNewNode = new HashMap<>();

        Node iteratorOld = head;
        
        while (iteratorOld != null) {
            Node newNode = new Node(iteratorOld.val);
            oldNodeToNewNode.put(iteratorOld, newNode);
            iteratorOld = iteratorOld.next;
        }
        
        iteratorOld = head; 
        while (iteratorOld != null) {
            Node iteratorNew = oldNodeToNewNode.get(iteratorOld);

            Node oldRandom = iteratorOld.random;
            Node newRandom = oldNodeToNewNode.get(oldRandom);
            iteratorNew.random = newRandom;

            Node oldNext = iteratorOld.next;
            Node newNext = oldNodeToNewNode.get(oldNext);
            iteratorNew.next = newNext;

            iteratorOld = iteratorOld.next;
        }

        return oldNodeToNewNode.get(head);
    }
}
