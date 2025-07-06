public class GraphL implements GraphInterface {

    private class Edge {
        int vertex;
        int weight;
        Edge prev;
        Edge next;
        public Edge(int v, int w, Edge p, Edge n) {
            vertex = v;
            weight = w;
            prev = p;
            next = n;
        }
    }
    private Object[] nodeArray;
    private Edge[] nodeEdges;
    private int numEdge;
    // Initialize graph with a number of vertices
    public void init (int n) {
        nodeArray = new Object[n];
        nodeEdges = new Edge[n];
        for (int i = 0; i < n; i++) {
            nodeEdges[i] = new Edge(-1, -1, null, null);
        }
        numEdge = 0;
    }

    // Return the number of vertices
    public int nodeCount() { return nodeArray.length; }

    // Return the number of edges
    public int edgeCount() { return numEdge; }

    // Get the value of the node with index i
    public Object getValue(int i) { return nodeArray[i]; }

    // Set the value of node with index i
    public void setValue(int i, Object val) {
        nodeArray[i] = val;
    }

    // Adds a new edge from node v to node w with weight wgt
    public void addEdge(int v, int w, int wgt) {
        if (wgt == 0) { return; }
        Edge curr = find(v, w);
        if (curr.next != null && curr.next.vertex == w) {
            curr.next.weight = wgt;
        } else {
            curr.next = new Edge(w, wgt, curr, curr.next);
            numEdge ++;
            if (curr.next.next != null) {
                curr.next.next.prev = curr.next;
            }
        }
    }

    // Get the weight value for the edge from node v to w
    public int weight(int w, int v) {
        Edge curr = find(v, w);
        if (curr.next == null || curr.next.vertex != w) { return 0; }
        else {
            return curr.next.weight;
        }
    }
    // Remove an edge from a graph
    public void removeEdge(int v, int w) {
        Edge curr = find(v, w);
        if ((curr.next == null) || curr.next.vertex != w) { return; }
        else {
            curr.next = curr.next.next;
            if (curr.next != null) { curr.next.prev = curr; }
        }
        numEdge --;
    }

    // Returns true if the graph has the edge from node v to w
    public boolean hasEdge(int v, int w){
        return weight(v, w) != 0;
    }

    // Returns an array containing the indices of node v's neighbor
    public int[] neighbors(int v) {
        int count = 0;
        Edge curr;
        for (curr = nodeEdges[v].next; curr != null; curr = curr.next) {
            count ++;
        }
        int[] temp = new int[count];
        for (curr = nodeEdges[v].next; curr != null; curr = curr.next) {
            temp[count++] = curr.vertex;
        }
        return temp;
    }

    // Returning the edge before w
    private Edge find(int v, int w) {
        Edge curr = nodeEdges[v];
        while (curr.next != null && curr.next.vertex < w) {
            curr = curr.next;
        }
        return curr;
    }
}
