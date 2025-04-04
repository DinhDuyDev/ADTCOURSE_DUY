public class BookStackL {
    private Book top;
    private Book bottom;
    private int numToRead = 0;
    private int numRead = 0;

    public BookStackL() {
        top = new Book(null);
        bottom = new Book(null);
        top.setNextBook(bottom);
        bottom.setPreviousBook(top);
    }

    private Book getBookAt(int index) {
        Book get = top;
        int i = 0;
        while (i < index) {
            get = get.getNextBook();
            i++;
        }
        return get;
    }
    public void push(String title) {
        Book bookPush = new Book(title);
        Book bookAtIndex = getBookAt(numToRead);
        Book bookUnder = bookAtIndex.getNextBook();
        bookAtIndex.setNextBook(bookPush);
        bookPush.setNextBook(bookUnder);
        bookPush.setPreviousBook(bookAtIndex);
        numToRead++;
        System.out.println("Prev: " + bookPush.getPreviousBook().getBookTitle() + " | " + "Name: " + bookPush.getBookTitle() + " | " + "Post: " + bookPush.getNextBook().getBookTitle());
    }

    public boolean read() {
        if (numToRead == 0) {
            return false;
        }
        numToRead--;
        numRead++;
        return true;
    }
    public String toString() {
        String stringForm = "";
        stringForm += "Number of books to read: " + numToRead + ", " + "Number of books read: " + numRead + "\n";

        Book getTop = top.getNextBook();
        while (getTop != bottom) {
            stringForm += "\"" + getTop.getBookTitle() + "\"" + " ";
            getTop = getTop.getNextBook();
        }
        return stringForm;
    }

    public static void main(String[] args) {
        BookStackL bookStack = new BookStackL();
        bookStack.push("Book 1");
        bookStack.push("Book 2");
        bookStack.push("Book 3");
        bookStack.read();
        bookStack.push("Book 10");
        System.out.println(bookStack.toString());
    }
}
