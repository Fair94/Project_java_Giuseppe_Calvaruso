import giuseppecalvaruso.domain.Book;
import giuseppecalvaruso.exception.InputError;
import giuseppecalvaruso.factory_file.book_factory;
import giuseppecalvaruso.factory_file.standard_book_factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;


/**This is the test file for the Factory Pattern for the book. 
 * I've tested:
 * - Empty or invalid title
 * - Empty or invalid ISBN
 * - Empty or invalid author
 * - 0  or negative number
 */
public class StandardBookFactoryTest {

    private final book_factory factory = new standard_book_factory();
   /**
    * Creating book test
    */
    @Test
    public void CreatingBook(){
        Book test = factory.createBook("La leggenda di Drizzt", "987-654-33-22-11", "R.A Salvador", 1499,1990);
        assertEquals("La leggenda di Drizzt", test.getTitle());
        assertEquals("987-654-33-22-11",test.getISBN());
        assertEquals("R.A Salvador", test.getAuthor());
        assertEquals(1499, test.getPrice());
        assertFalse(test.isRented());
    }
    /**
     * empty or invalid Title 
     * 
     */
    @Test
    public void emptyTitle(){
       book_factory factory = new standard_book_factory();
       try{
        factory.createBook("", "ISBN", "author", 1111,1950);
        fail("No input error launched");
       } catch(InputError e){
        assertEquals("Empty or invalid  title, please check again", e.getMessage());
       }
    }

    /**
     * Empty or invalid ISBN
     */

     @Test
    public void emptyISBN(){
       book_factory factory = new standard_book_factory();
       try{
        factory.createBook("title", "", "author", 1111,1950);
        fail("No input error launched");
       } catch(InputError e){
        assertEquals("Empty or Invalid ISBN, pleas check again", e.getMessage());
       }
    }


    /**
     * Empty or invalid author
     */

     @Test
    public void emptyAuthor(){
       book_factory factory = new standard_book_factory();
       try{
        factory.createBook("title", "ISBN", "", 1111,1950);
        fail("No input error launched");
       } catch(InputError e){
        assertEquals("Empty or Invalid authro,please chek again ", e.getMessage());
       }
    }

    /**
     * 0 or negative Price
     */
     @Test
    public void invalidPrice(){
       book_factory factory = new standard_book_factory();
       try{
        factory.createBook("title", "ISBN", "author", -50,1950);
        fail("No input error launched");
       } catch(InputError e){
        assertEquals("Please, insert a positive value ", e.getMessage());
       }
    }


     @Test
    public void invalidPublicationYear(){
       book_factory factory = new standard_book_factory();
       try{
        factory.createBook("title", "ISBN", "author", 1111,-150);
        fail("No input error launched");
       } catch(InputError e){
        assertEquals("Please, insert a positive value ", e.getMessage());
       }
    }

   

    
}
