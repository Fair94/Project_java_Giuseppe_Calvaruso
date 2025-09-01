import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import giuseppecalvaruso.factory_file.Book;
import giuseppecalvaruso.factory_file.Genre;
import giuseppecalvaruso.factory_file.book_factory;
import giuseppecalvaruso.factory_file.standard_book_factory;

public class subBooktest {
    public class subBookstest{

        private final book_factory factory = new standard_book_factory();

        @ParameterizedTest
        @EnumSource(Genre.class)
        public void testBook(Genre genre){
            Book book = factory.createBook("Test", "123-456", "Author", 100, 2020, genre);
            assertNotNull(book);
            assertEquals(genre,book.getGenre());
            assertEquals("Test",book.getTitle());
             }


    }
    
}
