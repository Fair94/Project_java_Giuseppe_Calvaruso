package giuseppecalvaruso.factory_file;

import java.util.logging.Logger;

import giuseppecalvaruso.domain.AdventureBook;
import giuseppecalvaruso.domain.Book;
import giuseppecalvaruso.domain.FantasyBook;
import giuseppecalvaruso.domain.Genre;
import giuseppecalvaruso.domain.HistoryBook;
import giuseppecalvaruso.domain.HorrorBook;
import giuseppecalvaruso.domain.OtherBook;
import giuseppecalvaruso.domain.RomanceBook;
import giuseppecalvaruso.domain.SciFiBook;
import giuseppecalvaruso.exception.InputError;
/**This is the concrete creator for the factory pattern */


public class standard_book_factory implements book_factory {

    private static final Logger logger = Logger.getLogger(standard_book_factory.class.getName());

    public Book createBook(String title, String ISBN, String author, int price, int publicationYear, Genre genre){

        if(title == null || title.isBlank()){
            logger.warning("Impossible to create the book for  title field problem.");
             throw new InputError("Empty or invalid  title, please check again");
        }

        if(ISBN == null || ISBN.isBlank()){ 
            logger.warning("Impossible to create the book for ISBN field problem.");
            throw new InputError("Empty or Invalid ISBN, pleas check again");
        }

        if(author == null || author.isBlank()) {
            logger.warning("Impossible to create the book for author field problem");
            throw new InputError("Empty or Invalid authro,please chek again ");
        }

        if(price <= 0) {
            logger.warning("Impossible to create the book for price field problem ");
            throw new InputError("Please, insert a positive value ");
        }

         if(publicationYear <= 0) {
            logger.warning("Impossible to create the book for publicationYear field problem ");
            throw new InputError("Please, insert a positive value ");
       
        }

         if(genre == null){
            genre = Genre.OTHER;
        }
        logger.info("Book created succesfully");
       
        switch(genre){
            case ADVENTURE:
            return new AdventureBook(title.trim(),ISBN.trim(),author.trim(),price,publicationYear,false,genre);

            case FANTASY:
            return new FantasyBook(title.trim(),ISBN.trim(),author.trim(),price,publicationYear,false,genre);

            case HISTORY:
            return new HistoryBook(title, ISBN, author, price, publicationYear, false, genre);

            case HORROR:
            return new HorrorBook(title, ISBN, author, price, publicationYear, false, genre);

            

            case ROMANCE:
            return new RomanceBook(title, ISBN, author, price, publicationYear, false, genre);

            case SCI_FI:
            return new SciFiBook(title, ISBN, author, price, publicationYear, false, genre);

            default:
            return new OtherBook(title, ISBN, author, price, publicationYear, false, genre);

        }


    }
    
}
