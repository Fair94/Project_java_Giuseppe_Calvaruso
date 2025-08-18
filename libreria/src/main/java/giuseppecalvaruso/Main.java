package giuseppecalvaruso;

import java.util.Scanner;
import java.util.logging.Logger;
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
                    Mainmenu selection = Mainmenu.number(parsedUserChoiche);

                    if(selection == null){
                        System.out.println("Incorrect choice, try again");
                        continue;
                    }

                    switch (selection) {
                        case ADDING_BOOK:
                            facade.AddingBook();
                            break;
                        case LISTING_BOOKS:
                            facade.ListingBooks();

                        case SHOW_RENTED:
                            facade.showRentedLibrary();
                            break;

                        case SHOW_BY_GENRE:
                            facade.printForGenre();
                            break;
                        
                        case EXIT:
                            facade.exit();
                            return;
                    }
                    
                

            } catch (NumberFormatException error){
                System.out.println("Please, insert a valid choice");
                logger.warning("Check the logic, invalid menu input "+ error.getMessage());
            }
        }
    }
}
}