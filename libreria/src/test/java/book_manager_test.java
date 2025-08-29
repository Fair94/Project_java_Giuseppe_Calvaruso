import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import giuseppecalvaruso.domain.Book;
import giuseppecalvaruso.domain.Genre;
import giuseppecalvaruso.factory_file.book_factory;
import giuseppecalvaruso.factory_file.standard_book_factory;
import giuseppecalvaruso.io.bookmanager;


public class book_manager_test {
    private static final String fileTest = "bookdatabase.txt"; // without the s, in order non to delete database
    private final book_factory factory = new standard_book_factory();

    @BeforeEach
    public void cleanFile(){
        File file = new File(fileTest);
        if(file.exists()){
            file.delete();
        }
    }

    @Test

    public void SaveAndLoad(){
        Book book = factory.createBook("Test", "123-456", "Author", 100,2000, Genre.HORROR);
        bookmanager.saveBook(book);

        List<Book> loaded = bookmanager.loadingBooks();
        assertEquals(1,loaded.size());
        assertEquals("Test", loaded.get(0).getTitle());
        assertEquals("123-456", loaded.get(0).getISBN());
        assertEquals("Author", loaded.get(0).getAuthor());
        assertEquals(100, loaded.get(0).getPrice());
    }

    @Test
    public void testEmptyFile(){
        List<Book> loaded = bookmanager.loadingBooks();
        assertTrue(loaded.isEmpty());
    }

    @Test
    public void multipleBook() throws IOException{
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileTest))){
            pw.println("Title: Book1 | Author: A1 | ISBN: 123 | Price: 50 | Year: 1999 | Genre: ADVENTURE");
            pw.println("Title: Book2 | Author: A2 | ISBN: 456 | Price: 75 | Year: 2005 | Genre: HORROR");

        }

        List<Book> loaded = bookmanager.loadingBooks();
        assertEquals(2, loaded.size());
        assertEquals("Book1", loaded.get(0).getTitle());
        assertEquals("Book2", loaded.get(1).getTitle());
    }


    @Test
    public void deletingTest(){
            Book book1 = factory.createBook("Test", "123-456", "Author", 100,2000, Genre.HORROR);
            Book book2 = factory.createBook("Test1", "123-456-789", "Author", 100,2000, Genre.ADVENTURE);
            bookmanager.saveBook(book2);
            bookmanager.saveBook( book1);

            List<Book> beforeDelete = bookmanager.loadingBooks();
            assertEquals(2, beforeDelete.size());

            bookmanager.deletingBook("123-456");

            List<Book> afterDelete = bookmanager.loadingBooks();
            assertEquals(1, afterDelete.size());
            assertEquals("123-456-789", afterDelete.get(0).getISBN());
    }

    public void deletingNonExistingTest(){
        Book book = factory.createBook("Book", "333", "Author", 100, 2020, Genre.ROMANCE);

        bookmanager.deletingBook("000");
        List<Book> remaingBooks = bookmanager.loadingBooks();
        assertEquals(1, remaingBooks.size());
        assertEquals("333", remaingBooks.get(0).getISBN());
    }
}
