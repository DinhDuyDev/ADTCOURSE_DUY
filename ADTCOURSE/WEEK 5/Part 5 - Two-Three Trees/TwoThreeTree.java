public class TwoThreeTree {
    public Node root;

    public TwoThreeTree() {
        root = new Node(18, 0, -1, -1, null, null, null);
    }

    private Node insertionHelp(Node currNode, int key, int val) {
        Node returnVal;
        if (currNode == null) {
            return new Node(val, key, -1, -1, null, null, null);
        }
        if (currNode.isLeaf()) { // At leaf, then insert
            return currNode.add(new Node(val, key, -1, -1, null, null, null));
        }

        // Add to internal node
        if (key < currNode.getLeftKey()) {  // Insert left 
            returnVal = insertionHelp(currNode.getCenterChild(), key, val);
            if (returnVal == currNode.getLeftChild()) {
                return currNode;
            } else {
                return currNode.add(returnVal);
            }
        } else if (currNode.getRightKey() == -1 || key < currNode.getRightKey()) {
            returnVal = insertionHelp(currNode.getCenterChild(), key, val);
            if (returnVal == currNode.getCenterChild()) {
                return currNode;
            } else {
                return currNode.add(returnVal);
            }
        } else {
            returnVal = insertionHelp(currNode.getRightChild(), key, val);
            if (returnVal == currNode.getRightChild()) { return currNode; }
            else {
                return currNode.add(returnVal);
            }
        }
    }

    public void display() {
        helpDisplay(root, 0);
    }
    private void helpDisplay(Node rt, int space) {
        if (rt != null) {
            System.out.println("Okay");
            String formatting = "";
            for (int i = 0; i < space; i ++) {
                formatting += " ";
            }
            System.out.println(formatting + rt.getLeftKey() + " : " + rt.getLeftVal() + " | " + rt.getRightKey() + " : " + rt.getRightVal());
            space += 3;
            helpDisplay(rt.getLeftChild(), space);
            helpDisplay(rt.getCenterChild(), space);
            helpDisplay(rt.getRightChild(), space);
        }
    }

    public static void main(String[] args) {
        TwoThreeTree ttTree = new TwoThreeTree();
        ttTree.insertionHelp(ttTree.root, 18, 0);
        ttTree.insertionHelp(ttTree.root, 32, 0);
        ttTree.insertionHelp(ttTree.root, 32, 0);
        ttTree.insertionHelp(ttTree.root, 12, 0);

        ttTree.display();
    }
}
