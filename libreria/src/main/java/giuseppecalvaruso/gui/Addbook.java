// package giuseppecalvaruso.gui;

// import java.awt.GridLayout;

// import javax.swing.JButton;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import javax.swing.JOptionPane;
// import javax.swing.JTextField;

// import giuseppecalvaruso.exception.Exception_Shield;
// import giuseppecalvaruso.exception.InputError;
// import giuseppecalvaruso.menu.Facade;

// public class Addbook extends JFrame{

//     public Addbook(Facade facade){
//         super("Add a new book");
//         this.setSize(400,400);
//         this.setLayout(new GridLayout(0,2,5,5));

//         JLabel titleLabel = new JLabel("Title");
//         JTextField titleField = new JTextField();

//         JLabel ISBNLabel = new JLabel("ISBN");
//         JTextField ISBNfield = new JTextField();

//         JLabel AuthorLabel = new JLabel("Author");
//         JTextField AuthorField = new JTextField();

//         JLabel PriceLabel = new JLabel("Price");
//         JTextField PriceField = new JTextField();

//         JLabel YearLabel = new JLabel("Publication Year");
//         JTextField YearField = new JTextField();

//         JLabel GenreLabel = new JLabel("Genre");
//         JTextField GenreField = new JTextField();

//         JButton ConfirmingButton = new JButton("Add Book");

//         this.add(titleLabel);
//         this.add(ISBNLabel);
//         this.add(AuthorLabel);
//         this.add(PriceLabel);
//         this.add(YearField);
//         this.add(GenreLabel);
//         this.add(ConfirmingButton);

//         ConfirmingButton.addActionListener(e->{
//             String Title = titleField.getText().trim();
//             String ISBN = ISBNLabel.getText().trim();
//             String Author = AuthorField.getText().trim();
//             String Price = PriceField.getText().trim();
//             String PublicationYear = YearField.getText().trim();
//             String Genre = GenreField.getText().trim();

//             String operation  = Exception_Shield.thePolice(()->{
//             if( Title.isEmpty()||
//                 ISBN.isEmpty()||
//                 Author.isEmpty()||
//                 Price.isEmpty()||
//                 PublicationYear.isEmpty()||
//                 Genre.isEmpty()){
//                     throw new InputError("One or more fields are empty");
//                     }
//                 //Need to add a method on facade in order to take this var
//                 // facade.AddingBook(Title,ISBN,Author,Price,PublicationYear,Genre);
            

//         });




        
//     }
    
// }
