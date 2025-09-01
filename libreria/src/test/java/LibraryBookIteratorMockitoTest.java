import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

import giuseppecalvaruso.factory_file.Book;
import giuseppecalvaruso.iterator.BooksIterator;
import giuseppecalvaruso.iterator.LibraryBookIterator;

public class LibraryBookIteratorMockitoTest {

    @Test
    public void  MockedIterator(){
        Book mockBook1 = mock(Book.class);
        Book mockBook2 = mock(Book.class);

        Iterator<Book> mockedIterator = mock(Iterator.class);
        when(mockedIterator.hasNext()).thenReturn(true,true,false);
        when(mockedIterator.next()).thenReturn(mockBook1,mockBook2);

        List<Book> mockedList = mock(List.class);
        when(mockedList.iterator()).thenReturn(mockedIterator);

        BooksIterator iterator = new LibraryBookIterator(mockedList);

        assertTrue(iterator.hasNext());
        assertEquals(mockBook1, iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(mockBook2, iterator.hasNext());

        assertFalse(iterator.hasNext());
        assertNull(iterator.next());

        verify(mockedIterator,times(3)).hasNext();
        verify(mockedIterator,times(2)).hasNext();




    }
    
}
