import java.util.*;
import java.io.*;

public class WordCounter{
  WordCountTree myTree;
  List<String> stopWords = new ArrayList<String>();


  /**
   * Constructor for the WordCounter, creates the WordCountTree and loads the files.
   * @param inputFileName the name of the file with words to count
   * @param stopwordsName the name of the file with filler stop words that shouldn't be counted
   */
  public WordCounter(String inputFileName, String stopwordsName) {
    myTree = new WordCountTree();
    loadFiles(inputFileName, stopwordsName);
  }

  /**
   * Prints the HTML for the word cloud.
   * @param int the number of words that should be in the word cloud
   */
  public void printWordCloudHTML(int numWords) {
    List<WordCount> wordCounts = myTree.getWordCountsByCount();
    String html = WordCloudMaker.getWordCloudHTML("Word Counts", wordCounts.subList(0,numWords));
    System.out.println(html);
  }

  /**
   * Adds the word to the WordCountTree.
   * @param word
   */
  public void addWord(String word) {
    myTree.incrementCount(word);
  }

  public static void main(String[] args) {
    //Implement me!
    WordCounter wordCloud = new WordCounter(args[0], args[1]);
    wordCloud.printWordCloudHTML(Integer.parseInt(args[2]));
  }

  private void loadFiles(String inputFileName, String stopwordsName) {
    File stopWordsFile = new File(stopwordsName);
    Scanner scanner1 = null;
    try {
      scanner1 = new Scanner(stopWordsFile);
    } catch (FileNotFoundException e) {
      System.err.println(e);
      System.exit(1);
    }
    
    while(scanner1.hasNextLine()) {
      String next = scanner1.nextLine();
      stopWords.add(next);
    }
    File inputFile = new File(inputFileName);
    Scanner scanner = null;
      try {
          scanner = new Scanner(inputFile);
      } catch (FileNotFoundException e) {
          System.err.println(e);
          System.exit(1);
      }

      while(scanner.hasNext()){
        String next = scanner.next();
        String[] splitnext = next.split("--");
        for (int i=0; i<splitnext.length; i++) {
          splitnext[i] = splitnext[i].replaceAll("\\s*\\p{Punct}+\\s*$", "").toLowerCase();
          splitnext[i] = splitnext[i].replaceAll("^\\s*\\p{Punct}+\\s*", "");
          if(!stopWords.contains(splitnext[i]) && !splitnext[i].equals("")) {
            addWord(splitnext[i]);
          } 
        }
        
      }


  }
}