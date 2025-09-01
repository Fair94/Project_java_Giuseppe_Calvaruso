package giuseppecalvaruso.observer;

import java.util.logging.Logger;

import giuseppecalvaruso.factory_file.Book;

public class ObserverLogger implements LibraryObserver{
    private static final Logger logger = Logger.getLogger(ObserverLogger.class.getName());

    @Override
    public void update(String eventType, Book book) {

        logger.info("Event: " + "" + eventType +"" + book.getTitle() +"" + book.getISBN());
        
      
    }
    
}
