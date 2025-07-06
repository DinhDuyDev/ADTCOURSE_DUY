import java.util.*;

class Main {

  /**
   * Conducts a breadth first traversal of the pr
   * @param inputGraph the graph that should be traversed
   * @param originVertex an integer representing the number of the vertex that the traversal should start at
   * @return a queue with integers showing the order that the vertices were traversed
   */
  public static Queue<Integer> getBreadthFirstTraversal(UnweightedGraph inputGraph, Integer originVertex) {
    Queue<Integer> traversalOrder = new LinkedList<Integer>();
    Queue<Integer> vertexQueue = new LinkedList<Integer>();
    Map<Integer, Boolean> visitedVertices = new HashMap<Integer, Boolean>();

    //Your code here!
    visitedVertices.put(originVertex, true);
    traversalOrder.add(originVertex);
    vertexQueue.add(originVertex);

    while (!vertexQueue.isEmpty()) {
      Integer frontVertex = vertexQueue.remove();
      for (Integer neighbor : inputGraph.getNeighbors(frontVertex)) {
        if (!visitedVertices.containsKey(neighbor)) {
          visitedVertices.put(neighbor, true);
          traversalOrder.add(neighbor);
          vertexQueue.add(neighbor);
        }
      }
    }

    return traversalOrder;
  }

  public static Queue<Integer> getDepthFirstTraversal(UnweightedGraph inputGraph, Integer originVertex) {
    int times = 0;
    Queue<Integer> traversalOrder = new LinkedList<>();
    Stack<Integer> vertexStack = new Stack<>();
    Map<Integer, Boolean> visitedVertices = new HashMap<Integer, Boolean>();
    visitedVertices.put(originVertex, true);
    traversalOrder.add(originVertex);
    vertexStack.push(originVertex);

    while (!vertexStack.isEmpty()) {
      Integer topVertex = vertexStack.peek();
      boolean hasNeighbor = false;
      for (Integer v : inputGraph.getNeighbors(topVertex)) {
        if (!visitedVertices.containsKey(v)) {
          visitedVertices.put(v, true);
          traversalOrder.add(v);
          vertexStack.push(v);
          hasNeighbor = true;
          break;
        }
      }
      if (!hasNeighbor) {
        vertexStack.pop();
      }

      times ++;
      if (times > 100) {
        return new LinkedList<>();
      }
    }
    return traversalOrder;
  /* 
      Algorithm getDepthFirstTraversal(originVertex) {
          traversalOrder = a new queue for the resulting traversal order
          vertexStack = a new stack to hold vertices as they are visited
          Mark originVertex as visited
          traversalOrder.enqueue(originVertex)
          vertexStack.push(originVertex)
          while (!vertexStack.isEmpty()) //hint, this is the tricky part, 
                                        //how many times will this loop?? More than V!
          {
              topVertex = vertexStack.peek()
              if (topVertex has an unvisited neighbor)
              {
                nextNeighbor = next unvisited neighbor of topVertex
                Mark nextNeighbor as visited
                traversalOrder.enqueue(nextNeighbor)
                vertexStack.push(nextNeighbor)
              }
              else // All neighbors are visited
                vertexStack.pop()
          }
          return traversalOrder
      }
   */
  }


  public static void main(String[] args) {
    UnweightedGraph test = new MysteryUnweightedGraphImplementation(false, 4);
    test.addEdge(0, 3);
    test.addEdge(1, 3);
    test.addEdge(3, 2);
    test.addEdge(1, 2);

    Queue<Integer> traversed = getDepthFirstTraversal(test, 0);
    for(Integer node : traversed) {
      System.out.print(node + ", ");
    }
    System.out.println();

  }
}