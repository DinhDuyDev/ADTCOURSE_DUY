import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 * The goal of this lab is to implement an unweighted graph and contrast
 * an adjacency matrix and adjacency list implementation.
 * Some of the implementation is provided for you - read the lab instructions
 * for how to proceed.
 *
 */
public class AdjacencyListGraphImplementation implements WeightedGraph {
    private class Edge {
        int vertex;
        double weight;
        private Edge(int v, double w) {
            vertex = v;
            weight = w;
        }
    }
    //Instance variables. Make the comment below more specific about how
    //exactly adjacencyLists is organized.
    private List<List<Edge>> adjacencyLists;//List of adjacency lists. Store edges here.
    private boolean directed;

    /**
     * Constructs an unweighted graph that is directed if
     * directed = true and undirected otherwise.
     * @param directed
     */
    public AdjacencyListGraphImplementation(boolean directed) {
        adjacencyLists = new ArrayList<List<Edge>>();
        this.directed = directed;
    }

    /** Adds a new vertex.
     * @return the ID of the added vertex.
     */
    @Override
    public int addVertex() {
        adjacencyLists.add(new LinkedList<Edge>());
        return adjacencyLists.size() - 1;
    }


    /** Checks whether an edge exists between two vertices.
     * In an undirected graph, this returns the same as hasEdge(end, begin).
     * @return true if there is an edge from begin to end.
     */
    @Override
    public boolean hasEdge(int begin, int end) {
        // TODO Auto-generated method stub
        if (directed) {
            List<Edge> row = adjacencyLists.get(begin);
            return row.contains(end);
        } else {
            List<Edge> first = adjacencyLists.get(begin);
            List<Edge> second = adjacencyLists.get(end);
            if (first.contains(end) && second.contains(begin)) {
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
        List<Edge> row = adjacencyLists.get(v);
        return row.size();
    }



    /** 
     *Returns the in-degree of the specified vertex. The
     * in-degree is the number of incoming edges.
     */
    @Override
    public int getInDegree(int v) {
        int degrees = 0;
        for (List<Edge> row : adjacencyLists) {
            for (Edge i : row) {
                if (i.vertex == v) {
                    degrees ++;
                }
            }
        }
        return degrees;
    }



    /** Returns an iterable object that allows iteration over the neighbors of
     * the specified vertex.  In particular, the vertex u is included in the
     * sequence if and only if there is an edge from v to u in the graph.
     * Note: The implementation below is not the best possible implementation.
     * It allows the client to change the graph structure. One extension of the
     * lab is to modify this implementation to not allow the client to change the
     * graph structure, without changing the time complexity of this method.
     */
    @Override
    public Iterable<Integer> getNeighbors(int v) {
        if(v < 0 || v >= adjacencyLists.size()) {
            throw new IndexOutOfBoundsException();
        }
        List<Integer> list = new LinkedList<>();
        for (Edge e : adjacencyLists.get(v)) {
            list.add(e.vertex);
        }
        return list;
    }


    /** Returns the number of vertices in the graph. */
    @Override
    public int numVerts() {
        return adjacencyLists.size();
    }



    /** Returns the number of edges in the graph.
     * The result does *not* double-count edges in undirected graphs.
     */
    @Override
    public int numEdges() {
        int num = 0;
        for (List<Edge> row : adjacencyLists) {
            num += row.size();
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
        return adjacencyLists.isEmpty();
    }


    /** Removes all vertices and edges from the graph. */
    @Override
    public void clear() {
        adjacencyLists = new ArrayList<List<Edge>>();
    }


    /** Adds an unweighted edge between two vertices.
     * In an undirected graph, this has the same effect as addEdge(end, begin).
     * @return false if the edge was already in the graph.
     * @throws IndexOutOfBoundsException if either vertex ID is out of bounds.
     */
    @Override
    public boolean addEdge(int begin, int end, double weight) {
        // TODO Auto-generated method stub
        boolean containsEdge = false;
        if (directed) {
            List<Edge> row = adjacencyLists.get(begin);
            for (Edge e : row) {
                if (e.vertex == end) {
                    containsEdge = true;
                }
            }
            if (!containsEdge) {
                row.add(new Edge(end, weight));
                return true;
            }
        } else {
            List<Edge> first = adjacencyLists.get(begin);
            List<Edge> second = adjacencyLists.get(end);
            for (Edge e : first) {
                if (e.vertex == end) {
                    containsEdge = true;
                }
            }
            for (Edge e : second) {
                if (e.vertex == begin) {
                    containsEdge = true;
                }
            }
            if (!containsEdge) {
                first.add(new Edge(end, weight));
                second.add(new Edge(begin, weight));
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
            List<Edge> row = adjacencyLists.get(begin);
            for (Edge e : row) {
                if (e.vertex == end) {
                    e.weight = weight;
                    return true;
                }
            }
        } else {
            boolean containsEdge = false;
            List<Edge> first = adjacencyLists.get(begin);
            List<Edge> second = adjacencyLists.get(end);
            for (Edge e : first) {
                if (e.vertex == end) {
                    e.weight = weight;
                    containsEdge = true;
                }
            }
            for (Edge e : second) {
                if (e.vertex == begin) {
                    e.weight = weight;
                    containsEdge = true;
                }
            }
            if (containsEdge) {
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
        boolean containsEdge = false;
        List<Edge> row = adjacencyLists.get(begin);
        for (Edge e : row) {
            if (e.vertex == end) {
                return e.weight;
            }
        }
        return 0.0;
    }
    
    /** Returns the "sentinel" weight value for edges not in the graph. */
    public double missingEdgeSentinel() {
        return 0.0;
    }

    public static void main(String[] args) {
        WeightedGraph graphL = new AdjacencyListGraphImplementation(false);
        graphL.addVertex();
        graphL.addVertex();
        graphL.addVertex();
        graphL.addVertex();

        graphL.addEdge(0, 3, 4);
        graphL.addEdge(3, 2, 7);
        graphL.addEdge(1, 2, 10);
        graphL.addEdge(1, 3, 0.5);

        System.out.println(graphL.numEdges());
        System.out.println(graphL.getWeight(3, 2));
    }
    /**
     * Unit tests for the graph implementation.
     * This tests many of the things you might want to test, but not all of them.
     * If you have extra time, brainstorm some more tests and add them.
     * @param args
     */
    /*public static void main(String[] args) {
        //Tests undirected - testing directed is left as an exercise
        UnweightedGraph g = new AdjacencyListGraphImplementation(false);
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
