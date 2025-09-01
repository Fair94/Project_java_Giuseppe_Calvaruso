import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import giuseppecalvaruso.domain.Genre;
import giuseppecalvaruso.factory_file.Book;
import giuseppecalvaruso.factory_file.book_factory;
import giuseppecalvaruso.factory_file.standard_book_factory;
import giuseppecalvaruso.iterator.BooksIterator;
import giuseppecalvaruso.iterator.LibraryBookIterator;

public class libraryBookIteratorTest {

    private final book_factory factory = new standard_book_factory();

    @Test

    public void emptyIterator(){
        BooksIterator iterator = new LibraryBookIterator(List.of());
        assertFalse(iterator.hasNext());
        assertNull(iterator.next());
     }

     public void iterationOnBooks(){
         Book b1 = factory.createBook("Book1", "ISBN1", "Author1", 100, 2000, Genre.ADVENTURE);
         Book b2 = factory.createBook("Book2", "ISBN2", "Author2", 200, 2010, Genre.FANTASY);

         BooksIterator iterator = new LibraryBookIterator(List.of(b1,b2));

         assertTrue(iterator.hasNext());
         assertEquals(b1,iterator.next());

         assertTrue(iterator.hasNext());
         assertEquals(b2,iterator.next());

         assertFalse(iterator.hasNext());
         assertNull(iterator.next());
        }


        public void Nulltest(){
            BooksIterator iterator = new LibraryBookIterator(null);
            assertFalse(iterator.hasNext());
            assertNull(iterator.next());

        }

    
}
