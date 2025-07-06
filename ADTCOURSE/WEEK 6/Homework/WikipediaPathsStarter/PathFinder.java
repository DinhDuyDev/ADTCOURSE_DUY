import java.util.*;

import javax.xml.crypto.dsig.keyinfo.KeyValue;

import java.io.*;

public class PathFinder {
  UnweightedGraph wikiGraph = new MysteryUnweightedGraphImplementation();
  Map<String, Integer> articleVertex = new HashMap<String, Integer>();
  Map<Integer, String> vertexArticle = new HashMap<Integer, String>();
  /**
  * Constructs a PathFinder that represents the graph with nodes (vertices) specified as in
  * nodeFile and edges specified as in edgeFile.
  * @param nodeFile name of the file with the node names
  * @param edgeFile name of the file with the edge names
  */
  public PathFinder(String nodeFile, String edgeFile){
    readNodes(nodeFile);
    readEdges(edgeFile);

  }

  private void readNodes(String nodeFile) {
    File inputFile = new File(nodeFile);
    Scanner scanner = null;
    try {
        scanner = new Scanner(inputFile);
    } catch (FileNotFoundException e) {
        System.err.println(e);
        System.exit(1);
    }

    while(scanner.hasNextLine()) {
      String line = scanner.nextLine();
      if(line.length() > 0 && !line.substring(0,1).equals("#")) {
        Integer nodeNum = wikiGraph.addVertex();
        articleVertex.put(line, nodeNum);
        vertexArticle.put(nodeNum, line);
      }
    }
  }

  private void readEdges(String edgeFile) {
    File inputFile = new File(edgeFile);
    Scanner scanner = null;
    try {
        scanner = new Scanner(inputFile);
    } catch (FileNotFoundException e) {
        System.err.println(e);
        System.exit(1);
    }

    while(scanner.hasNextLine()) {
      String line = scanner.nextLine();
      if(line.length() > 0 && !line.substring(0,1).equals("#")) {
        String[] splitline = line.split("\\s+");
        String begin = splitline[0];
        String end = splitline[1];
        
        int beginNum = articleVertex.get(begin);
        int endNum = articleVertex.get(end);
        wikiGraph.addEdge(beginNum, endNum);
      }
    }
  }


  /**
   * Returns a Hashmap of the predecessor of each nodes from the shortest path from the start node
  * @param start starting vertex 
  * @return hashmap of vertices in order and each of their predecessors
  */
  public Map<Integer, Integer> breadthFirstSearch(String start) {
  
    Map <Integer, Integer> map = new HashMap<>(); 
    Queue<Integer> vertexQueue = new LinkedList<>();
    Map <Integer, Boolean> visitedVertices = new HashMap<>();
    int previousNumber = 0;

    visitedVertices.put(articleVertex.get(start), true); // Setting the start vertex to visited
    map.put(articleVertex.get(start), previousNumber); // adding the progression to the chain
    previousNumber = articleVertex.get(start); // set the previous number to the start number, since it has been processed
    vertexQueue.add(articleVertex.get(start)); // add the start number to the vertex queue in order to find neighbors later

    while (!vertexQueue.isEmpty()) {
      Integer frontVertex = vertexQueue.remove();
      for (Integer neighbor : wikiGraph.getNeighbors(frontVertex)) {
        if (!visitedVertices.containsKey(neighbor)) {
          vertexQueue.add(neighbor);
          map.put(neighbor, frontVertex);
          visitedVertices.put(neighbor, true);
        }
      }
    }
    return map; //new HashMap<Integer, Integer>();
  }
  
  /**
  * Returns a shortest path from node1 to node2, represented as list that has node1 at
  * position 0, node2 in the final position, and the names of each node on the path
  * (in order) in between. If the two nodes are the same, then the "path" is just a
  * single node. If no path exists, returns an empty list.
  * @param node1 name of the starting article node
  * @param node2 name of the ending article node
  * @return list of the names of nodes on the shortest path
  */
  public List<String> getShortestPath(String node1, String node2){
    
    //Your code here!
    Map <Integer, Integer> articles = breadthFirstSearch(node1);
    ArrayList<String> solution = new ArrayList<>();
    int startInt = articleVertex.get(node1);
    int currInt = articleVertex.get(node2);

    while (currInt != startInt) { 
      if (articles.get(currInt) == null) { // if there is no connection between the two, then no path can be found
        return new ArrayList<>();
      }

      currInt = articles.get(currInt); // going back to the previous links, which has been established by breadthFirstSearch
      solution.addFirst(vertexArticle.get(currInt)); // adding the solution
    }
    solution.add(node2); // adding the final needed node to the end

    return solution;
  }

  /**
  * Your documentation here!
  *
  */
  public String toString() {
    return "Number of vertices: " + articleVertex.size() + ". Number of edges: " + wikiGraph.numEdges();
  }

  public static void main(String[] args) {
    //System.out.println("Nothing yet!");
    PathFinder pathFinder = new PathFinder(args[0], args[1]);
    List<String> path = pathFinder.getShortestPath(args[2], args[3]);
    if (path.size() == 0) {
      System.out.println("There isn't a path.");
    } else {
      System.out.println(path);
    }
  }
}
                  