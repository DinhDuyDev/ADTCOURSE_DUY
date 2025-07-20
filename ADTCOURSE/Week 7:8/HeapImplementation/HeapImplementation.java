import java.util.ArrayList;
import java.util.List;

public class HeapImplementation {
    private class Node {
        Integer priority;
        String value;
        public Node(int p, String v) {
            this.priority = p;
            this.value = v;
        }

        public int compareTo(Node other) {
            return priority.compareTo(other.priority);
        }

        public String toString() {
            return "[ Priority: " + priority + " Value: " + value + " ]";
        }
    }

    List<Node> nodeList = new ArrayList<Node>();
    Node root;

    public int parent(int index) {
        return (index - 1) / 2;
    }

    public void insert(Integer p, String v) {
        Node addedNode = new Node(p, v);
        if (root == null) {
            root = addedNode;
            nodeList.add(root);
            return;
        }
        
        nodeList.add(addedNode);
        int currentIndex = nodeList.size() - 1;
        heapifyUp(currentIndex);
    }

    public void heapifyUp(int index) {
        int parentIndex = this.parent(index);
        Node thisNode = nodeList.get(index);
        Node parentNode = nodeList.get(parentIndex);
        if (thisNode.compareTo(parentNode) < 0) {
            this.swap(thisNode, parentNode);
        }
        if (parentIndex != 0) {
            heapifyUp(parentIndex);
        }
    }

    public void removal(int index) {
        swapNode(index, nodeList.size()-1);
        nodeList.removeLast();
        heapifyDown(index);
    }

    private void swapNode(int a, int b) {
        Node temp = nodeList.get(a);
        nodeList.set(a, nodeList.get(b));
        nodeList.set(b, temp);
    }

    public void heapifyDown(int index) {
        if (isLeaf(index)) {
            return;
        }
        System.out.println("HasLeft: " + hasLeftChild(index));
        System.out.println("HasRight: " + hasRightChild(index));

        Node currNode = nodeList.get(index);
        Node leftChild = nodeList.get(leftChild(index));
        Node rightChild = nodeList.get(rightChild(index));
        Node dominantNode = currNode;
        if (leftChild.compareTo(rightChild) < 0 && leftChild.compareTo(currNode) < 0) {
            dominantNode = leftChild;
        } else if (rightChild.compareTo(leftChild) > 0 && rightChild.compareTo(currNode) < 0) {
            dominantNode = rightChild;
        }

        if (dominantNode != currNode) {
            swap(currNode, dominantNode);
            heapifyDown(nodeList.indexOf(dominantNode));
        }
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    private boolean hasLeftChild(int index) {
        return leftChild(index) < nodeList.size();
    }

    private boolean hasRightChild(int index) {
        return rightChild(index) < nodeList.size();
    }

    public boolean isLeaf(int index) {
        return (!hasLeftChild(index) && !hasRightChild(index));
    }

    private void swap(Node a, Node b) {
        int temp = a.priority;
        a.priority = b.priority;
        b.priority = temp;
    }
    
    public String toString() {
        String str = "";
        for (Node node : nodeList) {
            str += node.toString() + "\n";
        }
        return str;
    }

    public String printParentAndChildren(int priority) {
        int parentIndex = 0;
        for (Node n : nodeList) {
            if (n.priority == priority) {
                parentIndex = nodeList.indexOf(n);
            }
        }
        return nodeList.get(parentIndex) + ": " + nodeList.get(leftChild(parentIndex)) + " | " + nodeList.get(rightChild(parentIndex));
    }

    public static void main(String[] args) {
        HeapImplementation heap = new HeapImplementation();
        /*heap.insert(60, "PlaceHolder");
        heap.insert(85, "PlaceHolder");
        heap.insert(42, "PlaceHolder");
        heap.insert(73, "PlaceHolder");
        heap.insert(99, "PlaceHolder");
        heap.insert(6, "PlaceHolder");
        heap.insert(83, "PlaceHolder");
        heap.insert(48, "PlaceHolder");
        heap.insert(88, "PlaceHolder");
        heap.insert(57, "PlaceHolder");
        heap.insert(72, "PlaceHolder");*/
        heap.insert(0, "PlaceHolder");
        heap.insert(1, "PlaceHolder");
        heap.insert(2, "PlaceHolder");
        heap.insert(3, "PlaceHolder");
        heap.insert(4, "PlaceHolder");
        //heap.insert(5, "PlaceHolder");
        //heap.insert(73, "PlaceHolder");
        heap.removal(0);
        System.out.println(heap);
        System.out.println(heap.printParentAndChildren(3));
    }
}
