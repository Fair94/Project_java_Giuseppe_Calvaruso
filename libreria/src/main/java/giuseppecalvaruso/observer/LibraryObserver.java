package giuseppecalvaruso.observer;

import giuseppecalvaruso.factory_file.Book;

public interface LibraryObserver {
    void update(String eventType,Book book);
    }
