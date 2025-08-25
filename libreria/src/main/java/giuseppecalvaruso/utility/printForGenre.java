package giuseppecalvaruso.utility;
import java.util.List;
import java.util.logging.Logger;

/**
 * Utility class to print elements by genre(books)
 */
public class printForGenre<T> {

    private static final Logger logger = Logger.getLogger(printForGenre.class.getName());

    /**
     * Prints elements of given list 
     * @param genreList printing list to the console 
     */
    public void  print(List<T> genreList){
            if(genreList == null){
                logger.warning("Genre list is null");
                System.out.println("Nothing to show");
                return;
            }

            if (genreList.isEmpty()){
                logger.info("Genre list is empty");
                System.out.println("No books to show");
                return;

            }
            for (T item : genreList){
                System.out.println(item);

            }

            logger.info("Printed " + genreList.size() + "books");

        

    }
    
}
