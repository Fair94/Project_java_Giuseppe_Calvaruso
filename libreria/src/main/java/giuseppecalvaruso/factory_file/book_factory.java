package giuseppecalvaruso.factory_file;

import giuseppecalvaruso.domain.Genre;

/**
 * This is the creator of the factory pattern
 */
public interface book_factory {

    /**
     * 
     * @param title title of the book, not empy
     * @param ISBN unique code for teh book
     * @param author author of the book, not empty
     * @param price positive price for the book
     * @param publicationYear  publication Year
     * @param genre genre of the book
     * @return a concrete implementation for the book
     */
    Book createBook(String title, String ISBN, String author, int price, int publicationYear,Genre genre);
    
}
