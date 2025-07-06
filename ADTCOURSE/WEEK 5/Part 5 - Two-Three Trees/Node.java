public class Node {
    private int leftVal;
    private int rightVal;

    private int leftKey;
    private int rightKey;

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

    public Node add(Node it) {
        if (rightKey == -1) { // Only one key, then add here
            if (leftKey < it.getLeftKey()) {
                rightKey = it.getLeftKey(); rightVal = it.getLeftVal(); // if the left key of this object is smaller than the left key of the insertion of object, then the 
                center = it.getLeftChild(); right = it.getCenterChild(); // Center child is set to the left child of the thing 
            } else {
                rightKey = leftKey; rightVal = leftVal; right = center;
                leftKey = it.getLeftKey(); leftVal = it.getLeftVal();
                center = it.getCenterChild();
            }
            return this;
        } else if (leftKey > it.getLeftKey()) { // Add to the left of the node
            Node N1 = new Node(leftVal, leftKey, -1, -1, it, this, null);
            it.setCenterChild(new Node(rightVal, rightKey, -1, -1, this, it.getCenterChild(), null));
            it.setLeftChild(this);
            rightKey = -1; rightVal = -1; right = null;
            return it;
        } else { // Add right
            Node N1 = new Node(rightVal, rightKey, -1, -1, this, it, null);
            it.setLeftChild(right);
            right = null; rightKey = -1; rightVal = -1;
            return N1;
        }
    }
}