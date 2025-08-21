import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import giuseppecalvaruso.menu.Mainmenu;

public class MainMenuTest {

    @Test
    void validChoices(){
        assertEquals(Mainmenu.ADDING_BOOK, Mainmenu.number(1));
        assertEquals(Mainmenu.LISTING_BOOKS, Mainmenu.number(2));
        assertEquals(Mainmenu.EXIT,Mainmenu.number(3));
        assertEquals(Mainmenu.SHOW_RENTED, Mainmenu.number(4));
        assertEquals(Mainmenu.SHOW_BY_GENRE, Mainmenu.number(5));
    }
    void InvalidChoices(){
        assertNull(Mainmenu.number(0));
        assertNull(Mainmenu.number(11));
        assertNull(Mainmenu.number(-100));

    }
}
