import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;

import org.junit.jupiter.api.Test;

import giuseppecalvaruso.utility.printForGenre;

public class print_for_genre_test {

    private final printForGenre<String> printer = new printForGenre<>();

    @Test
    public void nullList(){
        assertDoesNotThrow(()-> printer.print(null));
    }

    @Test 
    public void emptyList(){
        assertDoesNotThrow(()->printer.print(List.of()));
    }

    @Test

    public void validList(){
        assertDoesNotThrow(()->printer.print(List.of("Fantasy","Adventure")));
    }
    
}
