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
    

