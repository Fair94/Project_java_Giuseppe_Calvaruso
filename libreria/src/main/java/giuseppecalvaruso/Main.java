package giuseppecalvaruso;

import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;

import giuseppecalvaruso.exception.Exception_Shield;
import giuseppecalvaruso.menu.Facade;
import giuseppecalvaruso.menu.Mainmenu;



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
                

                    if(parsedUserChoiche<1 || parsedUserChoiche>8){
                        System.out.println("Incorrect choice, choose between 1 and 8");
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

                        case RENT_BOOK:
                            msg = Exception_Shield.thePolice(()->facade.rentBook(), logger, "Trying to rent a book");
                            break;

                        case RETURN_BOOK:
                            msg = Exception_Shield.thePolice(()->facade.returnBook(), logger, "Trying to return a book");
                            break;

                        case SORT_BOOK:
                            msg = Exception_Shield.thePolice(()->facade.sortingBooks(), logger, "Trying to sort a book");
                            break;    
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
            
