public class GraphM {
    private int[][] matrix;
    private Object[] nodeValues;
    private int numEdge;

     // Initialize graph with a number of vertices
    public void init (int n) {
        nodeValues = new Object[n];
        matrix = new int[n][n];
        numEdge = n;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                matrix[i][j] = 0;
            }
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

    // Adds a new edge from node v to node w with weight wgt
    public void addEdge(int v, int w, int wgt) {
        if (wgt == 0) { return; }
        else {
            if (matrix[v][w] == 0) {
                numEdge ++;
            }
            matrix[v][w] = wgt;
         }
    }

    // Get the weight value for the edge from node v to w
    public int weight(int v, int w) {
        return matrix[v][w];
    }
    // Remove an edge from a graph
    public void removeEdge(int v, int w) {
        matrix[v][w] = 0;
    }

    // Returns true if the graph has the edge from node v to w
    public boolean hasEdge(int v, int w) {
        if (matrix[v][w] != 0) {
            return true;
        } 
        return false;
    }

    // Returns an array containing the indices of node v's neighbor
    public int[] neighbors(int v) {
        int[] temp;
        int i;
        int count = 0;
        for (i = 0; i < matrix[v].length; i ++) {
            if (matrix[v][i] != 0) {
                count ++;
            }
        }
        temp = new int[count];
        count = 0;
        for (i = 0, count = 0; i < matrix[v].length; i++) {
            if (matrix[v][i] != 0) {
                temp[count++] = i;
            }
        }
        return temp;
    }
}
