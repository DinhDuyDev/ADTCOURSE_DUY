import java.util.*;

public class WordCount{

  public String word;
  public int count;

  /* 
   * Constructs a new WordCount with the given word and count
   * @param myWord the word to store
   * @param myCount the count to store
   */
  public WordCount(String myWord, int myCount) {
    word = myWord;
    count = myCount;
  }
  
/**
 * Gets the word stored by this WordCount
 * @return the word stored by this WordCount
 */
public String getWord(){
  return word;
}
 
/** 
 * Gets the count stored by this WordCount
 * @return the count stored by this WordCount
 */
 public int getCount() {
   return count;
 }  

 /**
  * Returns a string representation of this WordCount
  * @return a string representation of this WordCount
  */
 public String toString() {
   return word + ": " + count;
 }

}

/* A class that allows for sorting WordCounts */
class SortWordCount implements Comparator<WordCount> {

  /*
   * Compares two WordCounts by their counts
   * @param a the first WordCount to compare
   * @param b the second WordCount to compare
   * @return a negative number if a's count is greater than than b's count, 0 if they are equal, and a positive number if a's count is less than b's count
   */
  public int compare(WordCount a, WordCount b)
  {
    return b.count - a.count;
  }

}