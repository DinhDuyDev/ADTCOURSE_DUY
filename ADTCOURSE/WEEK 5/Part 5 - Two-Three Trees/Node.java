public class Node {
    private int leftVal;
    private int rightVal;

    private int leftKey;
    private int rightKey;

    private int thirdVal;
    private int thirdKey;

    private Node left;
    private Node right;
    private Node center;

    public Node () {
        center = left = right = null;
    }

    public Node (int lv, int lk, int rv, int rk, Node l, Node r, Node c) {
        leftVal = lv;
        rightVal = rv;
        leftKey = lk;
        rightKey = rk;
        left = l;
        right = r;
        center = c;
    }

    public int getLeftVal() {
        return leftVal;
    }
    
    public int getRightVal() {
        return rightVal;
    }

    public int getLeftKey() {
        return leftKey;
    }

    public int getRightKey() {
        return rightKey;
    }

    public Node getLeftChild() {
        return left;
    }

    public Node getRightChild() {
        return right;
    }

    public Node getCenterChild() {
        return center;
    }

    public void setLeftChild(Node it) {
        left = it;
    }
    
    public void setRightChild(Node it) {
        right = it;
    }

    public void setCenterChild(Node it) {
        center = it;
    }

    public void setLeft(int k, int v) {
        leftKey = k;
        leftVal = v;
    }
    
    public void setRight(int k, int v) {
        rightKey = k;
        rightVal = v;
    }

    public boolean isLeaf() {
        return getCenterChild() == null && getLeftChild() == null && getRightChild() == null;
    }
}