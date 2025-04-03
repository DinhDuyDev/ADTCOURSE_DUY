package Course;
public class BookStack {
    private int numToRead; // number of books that are planned to be read 
    private int numRead; // number of books read
    String[] bookArray; // book array
    private int arraySize; // size of the array

    public BookStack() {
        this.arraySize = 3;
        bookArray = new String[arraySize];
        this.numToRead = 0;
        this.numRead = 0;
    } // end default constructor 
    

    /**
     * Returns the number of books read, number of books to be read, and all the books
     * 
     */
    public String toString() {
        String arrayContents = "";
        for (String i: bookArray) {
            arrayContents += "\"" + i + "\" ";
        }
        return "Number to read: " + numToRead + ", " + "Number read: " + numRead + "\n" + arrayContents;
    } // end toString

    /**
     * Pushing a book name to the top of the stack. If the push operation exceeds the stack limit then create a list that's twice the size
     * @param element String title to push 
     * @return True if it's pushable, false if there is no more space
     */
    public void push(String element) {
        if (numToRead >= bookArray.length-numRead) {
            String[] temp = bookArray;
            arraySize *= 2;
            bookArray = new String[arraySize];
            for (int i=0; i<numToRead; i++) {
                bookArray[i] = temp[i];
            }
            for (int i=0; i<numRead; i++) {
                bookArray[bookArray.length-1-i] = temp[temp.length-1-i];
            }
        }
        bookArray[numToRead++] = element;
    } // end push


    /**
     * Adding the top book to the read stack
     * @return True if there is a book to read, False if there is not
     */
    public boolean read() {
        if (numToRead == 0) {
            return false;
        }
        bookArray[bookArray.length-1-(numRead++)] = bookArray[--numToRead];
        bookArray[numToRead] = null;
        return true;
    } // end read 

    public static void main(String[] args) {
        BookStack toRead = new BookStack();
        toRead.push("Book 1");
        toRead.push("Book 2");
        toRead.read();
        toRead.push("Book 3");
        toRead.push("Book 4");
        toRead.read();
        toRead.read();
        toRead.read();
        toRead.push("Book 5");
        toRead.push("Book 6");
        toRead.push("Book 7");
        System.out.println(toRead.toString());
    } // end main
} // end BookStack