import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class InstituteLibrary implements Library {

     List<Book> bookInLibrary = new LinkedList<Book>();
     Map<Book, String> bookInStudents = new HashMap<Book,String>();

    public void addNewBook(Book book) {
        bookInLibrary.add(book);
    }

    public void borrowBook(Book book, String student) {
        if(bookInLibrary.contains(book)) {
            bookInStudents.put(book, student);
            bookInLibrary.remove(book);
        }
    }

    public void returnBook(Book book, String student) {
        if(bookInStudents.get(book).equals(student)){
            bookInLibrary.add(book);
            bookInStudents.remove(book);
        }
    }

    public List<Book> findAvailableBooks() {
        return bookInLibrary;
    }
}
