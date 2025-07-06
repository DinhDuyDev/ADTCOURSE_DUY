import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class GraphL  {
    private List<List<Edge>> adjacencyList;
    private boolean directed;

    private class Edge {
        int vertex;
        boolean VISITED;
        private Edge(int v, boolean isVisit) {
            vertex = v;
        }
    }

    public GraphL(boolean d) {
        adjacencyList = new LinkedList<>();
        directed = d;
    }

    public int addVertex() {
        List<Edge> newRow = new ArrayList<>();
        adjacencyList.add(newRow);
        return adjacencyList.size() - 1;
    }

    public boolean addEdge(int begin, int end) {
        boolean containsEdge = false;
        if (directed) {
            List<Edge> row = adjacencyList.get(begin);
            for (Edge e : row) {
                if (e.vertex == end) {
                    containsEdge = true;
                    break;
                }
            }
            if (!containsEdge) {
                row.add(new Edge(end, false));
            }
        } else {
            List<Edge> first = adjacencyList.get(begin);
            List<Edge> second = adjacencyList.get(end);
            for (Edge e : first) {
                if (e.vertex == end) {
                    containsEdge = true;
                    break;
                }
            }
            if (!containsEdge) {
                first.add(new Edge(end, false));
                second.add(new Edge(begin, false));
            }
        }
        return false;
    }

    public boolean hasEdge(int begin, int end) {
        List<Edge> row = adjacencyList.get(begin);
        for (Edge e : row) {
            if (e.vertex == end) {
                return true;
            }
        }
        return false;
    }

    public int[] neighbors(int begin) {
        List<Edge> row = adjacencyList.get(begin);
        int[] neighbors = new int[row.size()];
        int count = 0;
        for (Edge e : row) {
            neighbors[count ++] = e.vertex;
        }
        return neighbors;
    }

    public boolean isDirected() {
        return directed;
    }

    public boolean isEmpty() {
        return adjacencyList.size() == 0;
    }

    public int numVerts() {
        return adjacencyList.size();
    }

    public int numEdges() {
        int numEdge = 0;
        for (List<Edge> row : adjacencyList) {
            numEdge += row.size();
        }
        if (!directed) {
            numEdge /= 2;
        }
        return numEdge;
    }

    public int getDegree(int v) {
        return adjacencyList.get(v).size();
    }

    public int getInDegree(int v) {
        int degrees = 0;
        for (int i = 0; i < adjacencyList.size(); i++) {
            if (i != v) {
                for (Edge e : adjacencyList.get(i)) {
                    if (e.vertex == v) {
                        degrees ++;
                    }
                }
            }
        }
        return degrees;
    }

    public Stack DFSTraversal() {
        Stack depthTree = new Stack();
        Stack recursionStack = new Stack();
        boolean[] visited = new boolean[adjacencyList.size()];
        for (int i = 0; i < adjacencyList.size(); i++) {
            visited[i] = false;
        }
        int traversals = 0;
        helpDFS(0, recursionStack, visited, depthTree, traversals);
        return depthTree;
    }

    private void helpDFS(int startVertex, Stack stack, boolean[] visited, Stack depthTree, int traversals) {
        visited[startVertex] = true;
        if (!visited[startVertex]) {
            depthTree.add(startVertex);
        }
        int[] neighbors = neighbors(startVertex);
        boolean allNeighborsVisited = true;
        for (int v : neighbors) {
            if (!visited[v]) {
                helpDFS(v, stack, visited, depthTree, traversals);
                allNeighborsVisited = false;
                stack.add(startVertex);
                break;
            }
        }
        if (allNeighborsVisited) {
            int top = stack.remove();
            helpDFS(top, stack, visited, depthTree, traversals);
            System.out.println(top);
        } 
    }

    public static void main(String[] args) {
        GraphL graph = new GraphL(false);
        Stack navigationTree = new Stack();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();

        graph.addEdge(0, 2);
        graph.addEdge(0, 5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(3, 2);
        graph.addEdge(3, 4);
        graph.addEdge(2, 4);
        graph.addEdge(4, 5);
        graph.addEdge(2, 5);

        navigationTree = graph.DFSTraversal();
        navigationTree.printStack();
    }
}