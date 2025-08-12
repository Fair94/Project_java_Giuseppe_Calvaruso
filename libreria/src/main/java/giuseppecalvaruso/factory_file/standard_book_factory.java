package giuseppecalvaruso.factory_file;

import giuseppecalvaruso.domain.AdventureBook;
import giuseppecalvaruso.domain.Book;
import giuseppecalvaruso.exception.InputError;
/**This is the concrete creator for the factory pattern */
public class standard_book_factory implements book_factory {
    public Book createBook(String title, String ISBN, String author, int price){

        if(title == null || title.isBlank()) throw new InputError("Empty or invalid  title, please check again");
        if(ISBN == null || ISBN.isBlank()) throw new InputError("Empty or Invalid ISBN, pleas check again");
        if(author == null || author.isBlank()) throw new InputError("Empty or Invalid authro,please chek again ");
        if(price <= 0) throw new InputError("Please, insert a positive value ");

        return new AdventureBook(title.trim(), ISBN.trim(), author.trim(), price, false);


    }
    
}
