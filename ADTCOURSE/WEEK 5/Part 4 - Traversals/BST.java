import java.util.ArrayList;
public class BST {
    
    private BSTNode root;

    public BSTNode add(int key, String value) {
        BSTNode newNode = new BSTNode(key, value, null, null);
        if (root == null) {
            root = newNode;
            return root;
        } else {
            return addHelper(root, newNode);
        }
    }

    public String read(int key) {
        return readHelper(root, key);
    }

    public BSTNode remove(int key) {
        return removeHelper(root, key);
    }

    public BSTNode addHelper(BSTNode currRoot, BSTNode addedNode) {
        if (currRoot == null) {
            return addedNode;
        } else {
            if (addedNode.key() > currRoot.key()) {
                currRoot.setRight(addHelper(currRoot.right(), addedNode));
            } else if (addedNode.key() <= currRoot.key()) {
                currRoot.setLeft(addHelper(currRoot.left(), addedNode));
            }
            return currRoot;
        }
    }

    public String readHelper(BSTNode currNode, int key) {
        if (currNode.key() == key) {
            return currNode.value();
        } else {
            if (currNode.key() > key) {
                return readHelper(currNode.left(), key);
            } else {
                return readHelper(currNode.right(), key);
            }
        }
    }

    public BSTNode removeHelper(BSTNode currNode, int key) {
        if (currNode == null) {
            return currNode;
        } 
        if (currNode.key() > key) {
            currNode.setLeft(removeHelper(currNode.left(), key));
        } else if (currNode.key() < key) {
            currNode.setRight(removeHelper(currNode.right(), key));
        } else {
            if (currNode.left() == null) {
                return currNode.right();
            } else if (currNode.right() == null) {
                return currNode.left();
            } else {
                BSTNode temp = getMax(currNode.left());
                currNode.setValue(temp.value());
                currNode.setKey(temp.key());
                currNode.setLeft(deleteMax(currNode.left()));
            }
        }
        return currNode;
    }

    private BSTNode getMax(BSTNode rt) {
        if (rt.right() == null) {
            return rt;
        } 
        return getMax(rt.right());
    }

    private BSTNode deleteMax(BSTNode rt) {
        if (rt.right() == null) return rt.left();
        rt.setRight(getMax(rt.right()));
        return rt;
    }

    public void display() {
        if (root == null) {
            System.out.println("[]");
        } else {
            traverseNode(root, 0);
        }
    }
    private void format(BSTNode node, int spacing) {
        String space = "";
        for (int i=0; i<spacing; i++) {
            space += " ";
        }
        System.out.println(space + "[ " + node.key() + " : " + node.value() + " ]");
    }
    private void traverseNode(BSTNode node, int space) {
        if (node != null) {
            format(node, space );
            space += 3;
            traverseNode(node.right(), space);
            traverseNode(node.left(), space);
        }
    }

    public void printPreOrderTraversal() {
        System.out.println(preOrderHelper(root));
    }
    private String preOrderHelper(BSTNode currNode) {
        String string = "";
        if (currNode != null) {
            string += currNode.value() + " ";
            string += preOrderHelper(currNode.left());
            string += preOrderHelper(currNode.right());
        }
        return string;
    }

    public void printInOrderTraversal() {
        System.out.println(inOrderHelper(root));
    }
    private String inOrderHelper(BSTNode currNode) {
        String string = "";
        if (currNode != null) {
            string += inOrderHelper(currNode.left());
            string += currNode.value() + " ";
            string += inOrderHelper(currNode.right());
        }
        return string;
    } 

    public void printPostOrderTraversal() {
        System.out.println(postOrderHelper(root));
    }
    private String postOrderHelper(BSTNode currNode) {
        String string = "";
        if (currNode != null) {
            string += postOrderHelper(currNode.left());
            string += postOrderHelper(currNode.right());
            string += currNode.value() + " ";

        }
        return string;
    } 

    public void printLevelOrderTraversal() {
        ArrayList<BSTNode> arr = new ArrayList<>();
        if (root != null) {
            arr.add(root);
            while (!arr.isEmpty()) {
                BSTNode frontNode = arr.removeFirst();
                System.out.print(frontNode.value() + " ");
                levelOrderTraversalHelper(frontNode, arr);
            }
        }
    }

    private void levelOrderTraversalHelper(BSTNode rootNode, ArrayList<BSTNode> arr) {
        if (rootNode != null) {
            if (rootNode.left() != null) {
                arr.add(rootNode.left());
            }
            if (rootNode.right() != null) {
                arr.add(rootNode.right());
            }
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.add(37, "A");
        tree.add(24, "B");
        tree.add(7, "S");
        tree.add(32, "X");
        tree.add(2, "E");
        tree.add(42, "M");
        tree.add(42, "W");
        tree.add(40, "T");
        tree.add(120, "P");
        tree.display();
        System.out.println("---------------");
        tree.remove(37);
        tree.display();


        // ArrayList<Integer> intArr = new ArrayList<>();
        // intArr.add(Integer.valueOf(10));
        // intArr.add(Integer.valueOf(20));
        // intArr.add(Integer.valueOf(30));
        // intArr.add(Integer.valueOf(40));
        // while (!intArr.isEmpty()) {
        //     System.out.println(intArr.toString());
        //     intArr.removeFirst();
        // }
    }
}
