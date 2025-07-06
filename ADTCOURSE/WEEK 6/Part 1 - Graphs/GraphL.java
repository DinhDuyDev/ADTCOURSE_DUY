public class GraphL implements GraphInterface {
    private class Edge { // Creates 
        int vertex, weight;
        Edge prev, next;
        private Edge(int v, int w, Edge p, Edge n) {
            vertex = v;
            weight = w;
            prev = p;
            next = n;
        }
    }
    private Edge[] nodeArray;
    private Object[] nodeValues;
    private int numEdge;

    // No real constructor
    public GraphL() {}

    // Initialize the graph with n vertices
    public void init(int n) {
        nodeArray = new Edge[n];
        nodeValues = new Object[n];
        numEdge = 0;

        for (int i = 0; i < nodeArray.length; i++) { // Initialize the heads of the edge arrays
            nodeArray[i] = new Edge(-1, -1, null, null);
        }
    }

    // Return the number of vertices
    public int nodeCount() {
        return nodeValues.length;
    }

    // Return the number of edges
    public int edgeCount() {
        return numEdge;
    }

    // Get the value of the node with index i
    public Object getValue(int i) {
        return nodeValues[i];
    }

    // Set the value of node with index i
    public void setValue(int i, Object val) {
        nodeValues[i] = val;
    }

    // Find the edge that exists before the value of w to append another edge to it 
    private Edge find (int v, int w) {
        Edge curr = nodeArray[v];
        while (curr.next == null && curr.next.vertex < w) {
            curr = curr.next;
        }
        return curr;
    }

    // Adds a new edge from node v to node w with weight wgt
    public void addEdge(int v, int w, int wgt) {
        if (wgt == 0) {return; }
        Edge curr = find(v, w);
        if ((curr.next != null) && (curr.next.vertex == w)) {
            curr.next.weight = wgt;
        } else {
            curr.next = new Edge(w, wgt, curr, curr.next);
            numEdge++;
            if (curr.next.next != null) {curr.next.next.prev = curr.next;}
        }
    }

    // Get the weight value for the edge from node v to w
    public int weight(int v, int w) {
        Edge curr = find(v, w);
        if (curr.next == null || curr.next.vertex != w) { return 0; }
        else {return curr.next.weight; }
    }
    // Remove the edge from the graph
    public void removeEdge(int v, int w) {
        Edge curr = find(v, w);
        if (curr.next == null || curr.next.vertex != w) { return; }
        else {
            curr.next = curr.next.next;
            if (curr.next != null) {curr.next.prev = curr;}
        }
        numEdge --;
    }

    // Returns true if the graph has the edge from node v to w
    public boolean hasEdge(int v, int w) {
        return weight(v, w) != 0;
    }

    // Returns an array containing the indices of node v's neighbor
    public int[] neighbors(int v) {
        int count = 0;
        Edge curr;
        for (curr = nodeArray[v].next; curr != null; curr = curr.next) {
            count ++;
        }
        int[] temp = new int[count];
        count = 0;
        for (curr = nodeArray[v].next; curr != null; curr = curr.next) {
            temp[count++] = curr.vertex;
        }
        return temp;
    }
}
