package giuseppecalvaruso.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Composite element of the composite pattern
 * 
 * Rappresent a collection of rented books.
 */
public class rentedLibrary implements rentedLibraryComponent {
    private final List<rentedLibraryComponent> rentedBooks = new ArrayList<>();
    private static final Logger logger = Logger.getLogger(rentedLibrary.class.getName());


    /**
     * 
     * @param component  rented book to add
     */
    public void addingBook (rentedLibraryComponent component){

        if(component == null){
            logger.warning("Attempting in adding a null book");
            return;
        }
        rentedBooks.add(component);
        logger.info("Book added to rentedLibrary");

    }
    /**
     * 
     * @param component rented book to remove 
     */
    public void removingBook(rentedLibraryComponent component){
        if(component == null){
            logger.warning("Attempting to remove a null book");
            return;
        }
        rentedBooks.remove(component);
        logger.info("Book removed from rentedLibrary");

    }
    /**
     * 
     * @return the emptiness of the library
     */
    public boolean isEmpty(){
        return rentedBooks.isEmpty();
    }
    /**
     * printing the detail 
     */
    @Override
    public void print(){
        System.out.println("List of rented Books:");
    for (rentedLibraryComponent component : rentedBooks){
        try{
            component.print();
        } catch (Exception exception){
            logger.warning("Error in printing rentedBook" + exception.getMessage());
        }
    }
    }
    
}
