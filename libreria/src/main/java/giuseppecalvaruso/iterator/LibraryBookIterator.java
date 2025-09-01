package giuseppecalvaruso.iterator;

import java.util.List;
import java.util.logging.Logger;

import giuseppecalvaruso.factory_file.Book;

/**
 * Concrete Iterator. 
 * Sequential access
 */
public class LibraryBookIterator implements BooksIterator {
    private final List<Book> books;
    private int index = 0;
    private static final Logger logger = Logger.getLogger(LibraryBookIterator.class.getName());

    /**
     * Building a Library book iterator 
     * @param books list of books iterating on 
     */
    public LibraryBookIterator(List<Book> books){
        if(books == null){
            logger.warning("List null, empty iterator");
            this.books = List.of();
        }else{

        this.books = books;
        }
    }

    /**
     *Checking if more books are avaiable 
     *   
     * */
    @Override
    public boolean hasNext(){
        boolean result = index <books.size();
        if(!result){
            logger.info("No books in iterator");
        }
        return result;

    }


    /**
     * Returning next book or null
     */
    @Override
    public Book next() {

        if(!hasNext()){
            logger.warning("next is called, no books available");
            return null;
        }

        Book book = books.get(index);
        index++;
        return book ;
       
    }
    
}
