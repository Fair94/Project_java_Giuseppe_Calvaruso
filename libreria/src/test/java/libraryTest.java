import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import giuseppecalvaruso.iterator.BooksIterator;
import giuseppecalvaruso.iterator.Library;

public class libraryTest {

    @Test
    public void Initialized(){
        Library library = new Library();
        assertNotNull(library.createIterator(),"Iterator should exist");
    }

    @Test
    public void Empty(){
        Library library = new Library();
        BooksIterator iterator = library.createIterator();
        assertNotNull(iterator);
        assertFalse(iterator.hasNext());
        
    }
    
}
