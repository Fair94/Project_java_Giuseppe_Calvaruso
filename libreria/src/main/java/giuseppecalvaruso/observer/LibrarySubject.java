package giuseppecalvaruso.observer;

import giuseppecalvaruso.factory_file.Book;

public interface LibrarySubject {
    void subscribe(LibraryObserver observer);
    void unsubscribe(LibraryObserver observer);
    void notify(String eventType, Book book);
}
