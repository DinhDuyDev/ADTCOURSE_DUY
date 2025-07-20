import java.util.*;

public class Heap{
  Node root;
  public ArrayList<Node> nodes = new ArrayList<Node>();
  int numItems = 0;

  private class Node {
    Integer priority;
    String value;
    Node parent;


    public Node(int input, String val, Node parent){
      this.priority = input;
      this.value = val;
      this.parent = parent;
    }

    public int compareTo(Node b) {
        return this.priority.compareTo(b.priority);
    }

    public String toString() {
      return "Priority: " + priority + " Value: " + value +"\n";
    }
  }

  public void test() {
    root = new Node(15, "Hi", null);
    Node c1 = new Node(12, "Hi", root);
    Node c2 = new Node(13, "Hi", root);
    nodes.add(root);
    nodes.add(c1);
    nodes.add(c2);
    System.out.println(root.compareTo(c2));
    System.out.println(parent(1));

    System.out.println("-------------");
    System.out.println(c1);
    System.out.println(c2);
    this.swap(c1, c2);
    System.out.println(c1);
    System.err.println(c2);
  }

  public Node parent(int childPos) {
    Node parent = nodes.get((childPos - 1) / 2);
    return parent;
  }

  public int getParentFromPriority(int priority) {
    Node foundNode;
    for (Node n : nodes) {
      if (n.priority == priority) {
        return n.parent.priority;
      }
    }
    return 0;
  }

  public void insert(int priority, String value) {
    Node addedNode = new Node(priority, value, root);
    if (root == null) {
      root = addedNode;
      nodes.add(addedNode);
      return;
    }
    nodes.add(addedNode);
    Node parentNode = this.parent(nodes.indexOf(addedNode));
    addedNode.parent = parentNode;
    for (Node n : nodes) {
      heapifyUp(n);
    }
  }
  
  public void removeMax(int priority, String value) {
    Node removeNode;
    for (Node n : nodes) {
      if (n.priority == priority && n.value == value) {
        removeNode = n;
        nodes.remove(n);
        break;
      }
    }
  }

  private void swap(Node node1, Node node2) {
    int temp = node1.priority;
    node1.priority = node2.priority;
    node2.priority = temp;
  }

  private void heapifyUp(Node newNode) {
    if (newNode.parent != null) {
      if (newNode.compareTo(newNode.parent) > 0) {
        this.swap(newNode, newNode.parent);
        heapifyUp(newNode.parent);
      }
    }
  }

  private void heapifyDown(Node newNode) {
    if (newNode.parent != null) {
      if (newNode.compareTo(newNode.parent) < 0) {
        this.swap(newNode, newNode.parent);
        heapifyUp(newNode.parent);
      }
    }
  }

  public String toString() {
    String returnString = "";
    for(Node curNode : nodes) {
      returnString += curNode;
    }
    return returnString;
}



  public static void main(String[] args) {
    Heap heap = new Heap();
    /*heap.insert(99, "Placeholder");
    heap.insert(88, "Placeholder");
    heap.insert(83, "Placeholder");
    heap.insert(99, "Placeholder");
    heap.insert(99, "Placeholder");
    heap.insert(99, "Placeholder");
    heap.insert(99, "Placeholder");
    heap.insert(99, "Placeholder");
    heap.insert(99, "Placeholder");
    heap.insert(99, "Placeholder");
    heap.insert(99, "Placeholder");*/

    heap.insert(42, "Placeholder");
    heap.insert(85, "Placeholder");
    heap.insert(60, "Placeholder");
    heap.insert(99, "Placeholder");
    heap.insert(6, "Placeholder");
    heap.insert(73, "Placeholder");
    heap.insert(83, "Placeholder");
    heap.insert(48, "Placeholder");
    heap.insert(57, "Placeholder");
    heap.insert(88, "Placeholder");
    heap.insert(72, "Placeholder");
    System.out.println(heap.toString());

    System.out.println(heap.getParentFromPriority(48));
    System.out.println(heap.parent(8).priority);
  }
}