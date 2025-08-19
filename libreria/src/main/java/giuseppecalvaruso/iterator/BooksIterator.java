package giuseppecalvaruso.iterator;

import giuseppecalvaruso.domain.Book;

public interface BooksIterator {
    boolean hasNext();
    Book next();
    
}
