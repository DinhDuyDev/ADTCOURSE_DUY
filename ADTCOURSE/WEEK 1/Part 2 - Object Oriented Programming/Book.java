import java.util.Scanner;
import java.util.ArrayList;
public class Book {
    private String bookTitle;
    private int bookPageCount;
    public Book(String title, int pageCount) {
        this.bookTitle = title;
        this.bookPageCount = pageCount;
    } // end constructor 

    /**
     * Returns the title of the book
     * @return string of book title
     */
    public String getTitle() {
        return bookTitle;
    }
    /**
     * Returns the page count of the book
     * @return book page count in the reference type Integer
     */
    public Integer getPageCount() {
        return bookPageCount;
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        ArrayList<Book> bookList = new ArrayList<>();

        int numBook = Integer.parseInt(args[0]);
        String bookTitleString = "";
        int totalPages = 0;
        for (int i=0; i<numBook; i++) {
            String title;
            int pagecount;

            System.out.println("Title?");
            title = userInput.nextLine();
            System.out.println("Page Count?");
            pagecount = Integer.parseInt(userInput.nextLine());

            bookList.add(new Book(title, pagecount));
        }
        userInput.close();
        for (int i=0; i<bookList.size(); i++) {
            if (i < bookList.size() - 1) {
                bookTitleString += bookList.get(i).getTitle() + ", ";
            } else {
                bookTitleString += bookList.get(i).getTitle();
            }
            totalPages += bookList.get(i).getPageCount();
        }
        System.out.println("Here are your " + numBook + " books!");
        System.out.println(bookTitleString);
        System.out.println("Total pages: " + totalPages);
    }
}