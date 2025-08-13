package giuseppecalvaruso.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import giuseppecalvaruso.domain.Book;

/**This is the class file I'm using to mockup a book database. */
public class bookmanager {

    private static final String FileName = "booksdatabase.txt";
    private static final Logger logger = Logger.getLogger(bookmanager.class.getName());


    public static void saveBook(Book book){
        try(FileWriter writeBook = new FileWriter(FileName,true);
            PrintWriter printBook = new PrintWriter(writeBook)){
            String bookLine = String.format("Title: %s | Author: %s | ISBN: %s | Price: %d  | Year: %d", book.getTitle(), book.getAuthor(), book.getISBN(),book.getPrice(),book.getPublicationYear());
            
            logger.info("Book writed succesfully");
            printBook.println(bookLine);

        } catch(IOException error){
            logger.severe("Failed to write the book in file "+ error.getMessage());
        }

        
    }
    
}
