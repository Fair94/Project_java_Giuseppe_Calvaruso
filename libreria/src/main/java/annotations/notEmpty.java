package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom annotation: This field cannot be empty or null
 */

 @Target({ElementType.METHOD,ElementType.FIELD})
 @Retention(RetentionPolicy.RUNTIME)

public @interface  notEmpty {
    
}
