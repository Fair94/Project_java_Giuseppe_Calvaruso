package giuseppecalvaruso.observer;

import java.util.ArrayList;
import java.util.List;

import giuseppecalvaruso.factory_file.Book;

public class LibraryEventHandler implements LibrarySubject {

    private final List<LibraryObserver> observers = new ArrayList<>();


    @Override
    public void subscribe(LibraryObserver observer){
        observers.add(observer);
    }
    @Override
    public void unsubscribe(LibraryObserver observer){
        observers.remove(observer);
    }

    @Override
    public void notify(String eventType, Book book){
        for(LibraryObserver observer : observers)
        observer.update(eventType,book);
        
    }

    

}
