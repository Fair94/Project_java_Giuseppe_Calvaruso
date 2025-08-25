package giuseppecalvaruso.menu;

/**
 * Avaiable option in the menu, handled by the facade. 
 */
public enum Mainmenu {
    ADDING_BOOK,
    LISTING_BOOKS,
    EXIT,
    SHOW_RENTED, 
    SHOW_BY_GENRE,
    RENT_BOOK,
    RETURN_BOOK;



  public static void Menu(){

    /**
     * Printing main menu
     */
    System.out.println("======= MAIN MENU ======");
    System.out.println("1) Add a book");
    System.out.println("2) View list of book");
    System.out.println("3) Exit");
    System.out.println("4)Show rented books");
    System.out.println("5)Show books by genre");
    System.out.println("6)Rent a book");
    System.out.println("7)Returning book");
    System.out.println("Insert your choice");
  }

  public static Mainmenu number(int choose){

    switch(choose){
        case 1:
            return ADDING_BOOK;

        case 2:
            return LISTING_BOOKS;

        case 3:
            return EXIT;

        case 4:
          return SHOW_RENTED;

        case 5:
        return  SHOW_BY_GENRE;

        case 6:
        return RENT_BOOK;

        case 7:
        return RETURN_BOOK;
        
        default:
            return null;

    }
  }
}
