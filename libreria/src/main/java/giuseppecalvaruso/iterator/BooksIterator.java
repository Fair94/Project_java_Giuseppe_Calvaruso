package giuseppecalvaruso.iterator;

import giuseppecalvaruso.domain.Book;


/**
 * Iterator interface. Used to traverse the collections of books
 */
public interface BooksIterator {

    /**
     * it says if there are other books 
     * 
     * @return true if there are more books
     */
    boolean hasNext();

    /**
     * next book in collection
     * 
     * @return next book object
     */
    Book next();
    
}
