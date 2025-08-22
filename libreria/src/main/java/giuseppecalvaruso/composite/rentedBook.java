package giuseppecalvaruso.composite;

import java.util.logging.Logger;

import giuseppecalvaruso.domain.Book;

public class rentedBook implements rentedLibraryComponent {
    private final Book book;
    private static final Logger logger = Logger.getLogger(rentedBook.class.getName());

    public rentedBook(Book book){
        if(book == null){
            throw new IllegalArgumentException("Book cannot be null ");
        }
        this.book = book;
    }

    @Override
    public void print(){
        try{
        System.out.printf("- %s | %s | %s | %d$ | %d\n;", 
        book.getTitle(),
        book.getAuthor(),
        book.getISBN(),
        book.getPrice(),
        book.getPublicationYear()
        );
        logger.info("Printing rented book"+book.getTitle());
        } catch(Exception exception){
            logger.warning("Error in printing rented Book"+ exception.getMessage());
        }


    }
    
    
}
