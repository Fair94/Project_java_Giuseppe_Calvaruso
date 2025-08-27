package giuseppecalvaruso.gui;

import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.GridLayout;

import giuseppecalvaruso.menu.Facade;

public class GraphicInterface {
    public static void startGraphic(){
        Scanner scanner = new Scanner(System.in);
        Facade facade = new Facade(scanner);

        JFrame window = new JFrame("My first library app");
        window.setSize(500,500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new GridLayout (0,1,10,10));

        JButton addBook = new JButton("Add a Book");
        JButton viewListBooks = new JButton("List of Books");
        JButton exit = new JButton("Exit");
        JButton showRentedBooks = new JButton("List of rented Books");
        JButton showBooksbyGenre = new JButton("Books for genre");
        JButton rentABook = new JButton("Rent");
        JButton returnABook = new JButton("Return");

        addBook.addActionListener(e->facade.AddingBook());

        viewListBooks.addActionListener(e->facade.ListingBooks());

        exit.addActionListener(e->{facade.exit();
                                System.exit(0);});

        showRentedBooks.addActionListener(e->facade.showRentedLibrary());

        showBooksbyGenre.addActionListener(e->facade.printForGenre());

        rentABook.addActionListener(e->facade.rentBook());

        returnABook.addActionListener(e->facade.returnBook());

        window.add(addBook);
        window.add(viewListBooks);
        window.add(showRentedBooks);
        window.add(showBooksbyGenre);
        window.add(rentABook);
        window.add(returnABook);
        window.add(exit);


        window.setVisible(true);



    }
    
}
