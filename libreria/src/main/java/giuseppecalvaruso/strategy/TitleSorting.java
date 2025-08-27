package giuseppecalvaruso.strategy;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

import giuseppecalvaruso.domain.Book;

/**
 * Concrete: Sorting by title
 */
@Strategy("Title")
public class TitleSorting implements SortingStrategy {
    private static final Logger logger = Logger.getLogger(TitleSorting.class.getName());

    @Override
    public void sort(List<Book> books) {
        try{
            Collections.sort(books,Comparator.comparing(Book:: getTitle,String.CASE_INSENSITIVE_ORDER));
            logger.info("Book sorted succesfully");
        } catch (Exception exception){
            logger.warning("Error in sorting by title: " + exception.getMessage() );
        }
       
    }
    
}
