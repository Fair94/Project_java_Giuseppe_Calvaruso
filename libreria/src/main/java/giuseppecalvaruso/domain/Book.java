package giuseppecalvaruso.domain;

import annotations.ISBN;
import annotations.Positive;
import annotations.Rented;
import annotations.notEmpty;

/**
 * This is the Product element of factory pattern
 */

public interface  Book {

  /**Returning title of the book
   * Not empty, @NotEmpty annotation
   * @return book's title
   */
    @notEmpty
    String getTitle();

  /**
   * Returning book ISBN.
   * See annotations  for Correct format
   * @return book's ISBN
   */
     @ISBN
    String getISBN();

    /**
     * 
     * @return author of the book
     */
    @notEmpty
    String getAuthor();

    /**
     * 
     * @return positive book's price
     */
    @Positive
    int getPrice();

    /**
     * 
     * @return true if rented, false if not rented
     */
    @Rented
    boolean isRented();


    /**
     * 
     * @return publication year
     */
    int getPublicationYear();


    /**
     * 
     * @rented genre of the book 
     */
    void setRented(boolean rented);
    Genre getGenre();
    

    
}
