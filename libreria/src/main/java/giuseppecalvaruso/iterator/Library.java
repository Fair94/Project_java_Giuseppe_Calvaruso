package giuseppecalvaruso.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import giuseppecalvaruso.domain.Book;
import giuseppecalvaruso.io.bookmanager;

/**
 * Concrete aggregate of iterator pattern
 * 
 * Rappresent a collection of book objects.
 * Load books and provide an iterators. 
 */
public class Library implements BooksCollection {
        private final List<Book> books;
        private static final Logger logger = Logger.getLogger(Library.class.getName());
        /**
         * Initialiting library
         */
        public Library(){
            List<Book> loadedBooks = bookmanager.loadingBooks();
            if(loadedBooks == null){
                logger.warning("No books loaded, empty library");
                this.books = new ArrayList<>();
            } else{
                this.books = new ArrayList<>(loadedBooks);
                logger.info("Initialized" + books.size()+ " elements");
            }
            
        }
        /**
         * Creating iterators 
         */
        @Override
        public BooksIterator createIterator(){
            logger.info("Creting iterator");
            return new LibraryBookIterator(books);

        }
}
