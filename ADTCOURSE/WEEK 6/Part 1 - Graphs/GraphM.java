public class GraphM implements GraphInterface {
    private int[][] matrix;
    private Object[] nodeValues;
    private int numEdge;

    // Initializes the graph with a number of edges
    public void init(int n) {
        matrix = new int[n][n];
        nodeValues = new Object[n];
        numEdge = 0;
    }

    // Returns the number of edges
    public int nodeCount() {
        return nodeValues.length;
    }

    // Return the current number of edges
    public int edgeCount() {
        return numEdge;
    }

    // Get the value of the node with index i
    public Object getValue(int i) {
        return nodeValues[i];
    }

    // Set the value of the node with index i
    public void setValue(int i, Object val) {
        nodeValues[i] = val;
    }

    // Adds a new edge from node v to node w with weight wgt
    public void addEdge(int v, int w, int wgt) {
        if (wgt == 0) {
            return;
        } 
        if (matrix[v][w] == 0) {
            numEdge ++;
        }
        matrix[v][w] = wgt;
    }

    // Get the weight value of the edge from the graph
    public int weight(int v, int w) {
        return matrix[v][w];
    }
    // Removes the edge from the graph
    public void removeEdge(int v, int w) {
        if (matrix[v][w] != 0) {
            matrix[v][w] = 0;
            numEdge --;
        }
    }

    // Returns true if the graph has the edge
    public boolean hasEdge(int v, int w) {
        return (matrix[v][w] != 0);
    }

    // Returns an array containing all the indices of node v's neighbors
    public int[] neighbors(int v) {
        int i;
        int count = 0;
        int[] temp;
        for (i = 0; i < nodeValues.length; i ++) { 
            if (matrix[v][i] != 0) { count ++; } // Getting the actual number of vertices in the graph
        }
        temp = new int[count]; // number of neighbors possible
        for (i = 0, count = 0; i < nodeValues.length; i ++) {
            if (matrix[v][i] != 0) {temp[count++] = i;}
        }
        return temp;
    }
}
