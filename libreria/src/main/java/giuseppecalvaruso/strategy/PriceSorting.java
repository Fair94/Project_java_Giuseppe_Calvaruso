package giuseppecalvaruso.strategy;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

import annotations.notEmpty;
import giuseppecalvaruso.domain.Book;

@Strategy("Price")
public class PriceSorting implements SortingStrategy {
    private static final Logger logger = Logger.getLogger(PriceSorting.class.getName());

    @Override
    @notEmpty
    public void sort(List<Book> books) {
        try{
            Collections.sort(books,Comparator.comparingInt(Book::getPrice));
            logger.info("Books sorted for price");
        } catch(Exception exception){
            logger.warning("Error in sorting "+ exception.getMessage());
        }
       
    }
    
}
