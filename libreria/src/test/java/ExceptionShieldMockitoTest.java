import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

import giuseppecalvaruso.exception.Exception_Shield;
import giuseppecalvaruso.exception.InputError;

public class ExceptionShieldMockitoTest {

    @Test
    void InputErrorMocked(){
        Logger mockLogger = mock(Logger.class);

        String msg = Exception_Shield.thePolice(()->{throw new InputError("Bad Message");}
        , mockLogger
        , "Testing"
        );

        assertNotNull(msg);
        assertTrue(msg.toLowerCase().contains("Bad message"));


        verify(mockLogger,atLeastOnce()).warning(anyString());
        }


    @Test
    void UnexceptedError(){
        Logger mockLogger = mock(Logger.class);
        String msg = Exception_Shield.thePolice(
            ()->{throw new RuntimeException("Something go wrong");}
            , mockLogger
            , "The testing"
            );

            assertNotNull(msg);
            assertTrue(msg.toLowerCase().contains("not valid"));

            verify(mockLogger, atLeastOnce()).severe(anyString());

    }


  
    
}
