package giuseppecalvaruso.domain;

public class FantasyBook extends AbstractBook {
     public FantasyBook(String title, String ISBN, String author, int price, int publicationYear,boolean rented, Genre genre){
        super(title, ISBN, author, price, publicationYear, rented, genre);
     }
    
}
