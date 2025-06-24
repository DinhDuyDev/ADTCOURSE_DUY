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

    public String remove(int key) {
        ArrayList<BSTNode> arr = new ArrayList<>();
        String returnVal;
        returnVal= removeHelper(root, key, arr);
        while (!arr.isEmpty()) {
            BSTNode last = arr.removeLast();
            add(last.key(), last.value());
        }
        return returnVal;
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

    public String removeHelper(BSTNode currNode, int key, ArrayList<BSTNode> arr) {
        if (currNode != null) {
            if (root.key() == key) {
                BSTNode rootNode = root;
                findAllDescendants(rootNode, arr);
                root = null;
                return rootNode.value();
            }
            else if (currNode.key() > key) {
                if (currNode.left().key() == key) {
                    BSTNode left = currNode.left();
                    findAllDescendants(left, arr);
                    currNode.setLeft(null);
                    return left.value();
                } else {
                    return removeHelper(currNode.left(), key, arr);
                }
            } else {
                if (currNode.right().key() == key) {
                    BSTNode right = currNode.right();
                    findAllDescendants(right, arr);
                    currNode.setRight(null);
                    return right.value();
                } else {
                    return removeHelper(currNode.right(), key, arr);
                }
            }
        }
        return "";
    }

    public void findAllDescendants(BSTNode node, ArrayList<BSTNode> arr) {
        if (node != null) {
            findAllDescendants(node.left(), arr);
            findAllDescendants(node.right(), arr);
        }
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
        tree.add(100, "A");
        tree.add(80, "B");
        tree.add(90, "S");
        tree.add(70, "X");
        tree.add(65, "E");
        tree.add(75, "M");
        tree.add(200, "W");
        tree.add(190, "T");
        tree.add(180, "P");
        tree.add(195, "N");
        tree.add(210, "C");
        tree.add(205, "H");
        tree.display();
        tree.printPreOrderTraversal();
        tree.printInOrderTraversal();
        tree.printPostOrderTraversal();
        tree.printLevelOrderTraversal();


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
