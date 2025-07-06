import java.util.List;
import java.util.ArrayList;

/**
 * The goal of this lab is to implement an unweighted graph and contrast
 * an adjacency matrix and adjacency list implementation.
 * Some of the implementation is provided for you - read the lab instructions
 * for how to proceed.
 *
 */
public class AdjacencyMatrixGraphImplementation implements WeightedGraph {
    //Instance variables - Make the comment below more specific about how
    //exactly adjacencyMatrix is organized.
    private List<List<Double>> adjacencyMatrix;//Adjacency matrix. Store edges here.
    private boolean directed;
    
    
    /**
     * Constructs an unweighted graph that is directed if
     * directed = true and undirected otherwise. 
     * @param directed
     */
    public AdjacencyMatrixGraphImplementation(boolean directed) {
        adjacencyMatrix = new ArrayList<List<Double>>();
        this.directed = directed;
    }

    /** Adds a new vertex.
     * @return the ID of the added vertex.
     */
    @Override
    public int addVertex() {
        List<Double> newRow = new ArrayList<Double>();
        for(List<Double> curList : adjacencyMatrix) {
            //Add one more false to each list for this new vertex
            curList.add(0.0);
            newRow.add(0.0);//add a false for the vertex represented by this list.
        }
        //Add one extra false for no self looping edge.
        newRow.add(0.0);

        //Add the new row to the matrix
        adjacencyMatrix.add(newRow);
        return adjacencyMatrix.size()-1;
    }


    /** Checks whether an edge exists between two vertices.
     * In an undirected graph, this returns the same as hasEdge(end, begin).
     * @return true if there is an edge from begin to end.
     */
    @Override
    public boolean hasEdge(int begin, int end) {
        // TODO Auto-generated method stub
        if (directed) {
            List<Double> row = adjacencyMatrix.get(begin);
            if (row.get(end) != 0.0) {
                return true;
            }
        } else {
            List<Double> first = adjacencyMatrix.get(begin);
            List<Double> second = adjacencyMatrix.get(end);
            if ((first.get(end) != 0.0) && (second.get(begin) != 0.0)) {
                return true;
            }
        }
        return false;
    }


    /** 
     * Returns the out-degree of the specified vertex. The
     * out-degree is the number of outgoing edges.
     */
    @Override
    public int getDegree(int v) {
        // TODO: Implement me!
        int degrees = 0;
        List<Double> vertex = adjacencyMatrix.get(v);
        for (Double curr : vertex) {
            if (curr != 0.0) {
                degrees ++;
            }
        }
        return degrees;
    }



    /** 
     *Returns the in-degree of the specified vertex. The
     * in-degree is the number of incoming edges.
     */
    @Override
    public int getInDegree(int v) {
        int degrees = 0;
        for (List<Double> row : adjacencyMatrix) {
            if (row == adjacencyMatrix.get(v)) {
                continue;
            }
            for (int i = 0; i < row.size(); i ++) {
                if ((row.get(i) != 0.0) && (i == v)) {
                    degrees ++;
                }
            }
        }
        return degrees;
    }


    /** Returns an iterable object that allows iteration over the neighbors of
     * the specified vertex.  In particular, the vertex u is included in the
     * sequence if and only if there is an edge from v to u in the graph.
     */
    @Override
    public Iterable<Integer> getNeighbors(int v) {
        if(v < 0 || v >= adjacencyMatrix.size()) {
            throw new IndexOutOfBoundsException();
        }
        List<Integer> neighbors = new ArrayList<Integer>();
        //Get the row in the matrix that corresponds to the outgoing edges
        List<Double> row = adjacencyMatrix.get(v);
        for(int i = 0; i < row.size(); i++) {
            if(row.get(i) != 0.0) {//column index is a neighboring vertex
                neighbors.add(i);
            }
        }
        return neighbors;
    }



    /** Returns the number of vertices in the graph. */
    @Override
    public int numVerts() {
        return adjacencyMatrix.size();
    }



    /** Returns the number of edges in the graph.
     * The result does *not* double-count edges in undirected graphs.
     */
    @Override
    public int numEdges() {
        int num = 0;
        for (List<Double> row : adjacencyMatrix) {
            for (Double edge : row) {
                if (edge != 0.0) {
                    num ++;
                }
            }
        }
        if (!directed) {
            num /= 2;
        }
        return num;
    }



    /** Returns true if the graph is directed. */
    @Override
    public boolean isDirected() {
        return directed;
    }


    /** Returns true if there are no vertices in the graph. */
    @Override
    public boolean isEmpty() {
        return adjacencyMatrix.isEmpty();
    }


    /** Removes all vertices and edges from the graph. */
    @Override
    public void clear() {
        adjacencyMatrix = new ArrayList<List<Double>>();
    }


    /** Adds an unweighted edge between two vertices.
     * In an undirected graph, this has the same effect as addEdge(end, begin).
     * @return false if the edge was already in the graph.
     * @throws IndexOutOfBoundsException if either vertex ID is out of bounds.
     */
    @Override
    public boolean addEdge(int begin, int end, double weight) {
        // TODO Auto-generated method stub
        if (directed) {
            List<Double> row = adjacencyMatrix.get(begin);
            if (row.get(end) == 0.0) {
                row.set(end, weight);
                return true;
            }
        } else {
            List<Double> first = adjacencyMatrix.get(begin);
            List<Double> second = adjacencyMatrix.get(end);
            if ((first.get(end) == 0.0) && (second.get(begin) == 0.0)) {
                first.set(end, weight);
                second.set(begin, weight);
                return true;
            }
        }
        return false;
    }
    
    /** Sets the weight of an edge already in the graph.
     * @return false if the edge is not in the graph.
     */
    public boolean setWeight(int begin, int end, double weight) {
        if (directed) {
            List<Double> row = adjacencyMatrix.get(begin);
            if (row.get(end) != 0.0) {
                row.set(end, weight);
                return true;
            }
        } else {
            List<Double> first = adjacencyMatrix.get(begin);
            List<Double> second = adjacencyMatrix.get(begin);
            if ((first.get(end) != 0.0) && (second.get(begin) != 0.0)) {
                first.set(end, weight);
                second.set(begin, weight);
                return true;
            }
        }
        return false;
    }
    
    /** Gets the weight of the edge between two vertices.
     * In an undirected graph, this returns the same as getWeight(end, begin).
     * @return the weight of the edge from begin to end, or the sentinel value
     *   if no such edge exists.
     */
    public double getWeight(int begin, int end) {
        if (directed) {
            List<Double> row = adjacencyMatrix.get(begin);
            return row.get(end);
        } else {
            List<Double> second = adjacencyMatrix.get(begin);
            return second.get(begin);
        }
    }

    /** Returns the "sentinel" weight value for edges not in the graph. */
    public double missingEdgeSentinel() {
        return 0.0;
    }


    public static void main(String[] args) {
        WeightedGraph graphM = new AdjacencyMatrixGraphImplementation(true);
        graphM.addVertex();
        graphM.addVertex();
        graphM.addVertex();
        graphM.addVertex();

        graphM.addEdge(0, 3, 4);
        graphM.addEdge(1, 2, 7);
        graphM.addEdge(1, 3, 10);
        graphM.addEdge(3, 2, 0.5);

        //System.out.println(graphM.getInDegree(2));
        //System.out.println(graphM.numEdges());
        //System.out.println(graphM.getWeight(3, 3));
        System.out.println(graphM.setWeight(3, 2, 19));
        System.out.println(graphM.getWeight(3, 2));
        System.out.println(graphM.getNeighbors(3));
    }

    /**
     * Unit tests for the graph implementation.
     * This tests many of the things you might want to test, but not all of them.
     * If you have extra time, brainstorm some more tests and add them.
     * @param args
     */
    /*public static void main(String[] args) {
        //Tests undirected - testing directed is left as an exercise
        UnweightedGraph g = new AdjacencyMatrixGraphImplementation(false);
        boolean passedAllTests = true;
        //First, some tests to make sure a newly created graph is really empty. You could
        //add more tests here if you wanted.
        if(!g.isEmpty()) {
            System.err.println("Newly created graph is not empty");
            passedAllTests = false;
        }
        if(g.numVerts() != 0) {
            System.err.println("Expected 0 vertices for a new graph, found: " + g.numVerts());
            passedAllTests = false;
        }
        //Now add some vertices and edges and test how things went.
        int numVertices = 18;
        for(int i = 0; i < numVertices; i++) {
            int newVertex = g.addVertex();
            if(g.numVerts() != i+1) {
                System.err.println("Added " + (i+1) + " vertices, but graph says it has " + g.numVerts() + " vertices.");
                passedAllTests = false;
            }
            if(newVertex != i) {
                System.err.println("Added vertex that should have index " + i + " but had index " + newVertex + ".");
                passedAllTests = false;
            }
        }

        //Now let's add edges so that there's an edge from each even numbered vertex to every other
        //vertex, except the final vertex (so that one shouldn't have any edges).
        //We also don't include self loops (you might think through whether your
        //method would be correct with self loops.)
        for(int i = 0; i < numVertices-1; i+=2) {
            for(int j = 0; j < numVertices-1; j++) {
                if(i != j) {
                    g.addEdge(i,j);
                    if(!g.hasEdge(i,j)) {
                        System.err.println("Added edge (" + i + ", " + j + "), but hasEdge returned false.");
                    }
                    if(!g.hasEdge(j,i)) {//Undirected graph, so adding (i,j) should get us (j,i) too
                        System.err.println("Added edge (" + i + ", " + j + "), but hasEdge for opposite order returned false.");
                    }
                }
            }
        }
        //Go through the vertices and make sure edges, in degree, out degree, and neighbors are correct
        for(int i = 0; i < numVertices; i++) {
            int expectedNumNeighbors = 9;
            if(i % 2 == 0) {
                expectedNumNeighbors = 16;
            } else if(i == 17) {
                expectedNumNeighbors = 0;
            }
            //Checking that the neighbor iterator is correct
            int numNeighborsFound = 0;
            Iterable<Integer> neighbors = g.getNeighbors(i);
            for(int v : neighbors) {
                numNeighborsFound++;
                if((i % 2 == 1 && v % 2 == 1) || i == 17 || v == 17) {
                    //Shouldn't have an edge between two odd vertices or any edges involving final vertex!
                    System.err.println("Found an unexpected edge between " + i + " and " + v);
                    passedAllTests = false;
                }   
            }
            if(numNeighborsFound != expectedNumNeighbors) {
                System.err.println("vertex: " + i + "; expected " + expectedNumNeighbors + " neighbors, but found " + numNeighborsFound);
                passedAllTests = false;
            }
            //Now check in and out degree. Since we're not directed, they should both equal expected num neighbors.
            if(g.getDegree(i) != expectedNumNeighbors) {
                System.err.println("Expected degree " + expectedNumNeighbors + " but found degree " + g.getDegree(i));
                passedAllTests = false;
            }
        }

        //Check that calling with negative or too large numbers results in IndexOutOfBoundsException
        try {
            g.getDegree(150);
            System.err.println("Called getDegree with too large of a vertex and no exception was thrown.");
            passedAllTests = false;
        } catch(IndexOutOfBoundsException e) {
            ;
        }

        try {
            g.getDegree(-5);
            System.err.println("Called getDegree with too small of a vertex and no exception was thrown.");
            passedAllTests = false;
        } catch(IndexOutOfBoundsException e) {
            ;
        }
        try {
            g.getNeighbors(150);
            System.err.println("Called getNeighbors with too large of a vertex and no exception was thrown.");
            passedAllTests = false;
        } catch(IndexOutOfBoundsException e) {
            ;
        }
        try {
            g.getNeighbors(-5);
            System.err.println("Called getNeighbors with too small of a vertex and no exception was thrown.");
            passedAllTests = false;
        } catch(IndexOutOfBoundsException e) {
            ;
        }
        System.out.println("All tests passed: " + passedAllTests);


    }*/


}
