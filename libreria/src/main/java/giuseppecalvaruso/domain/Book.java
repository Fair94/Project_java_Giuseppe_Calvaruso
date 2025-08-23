package giuseppecalvaruso.domain;

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


    String getISBN();
    String getAuthor();
    int getPrice();
    boolean isRented();
    int getPublicationYear();
    void setRented(boolean rented);
    Genre getGenre();
    

    
}
