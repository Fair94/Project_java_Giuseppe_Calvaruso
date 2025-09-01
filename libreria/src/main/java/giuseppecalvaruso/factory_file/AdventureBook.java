package giuseppecalvaruso.factory_file;

public class AdventureBook extends AbstractBook{
    public AdventureBook(String title, String ISBN, String author, int price, int publicationYear,boolean rented, Genre genre){
        super(title, ISBN, author, price, publicationYear, rented, genre);
    }
}