package giuseppecalvaruso.menu;

public enum Mainmenu {
    ADDING_BOOK,
    LISTING_BOOKS,
    EXIT;



  public static void Menu(){
    System.out.println("======= MAIN MENU ======");
    System.out.println("1) Add a book");
    System.out.println("2) View list of book");
    System.out.println("3) Exit");
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
        
        default:
            return null;

    }
  }
}
