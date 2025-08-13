package giuseppecalvaruso.domain;
/**This is the file used to create an  AdventureBook, is the Concrete Product of factory pattern
 * @param title is for the title book
 * @param ISBN is for the identification number of the book
 * @param author is for the name of the book's author 
 * @param price is for the book's price
 * @param rented is a Boolean. If true the book is not in library. If false is in library 
 */

public class  AdventureBook implements Book {
    private final String title;
    private final String ISBN;
    private final String author;
    private final int    price;
    private final int publicationYear;
    private boolean rented; 

   
  
    /* This is the constructor for the book */
    public AdventureBook(String title, String ISBN, String author, int price,int publicationYear,boolean rented ){
        this.publicationYear = publicationYear;
        this.title = title;
        this.ISBN = ISBN;
        this.author = author;
        this.price = price;
        this.rented = false; /*by default, when we create a book object and we inserted it in our catalogue, this is not rented */

    }
    /*This are the getter of the properties of the book.
     * They permits us secure access to the properties
     * I've created a setter for rented field, because is the only we can change to check if it's rented or no
     **/
     public String getTitle() {
         return title;
         }
     public String getISBN() {
         return ISBN;
         }
     public String getAuthor() {
        return author;
         }
     public int getPrice() {
        return price;
        }
     public boolean isRented() {
        return rented;
    }
     public int getPublicationYear() {
        return publicationYear;
    }
      public void setRented(boolean rented) {
        this.rented = rented;
    }


    
}
