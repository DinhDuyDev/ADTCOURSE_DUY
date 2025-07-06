import java.util.List;
import java.util.ArrayList;
public class DFSTree {
    private class Node {
        Integer vertex;
        List<Node> children;
        private Node(Integer v) {
            vertex = v;
            children = new ArrayList<>();
        }
    }
    Node root;
    
    public void add(int vertex, int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            addHelp(vertex, value, root);
        }
    }
    private void addHelp(int vertex, int value, Node start) {
        if (start.vertex != vertex && !start.children.isEmpty()) {
            for (Node n : start.children) {
                addHelp(vertex, value, n);
            }
        } else {
            start.children.add(new Node(value));
        }
    }

    public void printTree() {
        printTreeHelp(root, 0);
    }
    private void printTreeHelp(Node rt, int spaces) {
        String pre = "";
        for (int i = 0; i < spaces; i ++) {
            pre += " ";
        }
        if (rt != null) {
            System.out.println("[" + rt.vertex + "]: " + rt.children);
            for (Node n : rt.children) {
                printTreeHelp(n, spaces + 3);
            }
        }
    }
}
