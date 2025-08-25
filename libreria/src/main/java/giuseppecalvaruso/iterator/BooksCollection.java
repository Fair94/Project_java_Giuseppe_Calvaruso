package giuseppecalvaruso.iterator;
/* 
Aggregates for the iterator 
**/
public interface BooksCollection {
    /**
     * Creates iterator
     * @return BooksIterator instance
     */
    BooksIterator createIterator();
    
}
