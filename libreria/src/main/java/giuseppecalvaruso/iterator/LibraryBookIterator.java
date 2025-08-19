package giuseppecalvaruso.iterator;

import java.util.List;

import giuseppecalvaruso.domain.Book;

public class LibraryBookIterator implements BooksIterator {
    private final List<Book> books;
    private int index = 0;

    public LibraryBookIterator(List<Book> books){

        this.books = books;
    }

    @Override
    public boolean hasNext(){
        return index < books.size();

    }

    @Override
    public Book next() {

        Book book = books.get(index);
        index++;
        return book ;
       
    }
    
}
