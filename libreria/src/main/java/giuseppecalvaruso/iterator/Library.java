package giuseppecalvaruso.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import giuseppecalvaruso.domain.Book;
import giuseppecalvaruso.io.bookmanager;

public class Library implements BooksCollection {
        private final List<Book> books;
        private static final Logger logger = Logger.getLogger(Library.class.getName());

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
    
        @Override
        public BooksIterator createIterator(){
            logger.info("Creting iterator");
            return new LibraryBookIterator(books);

        }
}
