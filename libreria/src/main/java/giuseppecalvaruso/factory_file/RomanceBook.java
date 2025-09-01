package giuseppecalvaruso.factory_file;

import giuseppecalvaruso.domain.Genre;

public class RomanceBook extends AbstractBook {
     public RomanceBook(String title, String ISBN, String author, int price, int publicationYear,boolean rented, Genre genre){
        super(title, ISBN, author, price, publicationYear, rented, genre);
    }
    
}
