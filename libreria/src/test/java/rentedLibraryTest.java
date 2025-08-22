import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import giuseppecalvaruso.composite.rentedBook;
import giuseppecalvaruso.composite.rentedLibrary;
import giuseppecalvaruso.domain.Book;
import giuseppecalvaruso.domain.Genre;
import giuseppecalvaruso.factory_file.book_factory;
import giuseppecalvaruso.factory_file.standard_book_factory;

public class rentedLibraryTest {

    private final book_factory factory = new standard_book_factory();

    @Test

    public void testEmptiness(){
        rentedLibrary library = new rentedLibrary();
        assertTrue(library.isEmpty());
    }

    public void testAddingAndRemove(){

        rentedLibrary library  = new rentedLibrary();
        Book book = factory.createBook("TestTitle", "111-222", "AuthorX", 100, 2000, Genre.ADVENTURE);
        rentedBook rented = new rentedBook(book);

        library.addingBook(rented);
        assertFalse(library.isEmpty());

        library.removingBook(rented);
        assertTrue(library.isEmpty());
    }

    @Test
    public void addingNull(){
        rentedLibrary library = new rentedLibrary();
        library.addingBook(null);
        assertTrue(library.isEmpty());
    }
    
}
