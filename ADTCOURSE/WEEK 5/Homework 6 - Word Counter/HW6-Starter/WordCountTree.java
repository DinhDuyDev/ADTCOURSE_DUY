import java.util.*;

public class WordCountTree {
  Node root;

  private class Node {
    char character;
    int count;
    List<Node> children = new LinkedList<Node>();

    public Node(char ch, int in){
      character = ch;
      count = in;
    }

    public Node() {
      count = 0;
    }
  }

  /**
   * Constructs an empty WordCountTree.
   */ 
  public WordCountTree(){
    root = new Node();
  }
  

  /**
 * Adds 1 to the existing count for word, or adds word to the WordCountTree
 * with a count of 1 if it was not already present.
 * Implementation must be recursive, not iterative.
 */
  public void incrementCount(String word){
    incrementCountHelper(root, word);
  }

  private void incrementCountHelper(Node currNode, String word) {
    if (word.length() > 1) {
      boolean found = false;
      for (Node n : currNode.children) {
        if (n.character == word.charAt(0)) {
          incrementCountHelper(n, word.substring(1));
          found = true;
          break;
        }
      }
      Node newNode = new Node(word.charAt(0), 0);
      if (!found) {
        currNode.children.add(newNode);
        incrementCountHelper(newNode, word.substring(1));
      }
    } else {
      boolean found = false;
      for (Node n : currNode.children) {
        if (n.character == word.charAt(0)) {
          n.count ++;
          found = true;
          break;
        }
      }
      Node newNode = new Node(word.charAt(0), 1);
      if (!found) {
        currNode.children.add(newNode);
      }
    }
  }
  
  /**
 * Returns true if word is stored in this WordCountTree with
 * a count greater than 0, and false otherwise.
 * Implementation must be recursive, not iterative.
 */
  public boolean contains(String word){
    return containsHelper(root, word);
  }

  private boolean containsHelper(Node currNode, String word) {
    if (word.length() > 1) {
      boolean found = false;
      Node n = null;
      for (Node nd : currNode.children) {
        n = nd;
        if (n.character == word.charAt(0)) {
          found = true;
          break;
        }
      }
      if (found) {
        return containsHelper(n, word.substring(1));
      } else {
        return false;
      }
    } else {
      Node n = null;
      for (Node nd : currNode.children) {
        n = nd;
        if (n.character == word.charAt(0)) {
          return true;
        }
      }
      return false;
    }
  }
  
/**
 * Returns the count of word, or -1 if word is not in the WordCountTree.
 * Implementation must be recursive, not iterative.
 */
  public int getCount(String word){
    return getCounterHelper(root, word);
  }

  private int getCounterHelper(Node currNode, String word) {
    if (word.length() > 1) {
      boolean found = false;
      Node n = null;
      for (Node nd : currNode.children) {
        n = nd;
        if (n.character == word.charAt(0)) {
          found = true;
          break;
        }
      }
      if (found) {
        return getCounterHelper(n, word.substring(1));
      } else {
        return 0;
      }
    } else {
      Node n = null;
      for (Node nd : currNode.children) {
        n = nd;
        if (n.character == word.charAt(0)) {
          return n.count;
        }
      }
      return 0;
    }
  }

  /** 
 * Returns a count of the total number of nodes in the tree. 
 * A tree with only a root is a tree with one node; it is an acceptable
 * implementation to have a tree that represents no words have either
 * 1 node (the root) or 0 nodes.
 * Can be recursive or use an instance variable.
 */
  public int getNodeCount(){
    int totalCount = 0;
    for (Node n : root.children) { 
      totalCount += getNodeCountHelper(n);
    }
    return totalCount;
  }
  
  private int getNodeCountHelper(Node currNode) {
    if (currNode.children.isEmpty()) {
      return 1;
    } else {
      int totalNode = 0;
      for (Node n : currNode.children) {
        totalNode += getNodeCountHelper(n); 
      }
      totalNode += 1;
      return totalNode;
    }
  }
  
  /** 
  * Creates and sorts in decreasing order a list 
  * of WordCount objects, one per word stored in this 
  * WordCountTree.
  *
  * @return      a List of WordCount objects in decreasing order
  */
  public List<WordCount> getWordCountsByCount(){
    List<WordCount> wordCountList = new ArrayList<WordCount>();
    getWordCountsHelper(root, "", wordCountList);
    Collections.sort(wordCountList, new SortWordCount());
    return wordCountList;
  }

  private void getWordCountsHelper(Node node, String wordSoFar, List<WordCount> wordCountList) {
    if(node.children.size() == 0) {
      return;
    }
    for(Node child : node.children) {
      String nextWord = wordSoFar + child.character;

      if(child.count != 0) {
        WordCount newWord = new WordCount(nextWord, child.count);
        wordCountList.add(newWord);
      }
      getWordCountsHelper(child, nextWord, wordCountList);
    }
  }

  public static void main(String[] args) {
    //Test your methods here!
    WordCountTree countTree = new WordCountTree();
    countTree.incrementCount("the");
    countTree.incrementCount("the");
    countTree.incrementCount("the");
    countTree.incrementCount("the");
    countTree.incrementCount("the");
    countTree.incrementCount("the");
    countTree.incrementCount("the");
    countTree.incrementCount("that");
    countTree.incrementCount("chomp");
    countTree.incrementCount("cat");
    countTree.incrementCount("then");
    System.out.println(countTree.getCount("then"));
    System.out.println(countTree.getNodeCount());
  }
}