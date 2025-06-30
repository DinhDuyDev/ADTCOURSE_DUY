public class TwoThreeTree {
    private Node root;

    public TwoThreeTree() {
        root = null;
    }

    public Node insertionHelp(Node currNode, int key, int val) {
        if (currNode.isLeaf()) {
            if (key < currNode.getRightKey()) {
                Node newNode = new Node(val, val, key, val, null, null, null);
                currNode.setLeft(key, val);
            } else if (key > currNode.getLeftKey()) {
                currNode.setRight(key, val);
            } else {
                currNode.
            }
        } else {
            if (key < currNode.getLeftKey()) {
                return insertionHelp(currNode.getLeftChild(), key, val);
            } else if (key > currNode.getRightKey()) {
                return insertionHelp(currNode.getRightChild(), key, val);
            } else {
                return insertionHelp(currNode.getCenterChild(), key, val);
            }
        }
    }
}
