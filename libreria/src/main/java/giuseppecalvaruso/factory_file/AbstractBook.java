package giuseppecalvaruso.factory_file;

import annotations.ISBN;
import annotations.Positive;
import annotations.Rented;
import annotations.notEmpty;
import giuseppecalvaruso.domain.Genre;

/**
 * base class for books
 */
public abstract  class AbstractBook implements Book {
    /**title, must not be empty */
    @notEmpty
    private final String title;

    /**Isbn, check format */
     @ISBN(lenght = 13)
    private final String ISBN;
   

    /**author of the book, must not be empty */
    @notEmpty
    private final String author;

    /**price for the book, positive */
    @Positive(positive = true)
    private final int price;

    /**Publication year */
    @Positive(positive = true)
    private final int publicationYear;

    /** To rented or not to be rented?? */
    @Rented
    private boolean rented;

    /**Book genre */
    private final Genre genre;

        public AbstractBook(String title, String ISBN, String author, int price, int publicationYear, boolean rented, Genre genre){
            this.title = title;
            this.ISBN = ISBN;
            this.author = author;
            this.price = price;
            this.publicationYear = publicationYear;
            this.rented = rented;
            this.genre = genre;


        }

        @Override
        public String getTitle(){
            return title;
        }
        @Override
        public String getISBN(){
            return ISBN;
        }
        @Override
        public String getAuthor(){
            return author;
        }

        @Override
        public int getPrice(){
            return price;
        }
        @Override
        public int getPublicationYear(){
            return publicationYear;
        }
        @Override
        public boolean isRented(){
            return rented;
        }
        @Override
        public void setRented(boolean rented){
            this.rented = rented;
        }

        @Override
        public Genre getGenre(){
            return genre;
        }

        @Override
        public String toString(){

            return String.format("Title: %s | Author: %s | ISBN: %s | Price: %d | Year: %d | Genre: %s | Rented: %s",
            title,author,ISBN,price,publicationYear,genre,rented?"Yes":"No");
        }

    
}
