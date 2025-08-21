
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

import giuseppecalvaruso.exception.Exception_Shield;
import giuseppecalvaruso.exception.InputError;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionShieldTest {

    private static final Logger logger = Logger.getLogger(ExceptionShieldTest.class.getName());

    @Test
    void InputErrorShielded(){
        String msg = Exception_Shield.thePolice(
            () -> {throw new InputError("Bad Input");},
            logger,
            "Testing"
        );

        assertNotNull(msg);
        assertTrue(msg.toLowerCase().contains("not valid"),"Excepted shielding message");
    }

    @Test
    void unexceptedError(){
        String msg = Exception_Shield.thePolice(()->{throw new RuntimeException("A beautiful Error");}, logger, "Testing");

         assertNotNull(msg);
         assertTrue(msg.toLowerCase().contains("not valid"),"Excepted shielding message");
    }

    void ImpossibleNoError(){
        String msg = Exception_Shield.thePolice(()->{int a = 1+1;}, logger, "No error here, look in other place ");
    
        assertNull(msg,"No error");
    
}
}
