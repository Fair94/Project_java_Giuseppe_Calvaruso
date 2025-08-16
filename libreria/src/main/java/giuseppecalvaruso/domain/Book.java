package giuseppecalvaruso.domain;
/**
 * This is the Product element of fatory pattern
 */
/**Interface  for creating a generic book.
 * @param getTitle takes the book's Title
 * @param getISBN takes book'ISBN
 * @param getAuthor takes book's Author
 * @param getPrice takes book's Price
 * @param isRented return True if is rented, False if is avaiable for renting
 * @param setRented set the rented status 
  */

public interface  Book {
    String getTitle();
    String getISBN();
    String getAuthor();
    int getPrice();
    boolean isRented();
    int getPublicationYear();
    void setRented(boolean rented);
    Genre getGenre();
    

    
}
