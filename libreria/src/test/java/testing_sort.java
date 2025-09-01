import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import giuseppecalvaruso.domain.Genre;
import giuseppecalvaruso.factory_file.Book;
import giuseppecalvaruso.factory_file.standard_book_factory;
import giuseppecalvaruso.strategy.AuthorSorting;
import giuseppecalvaruso.strategy.PriceSorting;
import giuseppecalvaruso.strategy.SortingStrategy;
import giuseppecalvaruso.strategy.TitleSorting;
import giuseppecalvaruso.strategy.YearSorting;

public class testing_sort {
    private List<Book> books;
    private final standard_book_factory factory = new standard_book_factory();

    @BeforeEach
    public void setup (){
        books = new ArrayList<>();
        books.add(factory.createBook("Ei", "111", "Drizzt", 20, 2005, Genre.ROMANCE));
        books.add(factory.createBook("Bi", "222", "Do", 10, 1999, Genre.ADVENTURE));
        books.add(factory.createBook("Si", "333", "Urden", 30, 2010, Genre.HORROR));
    }

    @Test
    public void TestingTitle(){
        SortingStrategy strategy = new TitleSorting();
        strategy.sort(books);
        assertEquals("Bi", books.get(0).getTitle());
        assertEquals("Ei", books.get(1).getTitle());
        assertEquals("Si", books.get(2).getTitle());

    }

    @Test
    public void TestingPrice(){
        SortingStrategy strategy = new PriceSorting();
        strategy.sort(books);

        assertEquals(10, books.get(0).getPrice());
        assertEquals(20, books.get(1).getPrice());
        assertEquals(30, books.get(2).getPrice());


    }

    @Test
    public void TestingYear(){
        SortingStrategy strategy = new YearSorting();
        strategy.sort(books);
        assertEquals(1999, books.get(0).getPublicationYear());
        assertEquals(2005, books.get(1).getPublicationYear());
        assertEquals(2010, books.get(2).getPublicationYear());

    }

    @Test
    public void TestingAuthor(){
        SortingStrategy strategy = new AuthorSorting();
        strategy.sort(books);
        assertEquals("Do", books.get(0).getAuthor());
        assertEquals("Drizzt", books.get(1).getAuthor());
        assertEquals("Urden", books.get(2).getAuthor());

    }
} 
