public class Node {
    private int nodeData;
    private Node nodeLink;

    public Node(int data) {
        this.nodeData = data;
    }

    public void setData(int data) {
        this.nodeData = data;
    }
    public int getData() {
        return nodeData;
    }

    public void setLink(Node nextNode) {
        nodeLink = nextNode;
    }

    public Node getLink() {
        return nodeLink;
    }
}
