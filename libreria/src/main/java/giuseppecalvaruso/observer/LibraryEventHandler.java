package giuseppecalvaruso.observer;

import java.util.ArrayList;
import java.util.List;

import giuseppecalvaruso.domain.Book;

public class LibraryEventHandler {

    private final List<LibraryObserver> observers = new ArrayList<>();

    public void subscribe(LibraryObserver observer){
        observers.add(observer);
    }

    public void unsubscribe(LibraryObserver observer){
        observers.remove(observer);
    }

    public void notify(String eventType, Book book){
        for(LibraryObserver observer : observers)
        observer.update(eventType,book);
        
    }


}
