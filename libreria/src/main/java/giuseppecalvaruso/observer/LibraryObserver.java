package giuseppecalvaruso.observer;

import giuseppecalvaruso.domain.Book;

public interface LibraryObserver {
    void update(String eventType,Book book);
    }
