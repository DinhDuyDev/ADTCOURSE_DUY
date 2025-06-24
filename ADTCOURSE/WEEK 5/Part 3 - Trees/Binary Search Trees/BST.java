import java.util.ArrayList;
public class BST {
    
    private BSTNode root;

    public BSTNode add(int key, int value) {
        BSTNode newNode = new BSTNode(key, value, null, null);
        if (root == null) {
            root = newNode;
            return root;
        } else {
            return addHelper(root, newNode);
        }
    }

    public int read(int key) {
        return readHelper(root, key);
    }

    public int remove(int key) {
        ArrayList<BSTNode> arr = new ArrayList<>();
        int returnNum;
        returnNum = removeHelper(root, key, arr);
        while (!arr.isEmpty()) {
            BSTNode last = arr.removeLast();
            add(last.key(), last.value());
        }
        return returnNum;
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

    public int readHelper(BSTNode currNode, int key) {
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

    public int removeHelper(BSTNode currNode, int key, ArrayList<BSTNode> arr) {
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
        return -1;
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
    public static void main(String[] args) {
        BST tree = new BST();
        tree.add(37, 1);
        tree.add(24, 1);
        tree.add(7, 1);
        tree.add(2, 1);
        tree.add(32, 1);
        tree.add(42, 1);
        tree.add(42, 1);
        tree.add(40, 1);
        tree.add(120, 1);
        tree.remove(37);
        tree.display();
    }
}