import java.util.*;

public class BST {
    private BSTNode root;

    /**
     * Displays an ASCII-art sort of representation of this tree (image-like text).
     */
    public void printTree() {
        int maxLevel = maxLevel(root);
        List<BSTNode> rootList = new ArrayList<BSTNode>();
        rootList.add(root);
        printNodeInternal(rootList, 1, maxLevel);
    }

    /**
     * Adds a new key, value pair to the binary search tree.
     * If the key is a duplicate, returns false, otherwise returns true.
     * @param key the key that should be used to determine placement in the tree
     * @param val the value that should be associated with the key
     * @return boolean, whether the key/value pair was added successfully or not
     */
    public boolean add(String key, int val){
        BSTNode newNode = new BSTNode(key, val);
        if (root == null) {
            root = newNode;
            return true;
        } else {
            return addHelper(root, newNode);
        }

    }

    /**
     * A method for searching the tree for a key and returning the associated value
     * @param key the key that is associated with the value you want
     * @return Integer the value associatd with the given key
     */
    public Integer get(String key) {
        return getHelper(root, key);
        
    }

    /**
     * A recursive helper method for retrieving a value from the tree
     *  based on the key
     * @param subRoot the BSTNode that is the root of the current subtree
     * @param key the key that you are looking for
     * @return Integer, the value associated with the given key or null
     *  if the key isn't in the tree
     */
    private Integer getHelper(BSTNode subRoot, String key) {
        // Implement me!
        if (subRoot.key() == key) {
            return subRoot.value();
        } else {
            if (subRoot.key().compareTo(key) < 0) {
                return getHelper(subRoot.right(), key);
            } else if (subRoot.key().compareTo(key) > 0){
                return getHelper(subRoot.left(), key);
            }
        }
        return null;
    }

    /**
     * A recursive helper method for adding a node to the tree
     * Assumes that subRoot is not null
     * @param subRoot the root of current subtree
     * @param newNode the node to add
     * @return a boolean indicating whether the node was added successfully or not
     */
    private boolean addHelper(BSTNode subRoot, BSTNode newNode) {
        //Implement me!
        if (subRoot.key() == newNode.key()) {
            return false;
        } else {
            if (subRoot.key().compareTo(newNode.key()) < 0) {
                if (subRoot.right() != null) {
                    addHelper(subRoot.right(), newNode);
                } else {
                    subRoot.setRight(newNode);
                    return true;
                }
            } else {
                if (subRoot.left() != null) {
                    addHelper(subRoot.left(), newNode);
                } else {
                    subRoot.setLeft(newNode);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Creates a small BST manually so that it can be displayed 
     * before add is implemented
     */
    public void test() {
        root = new BSTNode("K", 33);
        root.setLeft(new BSTNode("F", 3));
        root.setRight(new BSTNode("S", 50));
        root.left().setLeft(new BSTNode("A", 1));
        root.right().setLeft(new BSTNode("L", 4));
    }


    public static void main(String[] args) {
        BST tree = new BST();
        System.out.println("------------");
        System.out.println(tree.add("A", 10));
        System.out.println(tree.add("B", 10));
        System.out.println(tree.add("C", 10));
        System.out.println(tree.add("D", 10));
        //System.out.println(tree.add("E", 10));
        //System.out.println(tree.add("F", 10));
        //System.out.println(tree.add("G", 10));
        //System.out.println(tree.add("H", 10));
        tree.printTree();
    }

    /****
     * You can ignore all code below this point!  
     * This code takes care of printing.
     * 
     * Lightly modified from user post on stack overflow:
     * http://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
     * and code provided by Anna Rafferty.
     */
    private void printNodeInternal(List<BSTNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || areAllElementsNull(nodes)) {
            return;
        }
        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;
    
        printWhitespaces(firstSpaces);
    
        List<BSTNode> newNodes = new ArrayList<BSTNode>();
        for (BSTNode node : nodes) {
            if (node != null) {
                System.out.print(node.key());
                newNodes.add(node.left());
                newNodes.add(node.right());
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }
    
            printWhitespaces(betweenSpaces);
        }
        System.out.println("");
    
        for (int i = 1; i <= edgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(edgeLines + edgeLines + i + 1);
                    continue;
                }
    
                if (nodes.get(j).left() != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);
    
                printWhitespaces(i + i - 1);
    
                if (nodes.get(j).right() != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);
    
                printWhitespaces(edgeLines + edgeLines - i);
            }
    
            System.out.println("");
        }
    
        printNodeInternal(newNodes, level + 1, maxLevel);
    }
    
    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }
    
    private static int maxLevel(BSTNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(maxLevel(node.left()), maxLevel(node.right())) + 1;
    }
    
    private static boolean areAllElementsNull(List<BSTNode> list) {
        for (BSTNode object : list) {
            if (object != null)
                return false;
        }
        return true;
    }
}
