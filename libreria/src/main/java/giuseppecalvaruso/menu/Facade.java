package giuseppecalvaruso.menu;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import giuseppecalvaruso.domain.Book;
import giuseppecalvaruso.exception.InputError;
import giuseppecalvaruso.factory_file.book_factory;
import giuseppecalvaruso.factory_file.standard_book_factory;
import giuseppecalvaruso.io.bookmanager;

public class Facade {
    private static final Logger logger = Logger.getLogger(Facade.class.getName());
    private final Scanner input;
    private final book_factory factory;

    public Facade(Scanner input){
        this.input = input;
        this.factory = new standard_book_factory();

    }
    
    public void AddingBook(){

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

        public void ListingBooks(){
            List <Book> books = bookmanager.loadingBooks();
            if(books.isEmpty()){
                System.out.println("The library is empty");
            } else{
                System.out.println("Printing books in library ");
                for (Book book : books){
                    System.out.printf("- %s | %s | %s | %d€ | %d\n",
                    book.getTitle(),
                    book.getAuthor(),
                    book.getISBN(),
                    book.getPrice(),
                    book.getPublicationYear());
                }
            }


        }

        public void exit(){
            System.out.println("Thanks for using our service. Have a nice day");
        }

    }
    

