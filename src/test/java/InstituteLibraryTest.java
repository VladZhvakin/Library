import org.junit.Assert;
import org.junit.Test;

public class InstituteLibraryTest {

    InstituteLibrary library = new InstituteLibrary();
    Book bookOne = new Book(1, "one");
    Book bookTwo = new Book(2, "two");
    Book bookThree = new Book (3, "three");


    @Test
    public void addNewBook() {

        library.addNewBook(bookOne);
        library.addNewBook(bookTwo);
        library.addNewBook(bookThree);

        Assert.assertEquals(3, library.bookInLibrary.size());
        Assert.assertTrue(library.bookInLibrary.contains(bookOne));
        Assert.assertTrue(library.bookInLibrary.contains(bookTwo));
        Assert.assertTrue(library.bookInLibrary.contains(bookThree));

    }

    @Test
    public void borrowBook() {

        library.bookInLibrary.add(bookOne);
        library.bookInLibrary.add(bookTwo);

        library.borrowBook(bookOne, "Иванов");

        Assert.assertEquals(1, library.bookInLibrary.size());
        Assert.assertFalse(library.bookInLibrary.contains(bookOne));
        Assert.assertTrue(library.bookInLibrary.contains(bookTwo));

        Assert.assertEquals(1, library.bookInStudents.size());
        Assert.assertTrue(library.bookInStudents.containsKey(bookOne));
        Assert.assertTrue(library.bookInStudents.containsValue("Иванов"));

    }

    @Test
    public void returnBook() {

        library.bookInStudents.put(bookOne, "Иванов");
        library.bookInLibrary.add(bookTwo);

        library.returnBook(bookOne, "Иванов");

        Assert.assertEquals(2, library.bookInLibrary.size());
        Assert.assertTrue(library.bookInLibrary.contains(bookOne));
        Assert.assertTrue(library.bookInLibrary.contains(bookTwo));

        Assert.assertEquals(0, library.bookInStudents.size());
        Assert.assertFalse(library.bookInStudents.containsKey(bookOne));

    }

    @Test
    public void findAvailableBooks() {

        library.bookInLibrary.add(bookTwo);

        Assert.assertEquals(library.bookInLibrary, library.findAvailableBooks());

    }
}