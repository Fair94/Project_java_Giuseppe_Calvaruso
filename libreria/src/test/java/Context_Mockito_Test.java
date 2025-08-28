import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import giuseppecalvaruso.domain.Book;
import java.util.List;

import org.junit.jupiter.api.Test;

import giuseppecalvaruso.strategy.SortingContext;
import giuseppecalvaruso.strategy.SortingStrategy;

public class Context_Mockito_Test {

    @Test
    public void testingContext(){
        SortingStrategy mockingStrategy = mock(SortingStrategy.class);
        SortingContext context = new SortingContext();

        List<Book> mockedBooks = List.of();
        context.executing(mockedBooks);

        verify(mockingStrategy, times(1)).sort(mockedBooks);
    }
    
}
