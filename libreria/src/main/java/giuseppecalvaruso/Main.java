package giuseppecalvaruso;

import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;

import giuseppecalvaruso.exception.Exception_Shield;
import giuseppecalvaruso.menu.Facade;
import giuseppecalvaruso.menu.Mainmenu;

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
            Facade facade = new Facade(input);

            while(true){
                Mainmenu.Menu();
                String userChoice = input.nextLine();
                

                try{
                    int parsedUserChoiche = Integer.parseInt(userChoice);
                

                    if(parsedUserChoiche<1 || parsedUserChoiche>5){
                        System.out.println("Incorrect choice, choose between 1 and 5");
                        logger.log(Level.WARNING,"Out of range choice"+ parsedUserChoiche);
                        continue;
                    }
                    Mainmenu choice = Mainmenu.number(parsedUserChoiche);
                    if(choice == null){
                        System.out.println("Invalid choice, retry");
                        logger.log(Level.WARNING,"Null choice" + parsedUserChoiche);
                        continue;
                    }

                   String msg = null;
                   switch(choice){
                        case ADDING_BOOK:
                            msg = Exception_Shield.thePolice(()->facade.AddingBook(),logger,"Adding book function");
                            break;
                        
                        case LISTING_BOOKS:
                            msg = Exception_Shield.thePolice(()->facade.ListingBooks(),logger,"Printing book function");
                            break;
                        
                        case SHOW_RENTED:
                            msg = Exception_Shield.thePolice(()->facade.showRentedLibrary(),logger,"Printing rented book function");
                            break;
                        
                        case SHOW_BY_GENRE:
                            msg = Exception_Shield.thePolice(()->facade.printForGenre(),logger,"Printing  book by genre function");
                            break;
                        
                        case EXIT:
                            msg = Exception_Shield.thePolice(()->facade.exit(),logger,"Quitting function");
                            System.out.println("Closing app. Have a nice day");
                            return;
                    }
                    
                    if(msg!= null){
                        System.out.println(msg);
                    }else {
                        logger.info("Mission" + choice +  "completed") ;
                    }
                } catch(NumberFormatException error){
                    System.out.println("Please, insert a valid number");
                    logger.log(Level.WARNING,"Input error" + error.getMessage());
                }
            }
        }
    }
}
            
