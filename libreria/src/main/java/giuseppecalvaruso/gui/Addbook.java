package giuseppecalvaruso.gui;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import giuseppecalvaruso.menu.Facade;

public class Addbook extends JFrame{

    public Addbook(Facade facade){
        super("Add a new book");
        this.setSize(400,400);
        this.setLayout(new GridLayout(0,2,5,5));

        JLabel titlelLabel = new JLabel("Title");
        JTextField titleField = new JTextField();

        JLabel ISBNLabel = new JLabel("ISBN");
        JTextField ISBNfield = new JTextField();

        JLabel AuthorLabel = new JLabel("Author");
        JTextField AuthorField = new JTextField();

        


        
    }
    
}
