import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import giuseppecalvaruso.domain.Book;
import giuseppecalvaruso.domain.Genre;
import giuseppecalvaruso.factory_file.book_factory;

public class book_factory_mockito_test {
    @Test
    public void mockitoTest(){

        book_factory mockFactory = mock(book_factory.class);
        Book mockBook = mock(Book.class);

        when(mockFactory.createBook("MockTitle", "111-222", "MockAuthor", 99, 2023, Genre.ADVENTURE))
        .thenReturn(mockBook);

        Book result = mockFactory.createBook("MockTitle", "111-222", "MockAuthor", 99, 2023, Genre.ADVENTURE);
        assertEquals(mockBook,result);

        verify(mockFactory, times(1)).createBook("MockTitle", "111-222", "MockAuthor", 99, 2023, Genre.ADVENTURE);
        
    }
}
