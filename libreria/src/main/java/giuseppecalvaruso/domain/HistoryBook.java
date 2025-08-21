package giuseppecalvaruso.domain;

public class HistoryBook extends AbstractBook {
     public HistoryBook(String title, String ISBN, String author, int price, int publicationYear,boolean rented, Genre genre){
        super(title, ISBN, author, price, publicationYear, rented, genre);
    }
    
}
