package giuseppecalvaruso.composite;

import java.util.ArrayList;
import java.util.List;

public class rentedLibrary implements rentedLibraryComponent {
    private final List<rentedLibraryComponent> rentedBooks = new ArrayList<>();

    public void addingBook (rentedLibraryComponent component){
        rentedBooks.add(component);

    }

    public void removingBokk(rentedLibraryComponent component){
        rentedBooks.remove(component);

    }

    public boolean isEmpty(){
        return rentedBooks.isEmpty();
    }

    @Override
    public void print(){
        System.out.println("List of rented Books:");
    for (rentedLibraryComponent component : rentedBooks){
            component.print();
    }
    }
    
}
