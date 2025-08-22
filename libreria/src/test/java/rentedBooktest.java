import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import giuseppecalvaruso.composite.rentedBook;
import giuseppecalvaruso.domain.Book;
import giuseppecalvaruso.domain.Genre;
import giuseppecalvaruso.factory_file.book_factory;
import giuseppecalvaruso.factory_file.standard_book_factory;

public class rentedBooktest {

    private final book_factory factory = new standard_book_factory();

    @Test

    public void nullTest(){
        assertThrows(IllegalArgumentException.class, ()-> new rentedBook(null));
    }

    @Test

    public void testPrintNotError(){
        Book book = factory.createBook("Test Title", "111-222", "AuthorX", 100, 2000, Genre.ADVENTURE);
        rentedBook rented = new rentedBook(book);
        assertDoesNotThrow(()->rented.print());
    }
    
}
