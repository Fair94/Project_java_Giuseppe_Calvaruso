package giuseppecalvaruso.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import annotations.MenuOption;
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
import giuseppecalvaruso.observer.LibraryEventHandler;
import giuseppecalvaruso.observer.ObserverLogger;
import giuseppecalvaruso.observer.StatusObsver;
import giuseppecalvaruso.strategy.AuthorSorting;
import giuseppecalvaruso.strategy.PriceSorting;
import giuseppecalvaruso.strategy.SortingContext;
import giuseppecalvaruso.strategy.TitleSorting;
import giuseppecalvaruso.strategy.YearSorting;
import giuseppecalvaruso.utility.printForGenre;


/**
 * The Facade class is the point of contact between user and app's logic.
 */
public class Facade {
    private static final Logger logger = Logger.getLogger(Facade.class.getName());
    private final Scanner input;
    private final book_factory factory;
    private final LibraryEventHandler eventHandler = new LibraryEventHandler();

    public Facade(Scanner input){
        this.input = input;
        this.factory = new standard_book_factory();
        eventHandler.subscribe(new ObserverLogger());
        eventHandler.subscribe(new StatusObsver());

    }
    
    /**
     * Allows user to add a book.
     * Read iunput from console, validates fields and saves books.
     * @throws InputError if some info are missing
     */
    @MenuOption(label = "Add Book", index = 1 )
    public void AddingBook(){

        
                System.out.println("Title: ");
                String title = input.nextLine().trim();

                System.out.println("ISBN: ");
                String ISBN = input.nextLine().trim();

                System.out.println("Author: ");
                String author = input.nextLine().trim();

                System.out.println("Price: ");
                String sprice = input.nextLine().trim();

                System.out.println("Publication year: ");
                String year = input.nextLine().trim();

                System.out.println("Genre:(ADVENTURE, FANTASY, HORROR, SCI_FI, ROMANCE, HISTORY, OTHER) ");
                String g = input.nextLine();


                if(title.isEmpty() || author.isEmpty() || ISBN.isEmpty()){
                    logger.warning("Mandatory fields are missing, check again (author, title, ISBN)");
                    throw new InputError("Missing mandatory fields");
                }

                int price,publicationYear;

                try{
                    price = Integer.parseInt(sprice);
                    publicationYear = Integer.parseInt(year);
                } catch(NumberFormatException error){
                    logger.warning("Invalid format for price/publicationYear");
                    throw new InputError("Invalid number for price or publication year");
                }

                if (price <0){
                    logger.info("negative number"+ price);
                    throw new InputError("Price cannot be less than 0");
                }

                if (publicationYear< 1400 || publicationYear> 2100){
                    logger.warning("Out of range year"+ publicationYear);
                    throw new InputError("Invalid publication year");
                }
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
     

            

            
            
          
        
    @MenuOption(label = "List Books", index = 2)
        public void ListingBooks(){
           Library library = new Library();
           BooksIterator iterator = library.createIterator();
           
           if(!iterator.hasNext()){
            System.out.println("No books in collection");
            logger.info("Empty library");
            return;
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

    @MenuOption(label = "Show rented", index = 4 ,enabled = true)
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
                logger.info("No rented books");
        } else {

            rented.print();
            logger.info("showing rented library");
        }
    }

    @MenuOption(label = "Printing for genre", index = 5)
        public void printForGenre(){
            System.out.println("Insert genre: \n - ADVENTURE \n - FANTASY \n - HORROR \n - SCI_FI \n - ROMANCE \n - HISTORY \n - OTHER \n");
            String choice = input.nextLine();
            Genre genre;
            try{
                genre = Genre.valueOf(choice.trim().toUpperCase());
            } catch(Exception error){
                logger.warning("Invalid genre"+ choice + "fallback to OTHER");
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
        

        
    @MenuOption(label = "Exit", index = 3)
        public void exit(){
            System.out.println("Thanks for using our service. Have a nice day");
        }

    @MenuOption(label = "renting", index = 6)
        public void rentBook(){
            System.out.println("Please, insert the ISBN to rent");
            String isbn = input.nextLine().trim();

            if(isbn.isEmpty()){
                System.out.println("Invalid ISBN");
                logger.warning("Empty ISBN");
                return;
            }

             List<Book> allBooks = bookmanager.loadingBooks();
        for(Book b : allBooks){
            if(b.getISBN().equals(isbn)){
                if(b.isRented()){
                    System.out.println("Book is already rented");
                    logger.info("Tried to rent an already rented book");
                }else{
                    b.setRented(true);
                    System.out.println("Book rented succesfully");
                    logger.info("Book rented with isbn "+ isbn);
                    eventHandler.notify("rent",b);
                }
                return ;
            }
        }
        System.out.println("Book not in list");
        logger.warning("ISBN not found in library");
     }

    @MenuOption(label = "returning", index = 7)
     public void returnBook(){

        System.out.println("Enter the ISBN");
        String isbn = input.nextLine().trim();

        if(isbn.isEmpty()){
            System.out.println("Empty ISBN");
            logger.warning("Empty ISBN");
            return;
        }

        List<Book> allBooks = bookmanager.loadingBooks();
        for(Book b: allBooks){
            if(b.getISBN().equals(isbn)){
                if(!b.isRented()){
                    System.out.println("Book not rented");
                    logger.info("Book not rented.");
                }
                return;
            }
            else{
            b.setRented(false);
            System.out.println("Book returned");
            logger.info("Returned book with isbn"+ isbn);
            eventHandler.notify("return",b);
        }
        } 
        System.out.println("Book not found.");
        logger.warning("Isbn not found for this book");

     }

     /**Allowing user to sort the book using Strategy
      * Sort by Title,Price,Author, Publication Year
      */
      @MenuOption(label="Sorting", index = 8)
      public void sortingBooks(){
        List<Book> allBooks = bookmanager.loadingBooks();
        if(allBooks == null || allBooks.isEmpty()){
            logger.info("No books to sort");
            System.out.println("No books in library");
            return;
        }

        System.out.println("Choose sorting method:");
        System.out.println("1)Title");
        System.out.println("2)Author");
        System.out.println("3)Price");
        System.out.println("4)Publication Yeaer");

        String choice = input.nextLine().trim();
        SortingContext context = new SortingContext();

        try{
            switch(choice){
                case "1":
                context.setStrategy(new TitleSorting());
                break;

                case "2":
                context.setStrategy(new AuthorSorting());
                break;

                case "3":
                context.setStrategy(new PriceSorting());
                break;

                case "4":
                context.setStrategy(new YearSorting());
                break;

                default:
                logger.warning("Invalid choice"+ choice);
                System.out.println("Invalid choice, skipping sorting");
                return;
            }

            context.executing((allBooks));
            logger.info("Books sorted"+choice);

                System.out.println("SortedBooks");
                allBooks.forEach(System.out::println);
            
            } catch(Exception exception){
                logger.severe("Error in sorting book"+ exception.getMessage());
                System.out.println("An error occurred in sorting");
            }
        
      }

       
   

    }
    

