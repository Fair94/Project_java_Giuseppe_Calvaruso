package giuseppecalvaruso.iterator;

import java.util.List;
import java.util.logging.Logger;

import giuseppecalvaruso.domain.Book;

public class LibraryBookIterator implements BooksIterator {
    private final List<Book> books;
    private int index = 0;
    private static final Logger logger = Logger.getLogger(LibraryBookIterator.class.getName());

    public LibraryBookIterator(List<Book> books){
        if(books == null){
            logger.warning("List null, empty iterator");
            this.books = List.of();
        }else{

        this.books = books;
        }
    }

    @Override
    public boolean hasNext(){
        boolean result = index <books.size();
        if(!result){
            logger.info("No books in iterator");
        }
        return result;

    }

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
