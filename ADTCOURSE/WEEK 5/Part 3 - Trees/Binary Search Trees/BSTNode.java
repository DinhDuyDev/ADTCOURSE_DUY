public class BSTNode {
    private int key;
    private int value;
    private BSTNode left;
    private BSTNode right;
    public BSTNode(int k, int v, BSTNode l, BSTNode r) {
        key = k;
        value = v;
        left = l;
        right = r;
    }
    public BSTNode() {
        left = right = null;
    }
    public int key() {
        return key;
    }
    public int value() {
        return value;
    }
    public BSTNode left() {
        return left;
    }
    public BSTNode right() {
        return right;
    }

    public void setLeft(BSTNode node) {
        left = node;
    }

    public void setRight(BSTNode node) {
        right = node;
    }
}