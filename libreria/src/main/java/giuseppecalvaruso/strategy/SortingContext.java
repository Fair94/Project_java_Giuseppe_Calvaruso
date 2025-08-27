package giuseppecalvaruso.strategy;

import java.awt.List;
import java.util.logging.Logger;
import giuseppecalvaruso.domain.Book;

/**
 * Allowing changing sorting strategy runtime
 */
public class SortingContext {
    private SortingStrategy strategy;
    private static final Logger logger = Logger.getLogger(SortingContext.class.getName());
/**
 * 
 * @param strategy a valid strategy
 */

    public void setStrategy(SortingStrategy strategy){
        if(strategy == null){
            logger.warning("Null strategy provided, keeping the previous");
            return;

        }
        this.strategy = strategy;

    }

    public void executing(List<Book> books){}
    
}
