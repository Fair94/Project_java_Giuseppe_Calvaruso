package giuseppecalvaruso.factory_file;

import giuseppecalvaruso.domain.Book;
import giuseppecalvaruso.domain.Genre;

/**
 * This is the creator of the factory pattern
 */
public interface book_factory {
    Book createBook(String title, String ISBN, String author, int price, int publicationYear,Genre genre);
    
}
