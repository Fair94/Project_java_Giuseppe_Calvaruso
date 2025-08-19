package giuseppecalvaruso.iterator;

import java.util.ArrayList;
import java.util.List;

import giuseppecalvaruso.domain.Book;
import giuseppecalvaruso.io.bookmanager;

public class Library implements BooksCollection {
        private final List<Book> books;

        public Library(){
            this.books = new ArrayList<>(bookmanager.loadingBooks());
        }
    

        public BooksIterator createIterator(){
            return new LibraryBookIterator(books);

        }
}
