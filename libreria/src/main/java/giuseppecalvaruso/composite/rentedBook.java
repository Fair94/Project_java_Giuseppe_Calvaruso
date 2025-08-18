package giuseppecalvaruso.composite;

import giuseppecalvaruso.domain.Book;

public class rentedBook implements rentedLibraryComponent {
    private final Book book;

    public rentedBook(Book book){
        this.book = book;
    }

    @Override
    public void print(){
        System.out.printf("- %s | %s |s %d$ | %d\n;", 
        book.getTitle(),
        book.getAuthor(),
        book.getISBN(),
        book.getPrice(),
        book.getPublicationYear());


    }
    
    
}
