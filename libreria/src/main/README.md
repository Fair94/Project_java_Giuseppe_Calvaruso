 # LIBRARY MANAGEMENT APP
 This is a simple library management app built with java.It was built form my Objected Oriented Programming exam, following the examinator's instructions.  
 
 #OVERVIEW
This is simple management system built for library's owner. 
The books are saved in mocked "database". I've used a txt file. 
Through a simple menu, it permit the user to choose the option. 

#TECHNOLOGIES AND PATTERN
PATTERN (REQUIRED)    

1)Factory  
2)Composite  
3)Iterator  
4)Exception Shielding  

PATTERN (OPTIONAL)  
1)Facade

TECHNOLIGIES(REQUIRED)  

1)Collection Frameworks  
2)Generics  
3)Java I/O  
4)Logging  
5)JUnit Testing (Maven)

#TECHNOLOGIES AND PATTERN: EXPLANATION  
-FACTORY PATTERN -  
I've used this pattern to abstract the creational process of the book. I've setted up some field, such as title and author and i've used them as a mold to create other books. 

CREATOR (interface): "book_factory.java" exposes "createBook()" method   

PRODUCT(interface): "book.java" rapresents a generic book with all the field. 

CONCRETE PRODUCT: "AdventureBook.java" or other types of book,  rapresents the specific type of the Book.

CONCRETE CREATOR: "standard_book_factory.java" rapresents the real logic to create and validate any concrete product. 

![Factory Pattern](./libreria/src/main/diagrams/Factory_Pattern.png)




