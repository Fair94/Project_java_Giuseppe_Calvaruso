package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Positive {
    /**
     * True = price > 0 
     * False = price <0
     * 
     */

     boolean positive() default true;

     String message() default "Int must be positive";
    

}
