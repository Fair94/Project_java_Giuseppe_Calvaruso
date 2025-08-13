package giuseppecalvaruso;

import java.util.Scanner;
import java.util.logging.Logger;

import giuseppecalvaruso.domain.Book;
import giuseppecalvaruso.exception.InputError;
import giuseppecalvaruso.factory_file.book_factory;
import giuseppecalvaruso.factory_file.standard_book_factory;
import giuseppecalvaruso.io.bookmanager;

/**
 * In the main I'm going to create the book, asking to operator the fields of the book and inserting it in a file 
 */

 /** 
 * @param title is for the title book
 * @param ISBN is for the identification number of the book
 * @param author is for the name of the book's author 
 * @param price is for the book's price
 * @param rented is a Boolean. If true the book is not in library. If false is in library 
 * @param Scanner is used to scan input  from the user 
 */

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            book_factory factory = new standard_book_factory();
            
            System.out.println("Welcome to the library");
            System.out.println("Please insert the requested field of the book");

            try{
                System.out.println("Title: ");
                String title = input.nextLine();

                System.out.println("ISBN: ");
                String ISBN = input.nextLine();

                System.out.println("Author: ");
                String author = input.nextLine();

                System.out.println("Price: ");
                int price = Integer.parseInt(input.nextLine());

                System.out.println("Publication year: ");
                int publicationYear  =Integer.parseInt(input.nextLine());

                Book book = factory.createBook(title, ISBN, author, price,publicationYear);
                System.out.println("Book created succesfully");
                System.out.println("Title: " + book.getTitle() + "ISBN: " + book.getISBN() + "Author: " + book.getAuthor() + "Price: " + book.getPrice() + "Publication Year: " + book.getPublicationYear());
                logger.info("The book was created succesfully");
                bookmanager.saveBook(book);

            }
     

            

            catch (NumberFormatException error){
                System.out.println("Please, insert a valid price for the book");
                logger.warning("There's a problem in the number format, check testing with 0, number or negative number"+ error.getMessage());

            }
            catch (InputError error){

                System.out.println("Error in book's field, try again");
                logger.severe("Input Error, it's a severe problem to fix as soon as possible "+ error.getMessage());
            }
            catch(Exception error){
                System.out.println("Generic error, please contact support");
                logger.severe("Exception non handled, fix as soon as possible" + error.getMessage());
                

            }
        }
      
    }
}