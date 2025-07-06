
/*
 * This ADT assumes the number of vertices for the graph is fixed upon creation, but that edges can be changed.
 * Vertices are indicated by an integer value, from v(0), v(1) to v(n-1)
 * Graph ADTs do not rely on Java features like generics, because it is the user's responsibility to manage it itself.
 */

public interface GraphInterface { // Graph class ADT

    // Initialize graph with a number of vertices
    public void init (int n);

    // Return the number of vertices
    public int nodeCount();

    // Return the number of edges
    public int edgeCount();

    // Get the value of the node with index i
    public Object getValue(int i);

    // Set the value of node with index i
    public void setValue(int i, Object val);

    // Adds a new edge from node v to node w with weight wght
    public void addEdge(int v, int w, int wgt);

    // Get the weight value for the edge from node v to w
    public int weight(int w, int v);
    // Remove an edge from a graph
    public void removeEdge(int v, int w);

    // Returns true if the graph has the edge from node v to w
    public boolean hasEdge(int v, int w);

    // Returns an array containing the indices of node v's neighbor
    public int[] neighbors(int v);
}
