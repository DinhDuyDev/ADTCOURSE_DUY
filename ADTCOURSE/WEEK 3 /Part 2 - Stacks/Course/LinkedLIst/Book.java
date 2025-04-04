public class Book {
    private String bookTitle;
    private Book   previousBook;
    private Book   nextBook;
    
    public Book(String title) {
        bookTitle = title;
    }
    public String getBookTitle() {
        return bookTitle;
    }

    public Book getPreviousBook() {
        return previousBook;
    }

    public Book getNextBook() {
        return nextBook;
    }

    public void setNextBook(Book next) {
        nextBook = next;
    }

    public void setPreviousBook(Book previous) {
        previousBook = previous;
    }
}
