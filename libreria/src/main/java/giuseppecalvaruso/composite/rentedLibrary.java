package giuseppecalvaruso.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
public class rentedLibrary implements rentedLibraryComponent {
    private final List<rentedLibraryComponent> rentedBooks = new ArrayList<>();
    private static final Logger logger = Logger.getLogger(rentedLibrary.class.getName());

    public void addingBook (rentedLibraryComponent component){

        if(component == null){
            logger.warning("Attempting in adding a null book");
            return;
        }
        rentedBooks.add(component);
        logger.info("Book added to rentedLibrary");

    }

    public void removingBook(rentedLibraryComponent component){
        if(component == null){
            logger.warning("Attempting to remove a null book");
            return;
        }
        rentedBooks.remove(component);
        logger.info("Book removed from rentedLibrary");

    }

    public boolean isEmpty(){
        return rentedBooks.isEmpty();
    }

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
