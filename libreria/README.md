[README.md](https://github.com/user-attachments/files/21982990/README.md)
 # LIBRARY MANAGEMENT APP
 This is a simple library management app built with java.It was built form my Objected Oriented Programming exam, following the examinator's instructions.  
 
 #OVERVIEW
This is simple management system built for library's owner. 
The books are saved in mocked "database". I've used a txt file. 
Through a simple menu, it permit the user to choose the option.  
The project comes from a nightmare of mine: management software. In my work as an IT technician, the biggest problems with backups or changing PCs came precisely from these programs. So I am getting to know my enemy in order to fight it worse. 
The app could be used for other stuff. With minimal change, we can use it for other shop rather than library.


#TECHNOLOGIES AND PATTERN
PATTERN (REQUIRED)    

1)Factory  
2)Composite  
3)Iterator  
4)Exception Shielding  

PATTERN (OPTIONAL)  
1)Facade  
2)Composite  
3)Strategy  
4)Observer  

TECHNOLIGIES(REQUIRED)  

1)Collection Frameworks  
2)Generics  
3)Java I/O  
4)Logging  
5)JUnit Testing (Maven)  

TECHNOLOGIES(OPTIONAL)  
1)STREAM API AND LAMBDAS (PARTIAL, ONLY LAMBDA USE)  
2)CUSTOM ANNOTATIONS  
3)MOCKITO  


#TECHNOLOGIES AND PATTERN: EXPLANATION  
#PATTERN
-FACTORY PATTERN -  
I've used this pattern to abstract the creational process of the book. I've setted up some field, such as title and author and i've used them as a mold to create other books. 

CREATOR (interface): "book_factory.java" exposes "createBook()" method   

PRODUCT(interface): "book.java" rapresents a generic book with all the field. 

CONCRETE PRODUCT: "AdventureBook.java" or other types of book,  rapresents the specific type of the Book.

CONCRETE CREATOR: "standard_book_factory.java" rapresents the real logic to create and validate any concrete product. 

![Factory Pattern](libreria/src/main/diagrams/FACTORY_PATTERN.png)  

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


#OPTIONAL ADVANCED FEATURES  
-FACADE-  
I emplemented FACADE PATTERN because I was going crazy with the functionality of the app. 
With FACADE I create a menu and for every choice there was a subsystem associated (the diagram is not exausistive),
Generally the FACADE  gave a simple interface to the user and do not expose internal functionality

FACADE : "Facade.java" gave to the Main simple method 

SUBSYSTEM: The various subsystem gave function to my app 


![Facade Pattern](diagrams/FACADE_PATTERN.png)  
#CUSTOM ANNOTATIONS 
I've used this optional feature to divide the declarative logic from the procedural logic. 
Using custom annotations is important in order to adding functionality avoiding modifying code  
#MOCKITO
While i was working with junit test, I've introduced Mockito test. 
Mockito permits to isolate soome functionality of the app from third party dependencies and check eventually excepted or unexcepted behaviors

#STREAM API AND LAMBDAS  
I have not fully integrated the streamapi, but i've used lambdas.
Lambdas techonologies permits to reduce the verbosity of java, permits to apply filter logic to the apps and simplify the code avoiding anonymous class.


#SETUP AND EXECUTION INSTRUCTIONS

-Requirements-  

 Java 17 required or newer version.   
 Maven  
 Ide: Visual Studio code  or other

 -Setting up-  

 1)Download repository  
 2)Unzip it  
 3)Verify the structure:  
  pom.xml in libreria folder  
  source code in `src/main/java/giuseppecalvaruso/`  
 4) If you are using IntelliJ verify the project is  
    recognised   as Maven Project


-IDE execution -  
1)Open project with your ide  
2)Go to `Main.java`  
3) Right Click on mouse: run Main  
4) Use app with CLI (Command Line Interface)  

#KNOWN LIMITATIONS AND FUTURE WORK  
Known limits of the apps are surely the fact the rented/not rented works on running app. 
Future works include modifying permanently this field in the mocked database.
Future works includes recognizing an external pheripheral such a barcode reader, facilitating reading and writing information about book.
In the future, the app could introduce a customer management, where every customer has it's own ID. With the ID, the app prints the info, how many books has rented and how many books could the customer rent.
The books have its own price. 
The app could integrate a sort of payment management, introducing payment via cards, paypal, credit and so on. 
The app was not designed solely for books, but is extendable for any product tha has a barcode. 
For example, if we have to run a grocery shops, we could use the genres of the books as foodstuffs (we have of course to change some names)

#TEST SUITE  
The project include a folder test with junit and mockito test
The test classes are located in:  
`src/test/java/giuseppecalvaruso/`  
- `book_factory_mockito_test.java`  
   Uses Mockito to simulate the behavior of a `book_factory` and verify that the `createBook()` method is called with the expected parameters and returns the correct mocked object.  

- `book_manager_test.java`  
   Integration test for reading and writing books to the mock database (`bookdatabase.txt`).  
   Verifies correct persistence of single and multiple books, and proper handling of an empty file.  

- `ExceptionShieldMockitoTest.java`  
   Unit tests for the `Exception_Shield` class using Mockito.  
   Simulates both expected (`InputError`) and unexpected (`RuntimeException`) errors to verify that:
   - The correct logger method is called (`warning` or `severe`)
   - A safe message is returned to the user  

- `ExceptionShieldTest.java`  
   Unit tests for the `Exception_Shield` logic using a real `Logger`.  
   Verifies the shielding behavior in three scenarios: expected error (`InputError`), unexpected error (`RuntimeException`), and no error at all.  

- `FacadeTest.java`  
   Tests the `Facade` class, simulating user input via a `Scanner`.  
   Verifies that invalid inputs (empty title, negative price) trigger `InputError`, and that valid input is accepted without exceptions.  

- `LibraryBookIteratorMockitoTest.java`  
   Tests the `LibraryBookIterator` class using mocked `List` and `Iterator` objects.  
   Verifies correct iteration behavior, including edge case when no elements are left.  
- `LibraryBookIteratorTest.java`  
   Unit tests for the real behavior of `LibraryBookIterator`.  
   Verifies iteration over a real list of books, as well as edge cases such as an empty list or null input.  

- `LibraryTest.java`  
   Tests the `Library` class as a concrete aggregate for the Iterator Pattern.  
   Verifies that a valid iterator is returned and handles the case of an empty library correctly.  

- `MainMenuTest.java`  
   Unit tests for the `Mainmenu` enum.  
   Verifies that valid numeric inputs are correctly mapped to menu options and that invalid inputs return `null` as expected.  

- `print_for_genre_test.java`  
   Tests the `printForGenre<T>` utility class.  
   Verifies that the `print()` method handles null, empty, and valid lists without throwing exceptions.  

- `rentedBooktest.java`  
   Unit tests for the `rentedBook` class, which acts as a leaf in the Composite Pattern.  
   Verifies that the class correctly throws an exception when constructed with `null`, and that the `print()` method works as expected for valid books.
- `rentedBooktest.java`  
   Unit tests for the `rentedBook` class, which acts as a leaf in the Composite Pattern.  
   Verifies that the class correctly throws an exception when constructed with `null`, and that the `print()` method works as expected for valid books.

- `rentedLibraryTest.java`  
   Unit tests for the `rentedLibrary` class, which acts as a composite in the Composite Pattern.  
   Verifies correct handling of book addition/removal, proper response to null inputs, and the behavior of the `isEmpty()` method.  
- `StandardBookFactoryTest.java`  
   Extensive unit tests for the `standard_book_factory` class, validating the correct creation of `Book` objects.  
   Tests both successful cases and all major input validation rules: empty fields, negative values, and null genre handling.  
- `SubBookTest.java`  
   Parameterized test that verifies `Book` creation for all possible `Genre` enum values.  
   Ensures that each genre is correctly assigned by the factory.




























