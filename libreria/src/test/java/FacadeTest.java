import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import giuseppecalvaruso.exception.InputError;
import giuseppecalvaruso.menu.Facade;

public class FacadeTest {
    @Test
    void emptyTitle(){
        String fakeInput ="\n12345\nAuthor\n10\n2000\nADVENTURE\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(fakeInput.getBytes()));
        Facade facade = new Facade(scanner);
        assertThrows(InputError.class,()->facade.AddingBook());
    }

    @Test
    void negativePrice(){
        String fakeInput = "Title\n12345\nAuthor\n-10\n2000\nADVENTURE\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(fakeInput.getBytes()));
        Facade facade = new Facade(scanner);
        assertThrows(InputError.class,()->facade.AddingBook());
    }

    @Test 
    void validInput(){
        String fakeInput = "Title\n12345\nAuthor\n10\n2000\nADVENTURE\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(fakeInput.getBytes()));
        Facade facade = new Facade(scanner);
        assertDoesNotThrow(()->facade.AddingBook());
    
    
}

}
