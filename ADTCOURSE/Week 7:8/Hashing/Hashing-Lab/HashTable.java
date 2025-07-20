/**
 * A hash table starter class to be used in the Hashing lab.
 * @author Anya Vostinar
 */
public class HashTable {

    private class Entry {
      Integer key;
      String value;
      private Entry(Integer k, String v) {
        key = k;
        value = v;
      } // end cosntructor

      public String toString() {
        return "[ " + key + ": " + value + " ]";
      }
    }
    private Entry[] hashTable;

    /**
     * Constructor for the hash table
     * @param size the size of the hash table
     */
    public HashTable(int size) {
      hashTable = new Entry[size];
    }
  
    /**
    * Compression function that takes a hash code (positive or negative)  and compresses
    * the hash code into the range [0, sizeOfhashTable).
    * @param hashCode the hash code
    * @return the compressed value
    */
    private int compressToSize(int hashCode) {
      int numberOfBuckets = hashTable.length;
      int compressedValue = hashCode % numberOfBuckets;
      if(compressedValue >= 0) {
        return compressedValue;
      } else {
        return compressedValue+numberOfBuckets;
      }
    }

    /**
     * Creates string representation of the hash table
     * @return string 
     */
    public String toString(){
      String returnString = "";
      for(int i = 0; i<hashTable.length; i++){
          returnString += hashTable[i] + " ";
      }
      return returnString;
  }

  /** 
   * Simple insertion method that ignores what is already there and just 
   * inserts the key into the hash table
   * @param key the key to insert
   */
  public void insertKey(Integer key, String value) {
    int pos = compressToSize(key);
    if (hashTable[pos] != null) {
      while (hashTable[pos] != null) {
        pos ++;
        if (pos >= hashTable.length) {
          pos = 0;
        }
      }
    }
    hashTable[pos] = new Entry(key, value);
  }

  public void insertKey2(Integer key, String value) {
    int pos = compressToSize(key);
    if (hashTable[pos] != null) {
      while (hashTable[pos] != null) {
        pos += 2;
        if (pos >= hashTable.length) {
          pos = 0;
        }
      }
    }
    hashTable[pos] = new Entry(key, value);
  }

  public void insertKey3(Integer key, String value) {
    int pos = compressToSize(key);
    int skipSize = 1 + (key % (hashTable.length - 1));
    if (hashTable[pos] != null) {
      while (hashTable[pos] != null) {
        pos += skipSize;
        if (pos >= hashTable.length) {
          pos = pos - (hashTable.length);
        }
      }
    }
    hashTable[pos] = new Entry(key, value);
  }

  public Entry retrieve(Integer key) {
    int pos = compressToSize(key);
    int skipSize = 1 + (key % (hashTable.length - 1));
    boolean found = false;
    while (!found) {
      if (hashTable[pos].key.compareTo(key) == 0) {
        found = true;
      } else {
        pos += skipSize;
        if (pos >= hashTable.length) {
          pos = pos - (hashTable.length);
        }
      }
    }
    return hashTable[pos];
  }

    public static void main(String[] args) {
      HashTable table = new HashTable(11);
      table.insertKey3(55, "Number 55");
      table.insertKey3(66, "Number 66");
      table.insertKey3(11, "Number 11");
      table.insertKey3(24, "Number 24");
      System.out.println(table);
      System.out.println(table.retrieve(24));
    }
  }