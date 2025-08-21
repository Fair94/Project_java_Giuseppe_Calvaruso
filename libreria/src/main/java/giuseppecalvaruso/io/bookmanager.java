package giuseppecalvaruso.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import java.io.File;
import java.io.FileNotFoundException;
import giuseppecalvaruso.domain.Genre;
import giuseppecalvaruso.exception.Exception_Shield;
import giuseppecalvaruso.factory_file.book_factory;
import giuseppecalvaruso.factory_file.standard_book_factory;
import giuseppecalvaruso.domain.AdventureBook;
import giuseppecalvaruso.domain.Book;

/**This is the class file I'm using to mockup a book database. */
public class bookmanager {

    private static final String FileName = "booksdatabase.txt";
    private static final Logger logger = Logger.getLogger(bookmanager.class.getName());
    private static final book_factory factory = new standard_book_factory();


    public static void saveBook(Book book){
        Exception_Shield.thePolice(() ->{
        try(FileWriter writeBook = new FileWriter(FileName,true);
            PrintWriter printBook = new PrintWriter(writeBook)){
            String bookLine = String.format("Title: %s | Author: %s | ISBN: %s | Price: %d  | Year: %d | Genre: %s", 
            book.getTitle(),
            book.getAuthor(),
            book.getISBN(),
            book.getPrice(),
            book.getPublicationYear(),
            book.getGenre()== null?"OTHER":book.getGenre().name());
            
            logger.info("Book writed succesfully");
            printBook.println(bookLine);
            }
        } ,logger,"Saving book into file");
        // catch(IOException error){
        //     logger.severe("Failed to write the book in file "+ error.getMessage());
        

        
    }
    


public static List<Book> loadingBooks(){
    List<Book> books = new ArrayList<>();
    
    
    try(Scanner databaseScanner = new Scanner(new File("booksdatabase.txt"))){
         while (databaseScanner.hasNextLine()){
            String line = databaseScanner.nextLine();

            try{
                String[] bookStringParts = line.split("\\|");

                String title = bookStringParts[0].split(":")[1].trim();
                String author = bookStringParts[1].split(":")[1].trim();
                String isbn = bookStringParts[2].split(":")[1].trim();
                int price = Integer.parseInt(bookStringParts[3].split(":")[1].trim());
                int year = Integer.parseInt(bookStringParts[4].split(":")[1].trim());
                String genreString  = bookStringParts[5].split(":")[1].trim();
                Genre genre = Genre.valueOf(genreString.toUpperCase());


                Book book = new AdventureBook(title, isbn, author, price, year, false,genre);
                books.add(book);

            } catch (Exception error){
                logger.warning("Error parsing line : "+ line);
            }
        }

         } catch (FileNotFoundException error){

            logger.severe("File not found, please quick as soon as possible "+ error.getMessage());


         }

         return books;



    }


}
