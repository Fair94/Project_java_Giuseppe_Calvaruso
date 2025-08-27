package giuseppecalvaruso.strategy;

import java.util.List;

import annotations.notEmpty;
import giuseppecalvaruso.domain.Book;

/**
 * Sorting use to sort books
 */

public interface SortingStrategy{


    /**
     * 
     * @param books list of the book. not be null or empty
     * @return
     */

     @notEmpty
    void sort(List<Book> books);

}