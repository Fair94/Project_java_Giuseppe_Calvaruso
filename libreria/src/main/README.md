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
#PATTERN
-FACTORY PATTERN -  
I've used this pattern to abstract the creational process of the book. I've setted up some field, such as title and author and i've used them as a mold to create other books. 

CREATOR (interface): "book_factory.java" exposes "createBook()" method   

PRODUCT(interface): "book.java" rapresents a generic book with all the field. 

CONCRETE PRODUCT: "AdventureBook.java" or other types of book,  rapresents the specific type of the Book.

CONCRETE CREATOR: "standard_book_factory.java" rapresents the real logic to create and validate any concrete product. 

![Factory Pattern](diagrams/Factory_Pattern.png)  

-COMPOSITE PATTERN-  
I've introduced the composite pattern to manage the library in 2 distinct section: rented and not rented.  
In this way user can manage the library and see which book is Rented.

COMPONENT (interface): "rentedLibraryComponent.java" grant common print operation both for book and library.  
  
LEAF :"rentedBook.java" represent single book. Implements COMPONENT to print the detail of the book.

COMPOSITE: "rentedLibrary.java" store a list of COMPONENT. It can add book and print the list.  

![Composite Pattern](diagrams/COMPOSITE_PATTERN.png)  

-ITERATOR PATTERN-  
I've used the iterator pattern to hide the internal status of my app.
The user, through the FACADE does not know the list of the book.  

ITERATOR: "BooksIterator.java". It has two methods that work on the list of the book.

CONCRETE ITERATOR: "LibraryBookIterator.java". Implements ITERATOR and gave an index to the books.

AGGREGATE: "BooksCollection.java". Has a list of the book and apply to it The CONCRETE ITERATOR  

CONCRETE AGGREGATE: "Library.java". Implements AGGREGATE and gave an iterator to the list. 

![Iterator Pattern](diagrams/ITERATOR_PATTERN.png)  
-EXCEPTION SHIELDING-  

With Exception shielding I'm protecting the system/app from leak. I'm protecting internal stake and hiding it to the user and external client.
In this way, I reduce possibly hacker attack. 

CLIENT: "Main.java", "Facade.java" and many other files interact with user.

SERVICE:"standard_book_factory.java", "bookmanager.java" and many other file can generate exception

EXCEPTION SHIELDING HANDLER: "Facade.java" and many other files catch this exception and shows only logger info.  
![Excheption Shielding Pattern](diagrams/EXCEPTION_SHIELDING_PATTERN.png)  
-FACADE-  
I emplemented FACADE PATTERN because I was going crazy with the functionality of the app. 
With FACADE I create a menu and for every choice there was a subsystem associated (the diagram is not exausistive),
Generally the FACADE  gave a simple interface to the user and do not expose internal functionality

FACADE : "Facade.java" gave to the Main simple method 

SUBSYSTEM: The various subsystem gave function to my app 


![Facade Pattern](diagrams/FACADE_PATTERN.png) 

#TECHNOLOGIES  
-COLLECTION FRAMEWORK-   
I used list and array from java collection framework. 
List was used to rapresent the list of book. 
array was used for temporary operation

-GENERICS-  
Generics was used to manage the books collection


-JAVA I/O
Java input/output was used to mock a database in a txt file. 
This permits me to read and write from a file  

-LOGGING-  
Logging was used to take track of internal state or event.
It's used to grant better messages to evenutally new developer.

-JUnit Testing-  
JUnit was used to create automatized test. It was used to manage eventually exception  

#LIMITATION AND FUTURE WORK  
There are a lot of things I can do on this app. 
First I can integrate a payment system to buy/sell book from/for user.   
I can add a login features with hardcoded credentials. I can create two user: admin and normal user with different operation.  

#TEST SUITE  













