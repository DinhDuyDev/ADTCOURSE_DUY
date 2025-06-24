public class BSTNode {
    private int key;
    private String value;
    private BSTNode left;
    private BSTNode right;
    public BSTNode () {
        left = right = null;
    }
    public BSTNode (int k, String v, BSTNode l, BSTNode r) {
        key = k;
        value = v;
        left = l;
        right = r;
    }

    public int key() {
        return key;
    }
    public String value() {
        return value;
    }
    public BSTNode left() {
        return left;
    }
    public BSTNode right() {
        return right;
    }

    public void setLeft(BSTNode l) {
        left = l;
    }
    public void setRight(BSTNode r) {
        right = r;
    }
}