package giuseppecalvaruso.domain;

public class HorrorBook extends AbstractBook {
     public HorrorBook(String title, String ISBN, String author, int price, int publicationYear,boolean rented, Genre genre){
        super(title, ISBN, author, price, publicationYear, rented, genre);
    }
    
}
