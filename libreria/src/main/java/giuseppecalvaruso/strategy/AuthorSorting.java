package giuseppecalvaruso.strategy;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

import annotations.notEmpty;
import giuseppecalvaruso.factory_file.Book;

@Strategy("Author")
public class AuthorSorting implements SortingStrategy {
    private final static Logger logger = Logger.getLogger(SortingStrategy.class.getName());

    @Override
    @notEmpty
    public void sort(List<Book> books) {
        try{
            Collections.sort(books,Comparator.comparing(Book::getAuthor,String.CASE_INSENSITIVE_ORDER));
            logger.info("Books sorted succesfully");
        } catch(Exception exception){
            logger.warning("Error in sorting " + exception.getMessage());

        }
        
    }
    
}
