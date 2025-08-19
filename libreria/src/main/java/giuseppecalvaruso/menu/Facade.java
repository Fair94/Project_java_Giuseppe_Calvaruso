package giuseppecalvaruso.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import giuseppecalvaruso.composite.rentedBook;
import giuseppecalvaruso.composite.rentedLibrary;
import giuseppecalvaruso.domain.Book;
import giuseppecalvaruso.domain.Genre;
import giuseppecalvaruso.exception.InputError;
import giuseppecalvaruso.factory_file.book_factory;
import giuseppecalvaruso.factory_file.standard_book_factory;
import giuseppecalvaruso.io.bookmanager;
import giuseppecalvaruso.iterator.BooksIterator;
import giuseppecalvaruso.iterator.Library;
import giuseppecalvaruso.utility.printForGenre;

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

                System.out.println("Genre:(ADVENTURE, FANTASY, HORROR, SCI_FI, ROMANCE, HISTORY, OTHER) ");
                String g = input.nextLine();
                Genre genre;
                try{
                    genre = Genre.valueOf(g.trim().toUpperCase());
                }catch(Exception exception){
                    genre = Genre.OTHER;


                }


                Book book = factory.createBook(title, ISBN, author, price,publicationYear,genre);
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
           Library library = new Library();
           BooksIterator iterator = library.createIterator();
           
           if(!iterator.hasNext()){
            System.out.println("No books in collection");
           }

           while(iterator.hasNext()){
            Book book = iterator.next();
            System.out.printf("%s | %s | %s | %d$ | %d\n",
            book.getTitle(),
            book.getAuthor(),
            book.getISBN(),
            book.getPrice(),
            book.getPublicationYear()
            );
           }


        }


        public void showRentedLibrary(){
            List<Book> fullLibrary = bookmanager.loadingBooks();
            rentedLibrary rented = new rentedLibrary();

            for(Book b : fullLibrary){
                if (b.isRented()){
                    rented.addingBook(new rentedBook(b));
                }
            }
            if(rented.isEmpty()){
                System.out.println("No rented Books");
        } else {

            rented.print();
        }
    }


        public void printForGenre(){
            System.out.println("Insert genre: \n - ADVENTURE \n - FANTASY \n - HORROR \n - SCI_FI \n - ROMANCE \n - HISTORY \n - OTHER \n");
            String choice = input.nextLine();
            Genre genre;
            try{
                genre = Genre.valueOf(choice.trim().toUpperCase());
            } catch(Exception error){
                System.out.println("Invalid genre. Switching to OTHER");
                genre = Genre.OTHER;
            }

            List<Book> allBooks = bookmanager.loadingBooks();
            List<Book> forGenre = new ArrayList<>();

            for (Book b : allBooks){
                if (b.getGenre() == genre){
                    forGenre.add(b);
                }
            }
            if (forGenre.isEmpty()){
                System.out.println("No book found for genre: "+ genre);
            }else{
                printForGenre<Book> print = new printForGenre<>();
                print.print(forGenre);
            }
        }
        

        

        public void exit(){
            System.out.println("Thanks for using our service. Have a nice day");
        }

    }
    

